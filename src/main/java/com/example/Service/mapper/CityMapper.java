package com.example.Service.mapper;


import com.example.Service.DTO.CityDTO;
import com.example.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mapping(source="cityDef.name",target="name")
    CityDTO cityToCityDTO(City city);

}
