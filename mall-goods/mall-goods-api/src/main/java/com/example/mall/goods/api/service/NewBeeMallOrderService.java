package com.example.mall.goods.api.service;


import com.example.mall.goods.api.dto.SaveOrderDTO;
import com.example.mall.goods.api.entity.NewBeeMallOrder;
import com.example.mall.goods.api.vo.NewBeeMallOrderDetailVO;
import com.example.mall.goods.api.vo.NewBeeMallOrderItemVO;
import com.example.mall.util.PageQueryUtil;
import com.example.mall.util.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "mall-goods-core")
public interface NewBeeMallOrderService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    @PostMapping("/goods/getNewBeeMallOrdersPage")
    PageResult getNewBeeMallOrdersPage(@RequestBody PageQueryUtil pageUtil);

    /**
     * 订单信息修改
     *
     * @param newBeeMallOrder
     * @return
     */
    @PostMapping("/goods/updateOrderInfo")
    String updateOrderInfo(@RequestBody  NewBeeMallOrder newBeeMallOrder);

    /**
     * 配货
     *
     * @param ids
     * @return
     */
    @PostMapping("/goods/checkDone")
    String checkDone(@RequestParam("ids") Long[] ids);

    /**
     * 出库
     *
     * @param ids
     * @return
     */
    @PostMapping("/goods/checkOut")
    String checkOut(@RequestParam("ids") Long[] ids);

    /**
     * 关闭订单
     *
     * @param ids
     * @return
     */
    @PostMapping("/goods/closeOrder")
    String closeOrder(@RequestParam("ids") Long[] ids);

    /**
     * 保存订单
     *
     * @param saveOrderDTO
     * @return
     */
    @PostMapping("/goods/saveOrder")
    String saveOrder(@RequestBody SaveOrderDTO saveOrderDTO);

    /**
     * 获取订单详情
     *
     * @param orderNo
     * @param userId
     * @return
     */
    @PostMapping("/goods/getOrderDetailByOrderNo")
    NewBeeMallOrderDetailVO getOrderDetailByOrderNo(@RequestParam("orderNo") String orderNo,
                                                    @RequestParam("userId") Long userId);

    /**
     * 获取订单详情
     *
     * @param orderNo
     * @return
     */
    @PostMapping("/goods/getNewBeeMallOrderByOrderNo")
    NewBeeMallOrder getNewBeeMallOrderByOrderNo(@RequestParam("orderNo") String orderNo);

    /**
     * 我的订单列表
     *
     * @param pageUtil
     * @return
     */
    @PostMapping("/goods/getMyOrders")
    PageResult getMyOrders(@RequestBody PageQueryUtil pageUtil);

    /**
     * 手动取消订单
     *
     * @param orderNo
     * @param userId
     * @return
     */
    @PostMapping("/goods/cancelOrder")
    String cancelOrder(@RequestParam("orderNo") String orderNo,
                       @RequestParam("userId") Long userId);

    /**
     * 确认收货
     *
     * @param orderNo
     * @param userId
     * @return
     */
    @PostMapping("/goods/finishOrder")
    String finishOrder(@RequestParam("orderNo") String orderNo,
                       @RequestParam("userId") Long userId);

    @PostMapping("/goods/paySuccess")
    String paySuccess(@RequestParam("orderNo") String orderNo, @RequestParam("payType") int payType);

    @PostMapping("/goods/getOrderItems")
    List<NewBeeMallOrderItemVO> getOrderItems(@RequestParam("id") Long id);
}
