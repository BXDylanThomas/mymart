package com.dylan.userprovidersss.converter;

import com.dylan.dto.AddressDto;
import com.dylan.dto.AddressQueryResponse;
import com.dylan.dto.LoginResponse;
import com.dylan.userprovidersss.dal.model.Address;
import com.dylan.userprovidersss.dal.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/5 11:32
 */
@Mapper(componentModel = "spring")
public interface AddressConverter {
    AddressConverter INSTANCE = Mappers.getMapper(AddressConverter.class);

    @Mappings({})
    AddressDto addressList(Address address);

    List<AddressDto> addressList(List<Address> addresses);
}
