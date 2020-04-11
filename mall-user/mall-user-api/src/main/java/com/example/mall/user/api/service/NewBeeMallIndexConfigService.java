package com.example.mall.user.api.service;


import com.example.mall.user.api.entity.IndexConfig;
import com.example.mall.user.api.vo.NewBeeMallIndexConfigGoodsVO;
import com.example.mall.util.PageQueryUtil;
import com.example.mall.util.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "mall-user-core")
public interface NewBeeMallIndexConfigService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    @PostMapping("/indexConfig/getConfigsPage")
    PageResult getConfigsPage(@RequestBody PageQueryUtil pageUtil);

    @PostMapping("/indexConfig/saveIndexConfig")
    String saveIndexConfig(@RequestBody IndexConfig indexConfig);

    @PostMapping("/indexConfig/updateIndexConfig")
    String updateIndexConfig(@RequestBody IndexConfig indexConfig);

    @PostMapping("/indexConfig/getIndexConfigById")
    IndexConfig getIndexConfigById(@RequestParam("id") Long id);

    /**
     * 返回固定数量的首页配置商品对象(首页调用)
     *
     * @param number
     * @return
     */
    @PostMapping("/indexConfig/getConfigGoodsesForIndex")
    List<NewBeeMallIndexConfigGoodsVO> getConfigGoodsesForIndex(@RequestParam("configType") int configType,
                                                                @RequestParam("number") int number);

    @PostMapping("/indexConfig/deleteBatch")
    Boolean deleteBatch(@RequestBody Long[] ids);
}
