package com.zkh.admin.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zkh.admin.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zkh
 * @date 2022/6/5 -15:48
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
