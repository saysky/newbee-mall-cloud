package com.example.mall.user.api.service;


import com.example.mall.user.api.entity.Carousel;
import com.example.mall.user.api.vo.NewBeeMallIndexCarouselVO;
import com.example.mall.util.PageQueryUtil;
import com.example.mall.util.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "mall-user-core")
public interface NewBeeMallCarouselService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    @PostMapping("/carousel/getCarouselPage")
    PageResult getCarouselPage(@RequestBody PageQueryUtil pageUtil);

    @PostMapping("/carousel/saveCarousel")
    String saveCarousel(@RequestBody Carousel carousel);

    @PostMapping("/carousel/updateCarousel")
    String updateCarousel(@RequestBody Carousel carousel);

    @PostMapping("/carousel/getCarouselById")
    Carousel getCarouselById(@RequestParam("id") Integer id);

    @PostMapping("/carousel/deleteBatch")
    Boolean deleteBatch(@RequestBody Integer[] ids);

    /**
     * 返回固定数量的轮播图对象(首页调用)
     *
     * @param number
     * @return
     */
    @PostMapping("/carousel/getCarouselsForIndex")
    List<NewBeeMallIndexCarouselVO> getCarouselsForIndex(@RequestParam("number") int number);
}
