package com.example.mall.goods.api.dto;

import com.example.mall.goods.api.vo.NewBeeMallShoppingCartItemVO;
import com.example.mall.vo.NewBeeMallUserVO;

import java.util.List;

/**
 * @author 言曌
 * @date 2020/3/29 4:37 下午
 */

public class SaveOrderDTO {

    private NewBeeMallUserVO user;
    private List<NewBeeMallShoppingCartItemVO> myShoppingCartItems;

    public NewBeeMallUserVO getUser() {
        return user;
    }

    public void setUser(NewBeeMallUserVO user) {
        this.user = user;
    }

    public List<NewBeeMallShoppingCartItemVO> getMyShoppingCartItems() {
        return myShoppingCartItems;
    }

    public void setMyShoppingCartItems(List<NewBeeMallShoppingCartItemVO> myShoppingCartItems) {
        this.myShoppingCartItems = myShoppingCartItems;
    }
}
