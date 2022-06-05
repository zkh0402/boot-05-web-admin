package com.zkh.admin.service;

import com.zkh.admin.Mapper.CityMapper;
import com.zkh.admin.bean.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zkh
 * @date 2022/6/5 -13:52
 */
@Service
public class CityService {

    @Autowired
    CityMapper cityMapper;

    public City selectCityById(@Param("id") Long id){
        return cityMapper.selectCityById(id);
    }

    public void insertCity(City city){
         cityMapper.insertCity(city);
    }
}
