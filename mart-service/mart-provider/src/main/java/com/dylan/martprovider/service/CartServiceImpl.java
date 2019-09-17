package com.dylan.martprovider.service;

import com.alibaba.fastjson.JSON;
import com.dylan.CartService;
import com.dylan.constants.GoodsCodeConstants;
import com.dylan.dto.*;
import com.dylan.martprovider.constants.GlobalConstants;
import com.dylan.martprovider.dal.dao.GoodsDao;
import com.dylan.martprovider.dal.entity.Goods;
import com.dylan.martprovider.utils.ExceptionProcessUtil;
import com.dylan.martprovider.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 *
 *购物车统一采取redis缓存
 *
 * @Author : dylan
 * @Date :create in 2019/9/10 17:21
 */
@Service
@Slf4j
public class CartServiceImpl implements CartService {

	@Autowired
	private RedissonClient redissonClient;
	@Autowired
	private GoodsDao goodsDao;

	/**
	 * 用户添加商品到购物车
	 */
	@Override
	public CartAddResponse cartAdd(CartAddRequest cartAddRequest) {
		CartAddResponse cartAddResponse = new CartAddResponse();
		ResponseUtils.setValue(cartAddResponse,GoodsCodeConstants.SUCCESS);
		try {
			cartAddRequest.requestCheck();
			String userItemKey = generatorCartItemKey(cartAddRequest.getUserId());
			boolean exists = redissonClient.getMap(userItemKey).containsKey(cartAddRequest.getGoodsId());
			if (exists){//购物车中已经存在
				String cartJson = redissonClient.getMap(userItemKey).get(cartAddRequest.getGoodsId()).toString();
				CartDto cartDto = JSON.parseObject(cartJson, CartDto.class);
				cartDto.setGoodsNum(cartDto.getGoodsNum().intValue()+cartAddRequest.getGoodsNum().intValue());
				redissonClient.getMap(userItemKey).put(cartAddRequest.getGoodsId(),JSON.toJSON(cartDto).toString());
			}else{
				GoodsQueryRequest goodsQueryRequest = new GoodsQueryRequest();
				goodsQueryRequest.setId(cartAddRequest.getGoodsId());
				List<Goods> goodsList = goodsDao.goodsQueryList(goodsQueryRequest);
				if (goodsList != null && goodsList.size() > 0){
					CartDto cartDto = new CartDto();
					cartDto.setUserId(cartAddRequest.getUserId());
					cartDto.setGoodsId(cartAddRequest.getGoodsId());
					cartDto.setGoodsNum(cartAddRequest.getGoodsNum());
					redissonClient.getMap(userItemKey).put(cartAddRequest.getUserId(),JSON.toJSON(cartDto).toString());
				}
			}
		}catch (Exception e	){
			log.error("CartServiceImpl cartadd occur exception,this is detail -> "+e);
			ExceptionProcessUtil.exceptionProcessHandle(cartAddResponse,e);
		}
		return cartAddResponse;
	}

	/**
	 * 查询用户购物车清单
	 */
	@Override
	public CartQueryResponse cartQuery(CartQueryRequest cartQueryRequest) {
		CartQueryResponse cartQueryResponse = new CartQueryResponse();
		List<CartDto> cartDtoList = new ArrayList<>();
		ResponseUtils.setValue(cartQueryResponse,GoodsCodeConstants.SUCCESS);
		try{
			cartQueryRequest.requestCheck();
			String userItemKey = generatorCartItemKey(cartQueryRequest.getUserId());
			Map<String,String> map = redissonClient.getMap(userItemKey);
			map.values().forEach(obj ->{
				CartDto cartDto = JSON.parseObject(obj.toString(),CartDto.class);
				cartDtoList.add(cartDto);
			});
			cartQueryResponse.setCartDtoList(cartDtoList);
		}catch (Exception e	){
			log.error("CartServiceImpl cartQuery occur exception,this is detail -> "+e);
			ExceptionProcessUtil.exceptionProcessHandle(cartQueryResponse,e);
		}
		return cartQueryResponse;
	}

	/**
	 * 用户删除购物车,通过商品id
	 */
	@Override
	public CartDeleteResponse cartDelete(CartDeleteRequest cartDeleteRequest) {
		CartDeleteResponse cartDeleteResponse = new CartDeleteResponse();
		try{
			RMap<Object, Object> map = redissonClient.getMap(generatorCartItemKey(cartDeleteRequest.getUserId()));
			map.remove(cartDeleteRequest.getGoodsId());
			ResponseUtils.setValue(cartDeleteResponse,GoodsCodeConstants.SUCCESS);
		}catch (Exception e){
			log.error("CartServiceImpl cartDelete occur exception,this is detail -> "+e);
			ExceptionProcessUtil.exceptionProcessHandle(cartDeleteResponse,e);
		}
		return null;
	}

	/**
	 * 用户 清空购物车
	 */
	@Override
	public CartClearResponse cartClearAll(CartClearRequest cartClearRequest) {
		CartClearResponse cartClearResponse = new CartClearResponse();
		try {
			RMap<Object, Object> map = redissonClient.getMap(generatorCartItemKey(cartClearRequest.getUserId()));
			map.values().forEach(obj ->{
				CartDto cartDto = (CartDto) obj;
				map.remove(cartDto.getGoodsId());
			});
			ResponseUtils.setValue(cartClearResponse,GoodsCodeConstants.SUCCESS);
		}catch (Exception e){
			log.error("CartServiceImpl cartClearAll occur exception,this is detail -> "+e);
			ExceptionProcessUtil.exceptionProcessHandle(cartClearResponse,e);
		}
		return cartClearResponse;
	}

	/**
	 * 用户更新购物车商品信息
	 */
	@Override
	public CartUpdateResponse cartUpdate(CartUpdateRequest cartUpdateRequest) {
		CartUpdateResponse cartUpdateResponse = new CartUpdateResponse();
		try {
			RMap<Object, Object> map = redissonClient.getMap(generatorCartItemKey(cartUpdateRequest.getUserId()));
			Object item = map.get(cartUpdateRequest.getGoodsId());
			if (item != null){
				CartDto cartDto = JSON.parseObject(item.toString(),CartDto.class);
				cartDto.setGoodsNum(cartUpdateRequest.getGoodsNum());
				map.put(cartUpdateRequest.getUserId(),JSON.toJSON(cartDto));
			}
			ResponseUtils.setValue(cartUpdateResponse,GoodsCodeConstants.SUCCESS);
		}catch (Exception e){
			log.error("CartServiceImpl cartUpdate occur exception,this is detail -> "+e);
			ExceptionProcessUtil.exceptionProcessHandle(cartUpdateResponse,e);
		}
		return null;
	}


	private String generatorCartItemKey(Integer userId){
		StringBuilder sb = new StringBuilder(GlobalConstants.CART_ITEM_PREFIX);
		sb.append(":").append(userId);
		return sb.toString();
	}
}
