package com.example.Service;

import com.example.Service.DTO.CityDTO;
import com.example.Service.DTO.CityDefDTO;
import com.example.Service.mapper.CityMapper;
import com.example.entity.City;
import com.example.entity.CityDef;
import com.example.repo.CityDefRepo;
import com.example.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CityServiceImpl implements CityService{

    @Autowired
    CityDefRepo cityDefRepo;

    @Autowired
    CityRepo cityRepo;

    @Autowired
    CityMapper cityMapper;


    public CityDTO findById(UUID id) {
        City city = cityRepo.findOne(id);
        UUID cityDefUid = city.getCityDef().getDefId();
        CityDef cityDef = cityDefRepo.findOne(cityDefUid);
       return cityMapper.ToCityDTO(city,cityDef);
    }
/*
    public String saveCityDef(CityDef cityDef) {

        Long city_id = cityDef.getCity().getCityId();

        City city = cityRepo.findByCityId(city_id);

        cityDef.setCity(city);

        CityDef cityDef1 = cityDefRepo.save(cityDef);

        city.setCityDef(cityDef1);

        cityRepo.save(city);

        return "saved successfully";
    }
*/
    public String saveCityDTO(CityDTO cityDTO){

        CityDef cityDef = cityMapper.toCityDefEntity(cityDTO);

        Optional<UUID> dtoId = Optional.ofNullable(cityDTO.getId());

        UUID cityId = dtoId.get();

        City city = cityRepo.findOne(cityId);

        cityDef.setCity(city);

        CityDef cityDef1 = cityDefRepo.save(cityDef);

        city.setCityDef(cityDef1);

        cityRepo.save(city);

        return "saved successfully";
    }

}
