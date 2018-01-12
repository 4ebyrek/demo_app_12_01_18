package com.example.Service;

import com.example.Service.DTO.CityDTO;
import com.example.Service.mapper.CityMapper;
import com.example.entity.City;
import com.example.repo.CityDefRepo;
import com.example.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService{

    @Autowired
    CityDefRepo cityDefRepo;

    @Autowired
    CityRepo cityRepo;

    @Autowired
    CityMapper cityMapper;

    City city;

    public CityDTO findById(Long id) {
       city = cityRepo.findByCityId(id);
       return cityMapper.cityToCityDTO(city);
    }
}
