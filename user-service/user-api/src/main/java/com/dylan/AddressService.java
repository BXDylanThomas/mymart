package com.dylan;

import com.dylan.dto.*;

public interface AddressService {

    UserAbstractResponse addressQuery(AddressQueryRequest addressQueryRequest);

    UserAbstractResponse addressAdd(AddressAddRequest addressAddRequest);

    UserAbstractResponse addressDeleteByUserId(AddressDeleteRequest addressDeleteRequest);

    UserAbstractResponse addressUpdate(AddressUpdateRequest addressUpdateRequest);
}
