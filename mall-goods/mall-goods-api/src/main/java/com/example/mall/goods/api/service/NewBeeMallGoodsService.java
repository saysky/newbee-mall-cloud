package com.example.mall.goods.api.service;


import com.example.mall.goods.api.entity.NewBeeMallGoods;
import com.example.mall.util.PageQueryUtil;
import com.example.mall.util.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "mall-goods-core")
public interface NewBeeMallGoodsService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    @PostMapping("/goods/getNewBeeMallGoodsPage")
    PageResult getNewBeeMallGoodsPage(@RequestBody PageQueryUtil pageUtil);

    /**
     * 添加商品
     *
     * @param goods
     * @return
     */
    @PostMapping("/goods/saveNewBeeMallGoods")
    String saveNewBeeMallGoods(@RequestBody NewBeeMallGoods goods);

    /**
     * 批量新增商品数据
     *
     * @param newBeeMallGoodsList
     * @return
     */
    @PostMapping("/goods/batchSaveNewBeeMallGoods")
    void batchSaveNewBeeMallGoods(@RequestBody List<NewBeeMallGoods> newBeeMallGoodsList);

    /**
     * 修改商品信息
     *
     * @param goods
     * @return
     */
    @PostMapping("/goods/updateNewBeeMallGoods")
    String updateNewBeeMallGoods(@RequestBody NewBeeMallGoods goods);

    /**
     * 获取商品详情
     *
     * @param id
     * @return
     */
    @PostMapping("/goods/getNewBeeMallGoodsById")
    NewBeeMallGoods getNewBeeMallGoodsById(@RequestParam("id") Long id);

    /**
     * 批量修改销售状态(上架下架)
     *
     * @param ids
     * @return
     */
    @PostMapping("/goods/batchUpdateSellStatus")
    Boolean batchUpdateSellStatus(@RequestParam("ids") Long[] ids,
                                  @RequestParam("sellStatus") int sellStatus);

    /**
     * 商品搜索
     *
     * @param pageUtil
     * @return
     */
    @PostMapping("/goods/searchNewBeeMallGoods")
    PageResult searchNewBeeMallGoods(@RequestBody PageQueryUtil pageUtil);

    @PostMapping("/goods/selectByPrimaryKeys")
    List<NewBeeMallGoods> selectByPrimaryKeys(@RequestBody List<Long> goodsIds);
}
