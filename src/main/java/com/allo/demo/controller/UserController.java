package com.allo.demo.controller;

import com.google.gson.Gson;
import com.allo.demo.dao.UserDao;
import com.allo.demo.entity.UserDomain;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "用户类控制器", tags = "用户类控制器")
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping("")
    public ResponseEntity addUser(
            @RequestParam(value = "userName", required = true)
                    String userName,
            @RequestParam(value = "password", required = true)
                    String password,
            @RequestParam(value = "phone", required = false)
                    String phone
    ) {
        UserDomain userDomain = new UserDomain();
        userDomain.setUserName(userName);
        userDomain.setPassword(password);
        userDomain.setPhone(phone);
        return ResponseEntity.ok("添加成功");
    }

    @DeleteMapping("")
    public ResponseEntity deleteUser(@RequestParam(value = "userId", required = true) Integer userId) {
        userDao.deleteUserById(userId);
        return ResponseEntity.ok("删除成功");
    }

    @PutMapping("")
    public ResponseEntity updateUser(
            @RequestParam(value = "userId", required = true)
                    Integer userId,
            @RequestParam(value = "userName", required = false)
                    String userName,
            @RequestParam(value = "password", required = false)
                    String password,
            @RequestParam(value = "phone", required = false)
                    String phone
    ) {
        UserDomain userDomain = new UserDomain();
        userDomain.setUserId(userId);
        userDomain.setUserName(userName);
        userDomain.setPassword(password);
        userDomain.setPhone(phone);
        userDao.updateUser(userDomain);
        return ResponseEntity.ok("更新成功");
    }

    @GetMapping("a")
    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    public ResponseEntity getUsers() {
        List<UserDomain> userDomains = userDao.selectList(null);
        Gson gson = new Gson();
        String s = gson.toJson(userDomains);
        System.out.println(s);
        return ResponseEntity.ok(userDomains);
    }
}