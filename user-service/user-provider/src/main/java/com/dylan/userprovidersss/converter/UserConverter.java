package com.dylan.userprovidersss.converter;

import com.dylan.dto.LoginResponse;
import com.dylan.userprovidersss.dal.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/5 11:32
 */
@Mapper(componentModel = "spring")
public interface UserConverter  {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    @Mappings({})
    LoginResponse userConverter(User user);
}
