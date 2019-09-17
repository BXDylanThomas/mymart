package com.dylan.martprovider.utils;

import com.dylan.Result.AbstractResponse;
import com.dylan.constants.GoodsCodeConstants;

import java.util.List;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/6 16:35
 */
public class ResponseUtils {

    public static AbstractResponse getResponse(Object object, AbstractResponse abstractResponse, GoodsCodeConstants successConstants, GoodsCodeConstants failConstants){
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


    private static AbstractResponse parse(int result, AbstractResponse abstractResponse,GoodsCodeConstants successConstants,GoodsCodeConstants failConstants){
		return result > 0 ? ResponseUtils.setValue(abstractResponse,successConstants):ResponseUtils.setValue(abstractResponse,failConstants);
    }

    private static AbstractResponse parse(List result, AbstractResponse abstractResponse,GoodsCodeConstants successConstants,GoodsCodeConstants failConstants){
		return result == null ||result.size() ==0 ? ResponseUtils.setValue(abstractResponse,failConstants):ResponseUtils.setValue(abstractResponse,successConstants);
    }

    private static AbstractResponse parse(Object result, AbstractResponse abstractResponse,GoodsCodeConstants successConstants,GoodsCodeConstants failConstants){
        return result == null?ResponseUtils.setValue(abstractResponse,failConstants):ResponseUtils.setValue(abstractResponse,successConstants);
    }

    public static AbstractResponse setValue(AbstractResponse abstractResponse,GoodsCodeConstants goodsCodeConstants){
		abstractResponse.setCode(goodsCodeConstants.getCode());
		abstractResponse.setMsg(goodsCodeConstants.getMessage());
		return abstractResponse;
	}

}
