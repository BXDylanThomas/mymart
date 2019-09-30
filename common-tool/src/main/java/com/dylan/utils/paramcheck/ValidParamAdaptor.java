package com.dylan.utils.paramcheck;

import java.lang.reflect.Field;

public interface ValidParamAdaptor {

	boolean isSupport(Field field);

	Object[] paramCheck(Field field, Object value);
}
