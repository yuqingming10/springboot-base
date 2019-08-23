package com.yo.dao;


import com.yo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2019\8\7 0007.
 * 注意：这里引用的包是tk.mybatis.mapper.common.Mapper,通用mapper不能对多表联合操作，
 * 如果想多表，可以用注解形式写SQL，或xml文件形式
 */
@Mapper
public interface CrudUserDao extends tk.mybatis.mapper.common.Mapper<User> {
}
