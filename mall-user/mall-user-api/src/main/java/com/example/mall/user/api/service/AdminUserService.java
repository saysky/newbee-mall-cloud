package com.example.mall.user.api.service;


import com.example.mall.user.api.entity.AdminUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mall-user-core")
public interface AdminUserService {

    @PostMapping("/adminUser/login")
    AdminUser login(@RequestParam("userName") String userName,
                    @RequestParam("password") String password);

    /**
     * 获取用户信息
     *
     * @param loginUserId
     * @return
     */
    @PostMapping("/adminUser/getUserDetailById")
    AdminUser getUserDetailById(@RequestParam("loginUserId") Integer loginUserId);

    /**
     * 修改当前登录用户的密码
     *
     * @param loginUserId
     * @param originalPassword
     * @param newPassword
     * @return
     */
    @PostMapping("/adminUser/updatePassword")
    Boolean updatePassword(@RequestParam("loginUserId") Integer loginUserId,
                           @RequestParam("originalPassword") String originalPassword,
                           @RequestParam("newPassword") String newPassword);

    /**
     * 修改当前登录用户的名称信息
     *
     * @param loginUserId
     * @param loginUserName
     * @param nickName
     * @return
     */
    @PostMapping("/adminUser/updateName")
    Boolean updateName(@RequestParam("loginUserId") Integer loginUserId,
                       @RequestParam("loginUserName") String loginUserName,
                       @RequestParam("nickName") String nickName);

}
