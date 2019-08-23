package com.yo.service;

import com.yo.dao.CrudUserDao;
import com.yo.dao.OldUserDao;
import com.yo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2019\8\7 0007.
 */
@Service
public class UserService {

    @Autowired
    private CrudUserDao crudUserDao;

    @Autowired
    private OldUserDao oldUserDao;

    public User queryUser(Integer id){
        User user = new User();
        user.setId(id);
        List<User> userList = crudUserDao.select(user);


        return userList==null? null : userList.get(0);
    }


    //整合了事务，只是加了注解 @Transactional   （对于多数据源，要进一步研究）
    @Transactional
    public List<User> oldUserQuery(){
        List<User> userList = oldUserDao.oldQueryUser();
        User byid = oldUserDao.findByid();
/*
        User user = new User();
        user.setId(4);
        user.setAge(32);
        user.setName("timmingyo");
        user.setPwd("qiuqiu");
        int insert = crudUserDao.insert(user);*/
//测试事物
//        int a=1/0;
        return userList;
    }
}
