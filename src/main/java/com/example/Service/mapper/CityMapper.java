package com.example.Service.mapper;


import com.example.Service.DTO.CityDTO;
import com.example.Service.DTO.CityDefDTO;
import com.example.entity.City;
import com.example.entity.CityDef;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mappings({
            @Mapping(source="city.cityId",target="id"),
            @Mapping(source="city.location",target="location"),
            @Mapping(source="cityDef.name",target="name")
    })
    CityDTO ToCityDTO(City city, CityDef cityDef);

    default UUID cityDefToUuid(CityDef cityDef){
        UUID def = cityDef.getDefId();
        return def;
    }


    @Mappings({
            @Mapping(target = "cityDef", ignore = true)
    })
    City toCityEntity(CityDTO cityDTO);


    @Mappings({
            @Mapping(target = "defId",ignore = true),
            @Mapping(target = "city",ignore = true)
    })
    CityDef toCityDefEntity(CityDTO cityDTO);




    //City toOrgEntity(OrgDTO orgDTO);

    //OrgDef toOrgDefEntity(OrgDTO orgDTO);

//    @Mappings({
//            @Mapping(source="id",target="city.cityId")
//    })
//    CityDef CityDefDtoToCityDef(CityDefDTO cityDefDTO);

}
