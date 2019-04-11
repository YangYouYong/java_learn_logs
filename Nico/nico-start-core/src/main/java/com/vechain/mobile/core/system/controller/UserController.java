package com.vechain.mobile.core.system.controller;

import com.vechain.mobile.core.base.BaseController;
import com.vechain.mobile.core.constants.BaseEnums;
import com.vechain.mobile.core.base.Result;
import com.vechain.mobile.core.system.dto.User;
import com.vechain.mobile.core.system.service.UserService;
import com.vechain.mobile.core.util.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户Controller
 *
 * @version 1.0
 * @author nico
 */
@Api(tags = "用户操作")
@RequestMapping
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation("查找用户列表")
    @GetMapping("/sys/user/queryAll")
    public Result queryAll(){
        List<User> list = userService.selectAll();
        return Results.successWithData(list, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    @ApiOperation("查找单个用户")
    @ApiImplicitParam(name = "userId", value = "用户ID", paramType = "path")
    @GetMapping("/sys/user/queryOne/{userId}")
    public Result queryOne(@PathVariable Long userId){
        User user = userService.get(userId);

        logger.debug("userId:{}, username:{}, birthday:{}",user.getUserId(),user.getUsername(),user.getBirthday());
        logger.info("userId:{}, username:{}, birthday:{}",user.getUserId(),user.getUsername(),user.getBirthday());
        logger.error("userId:{}, username:{}, birthday:{}",user.getUserId(),user.getUsername(),user.getBirthday());

        return Results.successWithData(user);
    }

    @PostMapping("/sys/user/save")
    public Result save(@Valid @RequestBody User user){
        user = userService.insertSelective(user);
        return Results.successWithData(user);
    }

    @PostMapping("/sys/user/update")
    public Result update(@Valid @RequestBody List<User> user){
        user = userService.persistSelective(user);
        return Results.successWithData(user);
    }

    @PostMapping("/sys/user/delete")
    public Result delete(User user){
        userService.delete(user);
        return Results.success();
    }

    @PostMapping("/sys/user/delete/{userId}")
    public Result delete(@PathVariable Long userId){
        userService.delete(userId);
        return Results.success();
    }

}
