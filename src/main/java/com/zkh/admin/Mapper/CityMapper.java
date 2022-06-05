package com.zkh.admin.Mapper;

import com.zkh.admin.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author zkh
 * @date 2022/6/5 -17:46
 */
@Mapper
public interface CityMapper {

    @Select("select * from city where id=#{id}")
    public City selectCityById(@Param("id") Long id);


    //@Insert("insert into city(`name`,`state`,`country`) values(#{name},#{state},#{country})")
    //@Options(useGeneratedKeys = true,keyProperty = "id")
    public void insertCity(City city);
}
