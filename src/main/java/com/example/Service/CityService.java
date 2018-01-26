package com.example.Service;

import com.example.Service.DTO.CityDTO;
import com.example.Service.DTO.CityDefDTO;
import com.example.entity.CityDef;

import java.util.UUID;

public interface CityService {

    CityDTO findById(UUID id);

    /*String saveCityDef(CityDef cityDef);*/

    String saveCityDTO(CityDTO cityDTO);
}
