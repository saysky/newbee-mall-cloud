package com.example.mall.goods.api.service;

import com.example.mall.goods.api.entity.GoodsCategory;
import com.example.mall.goods.api.vo.NewBeeMallIndexCategoryVO;
import com.example.mall.goods.api.vo.SearchPageCategoryVO;
import com.example.mall.util.PageQueryUtil;
import com.example.mall.util.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "mall-goods-core")
public interface NewBeeMallCategoryService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    @PostMapping("/category/getCategorisPage")
    PageResult getCategorisPage(@RequestBody PageQueryUtil pageUtil);

    @PostMapping("/category/saveCategory")
    String saveCategory(@RequestBody GoodsCategory goodsCategory);

    @PostMapping("/category/updateGoodsCategory")
    String updateGoodsCategory(@RequestBody GoodsCategory goodsCategory);

    @PostMapping("/category/getGoodsCategoryById")
    GoodsCategory getGoodsCategoryById(@RequestParam("id") Long id);

    @PostMapping("/category/deleteBatch")
    Boolean deleteBatch(@RequestBody Integer[] ids);

    /**
     * 返回分类数据(首页调用)
     *
     * @return
     */
    @PostMapping("/category/getCategoriesForIndex")
    List<NewBeeMallIndexCategoryVO> getCategoriesForIndex();

    /**
     * 返回分类数据(搜索页调用)
     *
     * @param categoryId
     * @return
     */
    @PostMapping("/category/getCategoriesForSearch")
    SearchPageCategoryVO getCategoriesForSearch(@RequestParam("categoryId") Long categoryId);

    /**
     * 根据parentId和level获取分类列表
     *
     * @param parentIds
     * @param categoryLevel
     * @return
     */
    @PostMapping("/category/selectByLevelAndParentIdsAndNumber")
    List<GoodsCategory> selectByLevelAndParentIdsAndNumber(@RequestParam("parentIds") List<Long> parentIds,
                                                           @RequestParam("categoryLevel") int categoryLevel);
}
