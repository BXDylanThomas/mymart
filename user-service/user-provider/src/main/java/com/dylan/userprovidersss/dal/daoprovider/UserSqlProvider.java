package com.dylan.userprovidersss.dal.daoprovider;

import com.dylan.Result.AbstractRequest;
import com.dylan.sqlprovider.AbstractSqlProvidrer;
import com.dylan.userprovidersss.dal.model.User;
import com.dylan.utils.UtilsSqlProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/5 18:25
 */
public class UserSqlProvider extends AbstractSqlProvidrer {
    private String tableName = "user";
    private Class entryClass = User.class;
    private Map<String,String> map = new HashMap<>();

    /**
     *
     * 增
     *
     * @param abstractRequest
     * @return
     */
    @Override
    public  String insertTable(AbstractRequest abstractRequest){
        if (map == null || map.size() == 0){
            map = UtilsSqlProvider.getMap(map,entryClass);
        }
        return UtilsSqlProvider.getInsertSql(tableName,abstractRequest,map);
    }

    /**
     *
     * 删
     *
     * @param abstractRequest
     * @return
     */
    @Override
    public  String deleteTable(AbstractRequest abstractRequest){
        if (map == null || map.size() == 0){
            map = UtilsSqlProvider.getMap(map,entryClass);
        }
        return UtilsSqlProvider.getDeleteSql(tableName,abstractRequest,map);
    }

    /**
     *
     * 改
     *
     * @param abstractRequest
     * @return
     */
    @Override
    public  String updateTable(AbstractRequest abstractRequest,Map<String,String> keyMap){
        if (map == null || map.size() == 0){
            map = UtilsSqlProvider.getMap(map,entryClass);
        }
        return UtilsSqlProvider.getUpdateSql(tableName,abstractRequest,keyMap,map);
    }

    /**
     *
     * 查询
     *
     * @param abstractRequest
     * @return
     */
    @Override
    public String selectTable(AbstractRequest abstractRequest) {
        if (map == null || map.size() == 0){
            map = UtilsSqlProvider.getMap(map,entryClass);
        }
        return UtilsSqlProvider.getSelectSql(tableName,abstractRequest,map);
    }
}
