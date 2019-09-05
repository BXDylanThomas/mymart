package com.dylan.utils;

import com.dylan.Result.AbstractRequest;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/5 21:21
 */
public class UtilsSqlProvider {

    public static Map<String,String> getMap(Map<String,String> map , Class clazz){
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            map.put(field.getName(),"#{"+field.getName()+"}");
        }
        return map;
    }

    public static String getInsertSql(String tableName, AbstractRequest request,Map<String,String> map){
        return new SQL(){
            {
                INSERT_INTO(tableName);
                for (Field field : request.getClass().getDeclaredFields()) {
                    String propName = field.getName();
                    field.setAccessible(true);
                    try {
                        Object value = field.get(request);
                        if (value !=null){
                            VALUES(propName,map.get(propName));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.toString();
    }

    public static String getDeleteSql(String tableName,AbstractRequest request,Map<String,String> map){
        return new SQL(){
            {
                DELETE_FROM(tableName);
                for (Field field : request.getClass().getDeclaredFields()) {
                    String propName = field.getName();
                    field.setAccessible(true);
                    try {
                        Object value = field.get(request);
                        if (value !=null){
                            WHERE(propName+"="+map.get(propName));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.toString();
    }

    public static String getUpdateSql(String tableName,AbstractRequest request,Map<String,String> keyMap,Map<String,String> map){
        return new SQL(){
            {
                UPDATE(tableName);
                for (Field field : request.getClass().getDeclaredFields()) {
                    String propName = field.getName();
                    field.setAccessible(true);
                    try {
                        Object value = field.get(request);
                        if (value !=null){
                            SET(propName+"="+map.get(propName));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                for (Map.Entry<String, String> entry : keyMap.entrySet()) {
                    WHERE(entry.getKey()+"="+map.get(entry.getKey()));
                }
            }
        }.toString();
    }

    public static String getSelectSql(String tableName,AbstractRequest request,Map<String,String> map){
        return new SQL(){
            {
                SELECT("*");
                FROM(tableName);
                for (Field field : request.getClass().getDeclaredFields()) {
                    String propName = field.getName();
                    field.setAccessible(true);
                    try {
                        Object value = field.get(request);
                        if (value !=null){
                            WHERE(propName+"="+map.get(propName));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.toString();
    }
}
