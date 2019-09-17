package com.dylan.martprovider.service;

import com.dylan.GoodsService;
import com.dylan.constants.GoodsCodeConstants;
import com.dylan.dto.*;
import com.dylan.martprovider.converter.GoodsConverter;
import com.dylan.martprovider.dal.dao.GoodsDao;
import com.dylan.martprovider.dal.entity.Goods;
import com.dylan.martprovider.utils.ExceptionProcessUtil;
import com.dylan.martprovider.utils.ResponseUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public GoodsQueryResponse goodsQuery(GoodsQueryRequest goodsQueryRequest) {
        GoodsQueryResponse goodsQueryResponse = new GoodsQueryResponse();
        try{
        	if (goodsQueryRequest.getPage() !=null &&goodsQueryRequest.getPage() >=0 && goodsQueryRequest.getPageSize()>0){
				PageHelper.startPage(goodsQueryRequest.getPage(),goodsQueryRequest.getPageSize());
			}
            List<Goods> goodsList = goodsDao.goodsQueryList(goodsQueryRequest);
            List<GoodsDto> goodsDtos = goodsConverter.goodsDto(goodsList);
            goodsQueryResponse.setGoodsDtoList(goodsDtos);
            PageInfo<GoodsDto> pageInfo = new PageInfo<>(goodsDtos);
            goodsQueryResponse.setTotal(pageInfo.getTotal());
			goodsQueryResponse = (GoodsQueryResponse) ResponseUtils.getResponse(goodsList,goodsQueryResponse, GoodsCodeConstants.SUCCESS,GoodsCodeConstants.SYSTEM_ERROR);
        }catch (Exception e ){
            log.error("userLoginServiceImpl.select occur exception -> "+e);
            ExceptionProcessUtil.exceptionProcessHandle(goodsQueryResponse,e);
        }
		return goodsQueryResponse;
    }

}
