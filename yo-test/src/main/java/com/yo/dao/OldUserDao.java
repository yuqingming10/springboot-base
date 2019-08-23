package com.yo.dao;

import com.yo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2019\8\8 0008.
 *
 *
 * 注意要想在这里用其他注解如@Repository或@Component,则要在引导类上加上注解@MapperScan("com.yo.dao")
 */
@Mapper
public interface OldUserDao {
    //以xml文件操作（userMapper.xml）
    List<User> oldQueryUser();

    //以注解的形式操作表
    @Select("select * from user where id=3")
    User findByid();
}
