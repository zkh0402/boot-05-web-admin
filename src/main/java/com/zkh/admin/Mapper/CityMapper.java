package com.zkh.admin.Mapper;

import com.zkh.admin.bean.City;
import org.apache.ibatis.annotations.*;

/**
 * @author zkh
 * @date 2022/6/5 -13:49
 */

/**
 * mybatis最佳实战
 * 引入mybatis-starter
 * 配置application.yml中，指定mapper-location位置即可
 * 编写Mapper接口并标注@Mapper注解
 * 简单方法直接使用注解方式
 * 复杂方法使用mapper.xml进行绑定映射
 *
 */
@Mapper
public interface CityMapper {

    @Select("select * from city where id=#{id}")
    public City selectCityById(@Param("id") Long id);


    @Insert("insert into city(`name`,`state`,`country`) values(#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void insertCity(City city);

}
