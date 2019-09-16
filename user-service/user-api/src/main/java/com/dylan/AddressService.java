package com.dylan;

import com.dylan.dto.*;

public interface AddressService {

    AddressQueryResponse addressQuery(AddressQueryRequest addressQueryRequest);

    AddressAddResponse addressAdd(AddressAddRequest addressAddRequest);

    AddressDeleteResponse addressDeleteByUserId(AddressDeleteRequest addressDeleteRequest);

    AddressUpdateResponse addressUpdate(AddressUpdateRequest addressUpdateRequest);
}
