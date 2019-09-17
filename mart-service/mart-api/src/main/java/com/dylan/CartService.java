package com.dylan;

import com.dylan.dto.*;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/10 17:18
 */
public interface CartService {

	CartAddResponse cartAdd(CartAddRequest cartAddRequest);

	CartQueryResponse cartQuery(CartQueryRequest cartQueryRequest);

	CartDeleteResponse cartDelete(CartDeleteRequest cartDeleteRequest);

	CartClearResponse cartClearAll(CartClearRequest cartClearRequest);

	CartUpdateResponse cartUpdate(CartUpdateRequest cartUpdateRequest);
}
