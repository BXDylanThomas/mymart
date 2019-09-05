package com.dylan;

import com.dylan.dto.*;

import java.util.List;

public interface AddressService {

    AddressQueryResponse addressQueryByUserid(AddressQueryResponse addressQueryResponse);

    AddressAddResponse addressAdd(AddressAddRequest addressAddRequest);

    AddressDeleteResponse addressDeleteByUserId(AddressDeleteRequest addressDeleteRequest);

    AddressUpdateResponse addressUpdate(AddressUpdateRequest addressUpdateRequest);
}
