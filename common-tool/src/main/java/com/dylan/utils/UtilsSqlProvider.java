package com.dylan.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/5 21:21
 */
@Slf4j
public class UtilsSqlProvider {

    /**
     * 获取对应的  column 和 #{column}
     *
     * @param map
     * @param clazz
     * @return
     */
    public static Map<String,String> getMap(Map<String,String> map , Class clazz){
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            map.put(field.getName(),"#{"+field.getName()+"}");
        }
        return map;
    }

    /**
     * 单条插入
     *
     * @param tableName
     * @param request
     * @param map
     * @return
     */
    public static String getInsertSql(String tableName, Object request,Map<String,String> map){
        String result = new SQL() {
            {
                INSERT_INTO(tableName);
                for (Field field : request.getClass().getDeclaredFields()) {
                    String propName = field.getName();
                    field.setAccessible(true);
                    try {
                        Object value = field.get(request);
                        if (value != null) {
                            VALUES(propName, map.get(propName));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.toString();
        log.info("insertsql -> "+result);
        return result;
    }

    public static String getDeleteSql(String tableName,Object request,Map<String,String> map){
        String result = new SQL(){
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
        log.info("deletesql -> "+result);
        return result;
    }

    /**
     *
     * @param tableName 表名
     * @param request 参数
     * @param keyList where 后的条件
     * @param map  对应的 column 和 #{column}
     * @return
     */
    public static String getUpdateSql(String tableName,Object request,String[] keyList,Map<String,String> map){
        String result = new SQL(){
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
                for (String key : keyList) {
                    WHERE(key+"="+map.get(key));
                }
            }
        }.toString();
        log.info("updatesql -> "+result);
        return result;
    }

    /**
     *
     * @param tableName  表名
     * @param request 参数
     * @param selectColumn  查询列名
     * @param map 对应的 column 和 #{column}
     * @return
     */
    public static String getSelectSql(String tableName, Object request, List<String> selectColumn, Map<String,String> map){
        String result = new SQL(){
            {
                if (selectColumn !=null && selectColumn.size()>0){
                    for (String column : selectColumn) {
                        SELECT(column);
                    }
                }else{
                    SELECT("*");
                }
                FROM(tableName);
                for (Field field : request.getClass().getDeclaredFields()) {
                    String propName = field.getName();
                    if (!propName.startsWith("page")){
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
            }
        }.toString();
        log.info("selectsql -> "+result);
        return result;
    }
}
