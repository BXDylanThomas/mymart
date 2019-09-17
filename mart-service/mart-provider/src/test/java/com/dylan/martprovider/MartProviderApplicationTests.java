package com.dylan.martprovider;

import com.dylan.CartService;
import com.dylan.GoodsService;
import com.dylan.dto.*;
import com.dylan.martprovider.bootstrap.MartProviderApplication;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MartProviderApplication.class)
public class MartProviderApplicationTests {

    @Autowired
    private CartService cartService;
    @Autowired
    private GoodsService goodsService;
    @Test
    public void contextLoads() {
        CartAddRequest cartAddRequest = new CartAddRequest();
        cartAddRequest.setUserId(1);
        cartAddRequest.setGoodsId(1);
        cartAddRequest.setGoodsNum(10);
        CartAddResponse cartAddResponse = cartService.cartAdd(cartAddRequest);
        System.out.println(cartAddResponse.toString());
    }

    @Test
    public void getCart() {
        CartQueryRequest cartQueryRequest = new CartQueryRequest();
        cartQueryRequest.setUserId(1);
        CartQueryResponse cartQueryResponse = cartService.cartQuery(cartQueryRequest);
        cartQueryResponse.getCartDtoList().forEach(obj ->{
            System.out.println(obj.toString());
        });
    }

    @Test
    public void getGoods(){
        GoodsQueryRequest goodsQueryRequest = new GoodsQueryRequest();
        GoodsQueryResponse goodsQueryResponse = goodsService.goodsQuery(goodsQueryRequest);
        goodsQueryResponse.getGoodsDtoList().forEach(obj ->{
            System.out.println(obj.toString());
        });
    }
}
