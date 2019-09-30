package com.dylan.martprovider.dal.dao;

import com.dylan.Result.AbstractRequest;
import com.dylan.constants.SqlMethodConstants;
import com.dylan.dto.GoodsDto;
import com.dylan.martprovider.dal.daoprovider.GoodsSqlProvider;
import com.dylan.martprovider.dal.entity.Goods;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/9 10:34
 */
@Repository
public interface GoodsDao {

    @SelectProvider(type = GoodsSqlProvider.class,method = SqlMethodConstants.SELECTTABLE)
    Goods goodsQueryList(AbstractRequest abstractRequest);

    @SelectProvider(type = GoodsSqlProvider.class,method = SqlMethodConstants.SELECTTABLE)
    List<Goods> goodsAllQueryList(AbstractRequest abstractRequest);

}
