package com.dylan.martprovider.service;

import com.alibaba.fastjson.JSON;
import com.dylan.GoodsService;
import com.dylan.constants.MartCodeConstants;
import com.dylan.dto.*;
import com.dylan.martprovider.constants.GlobalConstants;
import com.dylan.martprovider.converter.GoodsConverter;
import com.dylan.martprovider.dal.dao.GoodsDao;
import com.dylan.martprovider.dal.entity.Goods;
import com.dylan.martprovider.service.cashmanager.CashManager;
import com.dylan.martprovider.utils.ResponseUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/9 11:24
 */
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private GoodsConverter goodsConverter;
    @Autowired
	private CashManager cashManager;

	/**
	 * 查询的单个商品
	 * 并放入redis缓存，过期时间1天
	 */
	@Override
    public GoodsQueryResponse goodsQuery(GoodsQueryRequest goodsQueryRequest) {
        GoodsQueryResponse goodsQueryResponse = new GoodsQueryResponse();
        try{
			String json = cashManager.checkCash(generatorCartItemKey(goodsQueryRequest.getId()));
			if (StringUtils.isNotBlank(json)){
				GoodsDto goodsDto = JSON.parseObject(json,GoodsDto.class);
				goodsQueryResponse.setGoodsDto(goodsDto);
				goodsQueryResponse = (GoodsQueryResponse) ResponseUtils.getResponse(goodsDto,goodsQueryResponse, MartCodeConstants.SUCCESS, MartCodeConstants.SYSTEM_ERROR);
				return goodsQueryResponse;
			}
            Goods goodsList = goodsDao.goodsQueryList(goodsQueryRequest);
            GoodsDto goodsDtos = goodsConverter.goodsDto(goodsList);
            goodsQueryResponse.setGoodsDto(goodsDtos);
			//设置缓存
			cashManager.setCash(generatorCartItemKey(goodsQueryRequest.getId()),JSON.toJSON(goodsDtos).toString(),GlobalConstants.ITEM_EXPIRE);
			goodsQueryResponse = (GoodsQueryResponse) ResponseUtils.getResponse(goodsList,goodsQueryResponse, MartCodeConstants.SUCCESS, MartCodeConstants.SYSTEM_ERROR);
        }catch (Exception e ){
            log.error("userLoginServiceImpl.select occur exception -> "+e);
            ExceptionProcessUtil.exceptionProcessHandle(goodsQueryResponse,e);
        }
		return goodsQueryResponse;
    }

	/**
	 * 查询所有商品
	 */
	@Override
	public GoodsAllQueryResponse goodsAllQuery(GoodsAllQueryRequest goodsAllQueryRequest) {
		GoodsAllQueryResponse goodsAllQueryResponse = new GoodsAllQueryResponse();
		try{
			if (goodsAllQueryRequest.getPage() !=null &&goodsAllQueryRequest.getPage() >=0 && goodsAllQueryRequest.getPageSize()>0){
				PageHelper.startPage(goodsAllQueryRequest.getPage(),goodsAllQueryRequest.getPageSize());
			}
			List<Goods> goodsList = goodsDao.goodsAllQueryList(goodsAllQueryRequest);
			List<GoodsDto> goodsDtos = goodsConverter.goodsDto(goodsList);
			goodsAllQueryResponse.setGoodsDtoList(goodsDtos);
			PageInfo<GoodsDto> pageInfo = new PageInfo<>(goodsDtos);
			goodsAllQueryResponse.setTotal(pageInfo.getTotal());
			goodsAllQueryResponse = (GoodsAllQueryResponse) ResponseUtils.getResponse(goodsList,goodsAllQueryResponse, MartCodeConstants.SUCCESS, MartCodeConstants.SYSTEM_ERROR);
		}catch (Exception e ){
			log.error("userLoginServiceImpl.select occur exception -> "+e);
			ExceptionProcessUtil.exceptionProcessHandle(goodsAllQueryResponse,e);
		}
		return goodsAllQueryResponse;
	}

	private String generatorCartItemKey(Integer goodId){
		StringBuilder sb = new StringBuilder(GlobalConstants.GOODS_CACHE_PREFIX);
		sb.append(":").append(goodId);
		return sb.toString();
	}

}
