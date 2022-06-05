package com.zkh.admin.service;

import com.zkh.admin.Mapper.User1Mapper;
import com.zkh.admin.bean.User1;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zkh
 * @date 2022/6/5 -11:34
 */
@Service
public class User1Service {

    @Autowired
    User1Mapper user1Mapper;

    public User1 selectUser1ByUserName(@Param("username") String username){
        return user1Mapper.selectUser1ByUserName(username);
    }

}
