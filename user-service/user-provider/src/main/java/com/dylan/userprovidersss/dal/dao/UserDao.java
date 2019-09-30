package com.dylan.userprovidersss.dal.dao;

import com.dylan.Result.AbstractRequest;
import com.dylan.constants.SqlMethodConstants;
import com.dylan.userprovidersss.dal.daoprovider.UserSqlProvider;
import com.dylan.userprovidersss.dal.model.User;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/4 21:29
 */
@Repository
public interface UserDao {

    @InsertProvider(type = UserSqlProvider.class,method = SqlMethodConstants.INSERTTABLE )
    Integer insert(AbstractRequest abstractRequest);

    @SelectProvider(type = UserSqlProvider.class,method = SqlMethodConstants.SELECTTABLE)
    User select(AbstractRequest abstractRequest);

    @UpdateProvider(type = UserSqlProvider.class,method = SqlMethodConstants.UPDATETABLE)
    Integer update(AbstractRequest abstractRequest);

    @Select("select * from user where username=#{userName}")
    User isExistsUserName(String userName);


}
