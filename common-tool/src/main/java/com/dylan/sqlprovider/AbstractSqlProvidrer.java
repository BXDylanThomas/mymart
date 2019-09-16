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
public interface AbstractSqlProvidrer {


   String insertTable(AbstractRequest abstractRequest);

   String deleteTable(AbstractRequest abstractRequest);

    String updateTable(AbstractRequest abstractRequest);

    String selectTable(AbstractRequest abstractRequest);
}
