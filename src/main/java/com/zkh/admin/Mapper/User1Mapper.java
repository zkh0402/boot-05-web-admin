package com.zkh.admin.Mapper;

import com.zkh.admin.bean.User1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zkh
 * @date 2022/6/5 -11:27
 */
@Mapper
public interface User1Mapper {

    public User1 selectUser1ByUserName(@Param("username") String username);


}
