package com.dylan.sqlprovider;

import com.dylan.Result.AbstractRequest;
import com.dylan.utils.UtilsSqlProvider;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/16 20:27
 */
public class BaseSqlProvider<T> implements AbstractSqlProvidrer {

	private String tableName = "";
	private String[] key = null;
	private Class entryClass = null;
	private Map<String,String> map = new HashMap<>();


	/**
	 * 增
	 */
	@Override
	public String insertTable(AbstractRequest abstractRequest) {
		return UtilsSqlProvider.getInsertSql(getTableName(),abstractRequest,getMap());
	}

	/**
	 * 删
	 */
	@Override
	public String deleteTable(AbstractRequest abstractRequest) {
		return UtilsSqlProvider.getDeleteSql(getTableName(),abstractRequest,getMap());
	}

	/**
	 * 更新
	 */
	@Override
	public String updateTable(AbstractRequest abstractRequest) {
		return UtilsSqlProvider.getUpdateSql(getTableName(),abstractRequest,getKey(),getMap());
	}

	/**
	 * 查
	 */
	@Override
	public String selectTable(AbstractRequest abstractRequest) {
		return UtilsSqlProvider.getSelectSql(getTableName(),abstractRequest,null,getMap());
	}

	/**
	 * 获取主键
	 */
	private String[] getKey(){
		Class entityClass = getEntityClass();
		Field[] declaredFields = entityClass.getDeclaredFields();
		for (Field field : declaredFields) {
			if (field.isAnnotationPresent(MyId.class)){
				key[0] = field.getName();
			}
		}
		return key;
	}

	private Map<String,String> getMap(){
		if (map == null || map.size() == 0){
			UtilsSqlProvider.getMap(map,getEntityClass());
		}
		return map;
	}

	private Class getEntityClass(){
		if (entryClass == null){
			String className = getClassName();
			try {
				entryClass = Class.forName(className);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return entryClass;
	}
	/**
	 * 获取表 table名
	 */
	private String getTableName(){
		tableName = getStringLast(getClassName(),".").toLowerCase();
		return tableName;
	}

	private String getClassName(){
		Type superClass = this.getClass().getGenericSuperclass();
		String name = superClass.getTypeName();
		String clazz = name.substring(name.indexOf("<")+1,name.indexOf(">"));
		return clazz;
	}

	private String getStringLast(String str,String regex){
		return str.substring(str.lastIndexOf(regex)+1);
	}
}
