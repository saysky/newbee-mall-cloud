package com.example.mall.user.api.service;

import com.example.mall.user.api.entity.MallUser;
import com.example.mall.vo.NewBeeMallUserVO;
import com.example.mall.util.PageQueryUtil;
import com.example.mall.util.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "mall-user-core")
public interface NewBeeMallUserService {

    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    @PostMapping("/user/getNewBeeMallUsersPage")
    PageResult getNewBeeMallUsersPage(@RequestBody PageQueryUtil pageUtil);

    /**
     * 用户注册
     *
     * @param loginName
     * @param password
     * @return
     */
    @PostMapping("/user/register")
    String register(@RequestParam("loginName") String loginName,
                    @RequestParam("password") String password);


    /**
     * 用户信息修改并返回最新的用户信息
     *
     * @param mallUser
     * @return
     */
    @PostMapping("/user/mallUser")
    NewBeeMallUserVO updateUserInfo(@RequestBody MallUser mallUser);

    /**
     * 用户禁用与解除禁用(0-未锁定 1-已锁定)
     *
     * @param ids
     * @param lockStatus
     * @return
     */
    @PostMapping("/user/lockUsers")
    Boolean lockUsers(@RequestParam("ids") Integer[] ids,
                      @RequestParam("lockStatus") int lockStatus);

    @PostMapping("/user/selectByLoginNameAndPasswd")
    MallUser selectByLoginNameAndPasswd(@RequestParam("loginName") String loginName,
                                        @RequestParam("password") String password);
}
