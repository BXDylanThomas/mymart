package com.dylan;

import com.dylan.dto.*;

import java.util.List;

public interface GoodsService {

	GoodsQueryResponse goodsQuery(GoodsQueryRequest goodsQueryRequest);

	GoodsAllQueryResponse goodsAllQuery(GoodsAllQueryRequest goodsAllQueryRequest);

}
