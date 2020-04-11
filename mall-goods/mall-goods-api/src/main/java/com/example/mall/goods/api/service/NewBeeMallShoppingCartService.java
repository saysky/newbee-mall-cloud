package com.example.mall.goods.api.service;


import com.example.mall.goods.api.entity.NewBeeMallShoppingCartItem;
import com.example.mall.goods.api.vo.NewBeeMallShoppingCartItemVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "mall-goods-core")
public interface NewBeeMallShoppingCartService {

    /**
     * 保存商品至购物车中
     *
     * @param newBeeMallShoppingCartItem
     * @return
     */
    @PostMapping("/cart/saveNewBeeMallCartItem")
    String saveNewBeeMallCartItem(@RequestBody NewBeeMallShoppingCartItem newBeeMallShoppingCartItem);

    /**
     * 修改购物车中的属性
     *
     * @param newBeeMallShoppingCartItem
     * @return
     */
    @PostMapping("/cart/updateNewBeeMallCartItem")
    String updateNewBeeMallCartItem(@RequestBody NewBeeMallShoppingCartItem newBeeMallShoppingCartItem);

    /**
     * 获取购物项详情
     *
     * @param newBeeMallShoppingCartItemId
     * @return
     */
    @PostMapping("/cart/getNewBeeMallCartItemById")
    NewBeeMallShoppingCartItem getNewBeeMallCartItemById(@RequestParam("newBeeMallShoppingCartItemId") Long newBeeMallShoppingCartItemId);

    /**
     * 删除购物车中的商品
     *
     * @param newBeeMallShoppingCartItemId
     * @return
     */
    @PostMapping("/cart/deleteById")
    Boolean deleteById(@RequestParam("newBeeMallShoppingCartItemId") Long newBeeMallShoppingCartItemId);

    /**
     * 获取我的购物车中的列表数据
     *
     * @param newBeeMallUserId
     * @return
     */
    @PostMapping("/cart/getMyShoppingCartItems")
    List<NewBeeMallShoppingCartItemVO> getMyShoppingCartItems(@RequestParam("newBeeMallUserId") Long newBeeMallUserId);


    @PostMapping("/cart/selectCountByUserId")
    int selectCountByUserId(@RequestParam("newBeeMallUserId") Long newBeeMallUserId);
}
