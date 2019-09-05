package com.dylan.userprovidersss.dal.dao;

import com.dylan.constants.SqlMethodConstants;
import com.dylan.userprovidersss.dal.model.Address;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao {
    Class clazz = Address.class;

    @InsertProvider(type = clazz,method = SqlMethodConstants.INSERTTABLE)
    Integer addressAdd(Address address);

    @DeleteProvider(type = clazz,method = SqlMethodConstants.DELETETABLE)
    Integer addressDeleteByAddressId(String addressId);

    @UpdateProvider(type = clazz,method = SqlMethodConstants.UPDATETABLE)
    Integer addressUpdate(Address address);

    @SelectProvider(type = clazz,method = SqlMethodConstants.SELECTTABLE)
    List<Address> addressQueryByUserId(String userId);

}
