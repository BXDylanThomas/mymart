package com.dylan.userprovidersss.dal.dao;

import com.dylan.constants.SqlMethodConstants;
import com.dylan.dto.LoginRequest;
import com.dylan.dto.RegisterRequest;
import com.dylan.userprovidersss.dal.daoprovider.UserSqlProvider;
import com.dylan.userprovidersss.dal.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/4 21:29
 */
@Repository
public interface UserDao {
    Class clazz = UserSqlProvider.class;

    @InsertProvider(type = clazz,method = SqlMethodConstants.INSERTTABLE )
    Integer insert(RegisterRequest registerRequest);

    @SelectProvider(type = clazz,method = SqlMethodConstants.SELECTTABLE)
    User login(LoginRequest loginRequest);

    @Select("select * from user where username=#{userName}")
    User isExistsUserName(String userName);


}
