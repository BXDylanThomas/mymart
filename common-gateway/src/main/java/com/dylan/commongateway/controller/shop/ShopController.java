package com.dylan.commongateway.controller.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * code is far away from bug with the animal protecting

 * @Author : dylan
 * @Date :create in 2019/9/4 14:47
 */
@Controller
@RequestMapping("/shop")
public class ShopController {

    @RequestMapping("/main")
    public String toMainShop(){
        return "goods/main";
    }
}
