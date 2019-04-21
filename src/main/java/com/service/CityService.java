package com.service;

import com.entity.City;

import java.util.List;

public interface CityService {
    public List<City> findCityByProvinceID(String provinceID);
}
