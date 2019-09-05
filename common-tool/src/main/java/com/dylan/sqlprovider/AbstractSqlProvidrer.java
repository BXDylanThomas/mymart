package com.dylan.sqlprovider;

import com.dylan.Result.AbstractRequest;
import com.dylan.utils.UtilsSqlProvider;

import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/5 21:40
 */
public abstract class AbstractSqlProvidrer {

    protected String tableName;
    protected Class entryClass;
    protected Map<String,String> map;


    public abstract String insertTable(AbstractRequest abstractRequest);

    public abstract String deleteTable(AbstractRequest abstractRequest);

    public abstract String updateTable(AbstractRequest abstractRequest,Map<String,String> keyMap);

    public abstract String selectTable(AbstractRequest abstractRequest);
}
