package com.yo.controller;

import com.yo.pojo.User;
import com.yo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2019\8\7 0007.
 */
@Controller
@RequestMapping("user")
public class firstController {
    private static final Logger LOG = LoggerFactory.getLogger(firstController.class);

    @Autowired
    private UserService userService;

    // post请求
    @RequestMapping(value = "query")
    @ResponseBody
    public List<User> queryUser(@RequestBody User userl){   //或者 @RequestBody Map dataMap
//        User user = userService.queryUser(userl.getId());

        List<User> userList = userService.oldUserQuery();
        LOG.info("queryUser方法post");
        return userList;
    }
    // get请求
    @RequestMapping("getQuery")
    @ResponseBody
    public User getQuery(@RequestParam("id") String id,@RequestParam String name){
        User user = userService.queryUser(Integer.valueOf(id));
        LOG.info("queryUser方法get"+user);
        return user;
    }

    @RequestMapping("oldQuery")
    public String oldQueryUser(ModelMap modle){

        List<User> users = userService.oldUserQuery();
        modle.addAttribute("users",users);
        LOG.info("oldQueryUser方法"+users);
        return "first";
    }


}
