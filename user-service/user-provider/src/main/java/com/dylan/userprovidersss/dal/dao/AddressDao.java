package com.dylan.userprovidersss.dal.dao;

import com.dylan.Result.AbstractRequest;
import com.dylan.constants.SqlMethodConstants;
import com.dylan.userprovidersss.dal.daoprovider.AddressSqlProvider;
import com.dylan.userprovidersss.dal.model.Address;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao {

    @InsertProvider(type = AddressSqlProvider.class,method = SqlMethodConstants.INSERTTABLE)
    Integer addressAdd(AbstractRequest abstractRequest);

    @DeleteProvider(type = AddressSqlProvider.class,method = SqlMethodConstants.DELETETABLE)
    Integer addressDelete(AbstractRequest abstractRequest);

    @UpdateProvider(type = AddressSqlProvider.class,method = SqlMethodConstants.UPDATETABLE)
    Integer addressUpdate(AbstractRequest abstractRequest);

    @SelectProvider(type = AddressSqlProvider.class,method = SqlMethodConstants.SELECTTABLE)
    List<Address> addressQuery(AbstractRequest abstractRequest);

}
