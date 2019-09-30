package com.dylan.utils;

import com.dylan.Result.AbstractResponse;
import com.dylan.constants.BaseCodeConstants;

import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/6 16:35
 */
public class UtilsResponse<T extends BaseCodeConstants> {

    public static AbstractResponse getResponse(Object object, AbstractResponse abstractResponse, String[] successConstants, String[] failConstants){
        if (object instanceof Integer){
            int i = Integer.parseInt(object.toString());
            abstractResponse = parse(i,abstractResponse,successConstants,failConstants);
        }else if (object instanceof List){
            List list = (List) object;
            abstractResponse = parse(list,abstractResponse,successConstants,failConstants);
        }else{
            abstractResponse = parse(object,abstractResponse,successConstants,failConstants);
        }
        return abstractResponse;
    }


    private static AbstractResponse parse(int result, AbstractResponse abstractResponse,String[] successConstants,String[] failConstants){
		return result > 0 ? UtilsResponse.setValue(abstractResponse,successConstants): UtilsResponse.setValue(abstractResponse,failConstants);
    }

    private static AbstractResponse parse(List result, AbstractResponse abstractResponse, String[] successConstants, String[] failConstants){
		return result == null ||result.size() ==0 ? UtilsResponse.setValue(abstractResponse,failConstants): UtilsResponse.setValue(abstractResponse,successConstants);
    }

    private static AbstractResponse parse(Object result, AbstractResponse abstractResponse,String[] successConstants,String[] failConstants){
		return result == null ? UtilsResponse.setValue(abstractResponse,failConstants): UtilsResponse.setValue(abstractResponse,successConstants);
    }

	private static AbstractResponse setValue(AbstractResponse abstractResponse,String[] codeConstants){
		abstractResponse.setCode(codeConstants[0]);
		abstractResponse.setMsg(codeConstants[1]);
		return abstractResponse;
	}

}
