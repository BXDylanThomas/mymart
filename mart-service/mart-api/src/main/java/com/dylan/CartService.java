package com.dylan;

import com.dylan.dto.*;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/10 17:18
 */
public interface CartService {
	/**
	 * 用户添加购物车
	 * @param cartAddRequest
	 * @return
	 */
	CartAddResponse cartAdd(CartAddRequest cartAddRequest);

	/**
	 * 用户查询购物车清单
	 * @param cartQueryRequest
	 * @return
	 */
	CartQueryResponse cartQuery(CartQueryRequest cartQueryRequest);

	/**
	 * 用户删除购物车商品
	 * @param cartDeleteRequest
	 * @return
	 */
	CartDeleteResponse cartDelete(CartDeleteRequest cartDeleteRequest);

	/**
	 * 用户情况购物车
	 * @param cartClearRequest
	 * @return
	 */
	CartClearResponse cartClearAll(CartClearRequest cartClearRequest);

	/**
	 * 用户更新购物车信息
	 * @param cartUpdateRequest
	 * @return
	 */
	CartUpdateResponse cartUpdate(CartUpdateRequest cartUpdateRequest);
}
