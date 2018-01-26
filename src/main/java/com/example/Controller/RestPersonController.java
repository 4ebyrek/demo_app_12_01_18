package com.example.Controller;


import com.example.Service.CityService;
import com.example.Service.DTO.CityDTO;
import com.example.Service.DTO.CityDefDTO;
import com.example.entity.City;
import com.example.entity.CityDef;
import com.example.repo.CityDefRepo;
import com.example.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping
public class RestPersonController {


    @Autowired
    CityRepo сityRepo;

    @Autowired
    CityDefRepo cityDefRepo;

    @Autowired
    CityService cityService;

    @GetMapping("/delete_city")
    public Iterable deleteCity(@RequestParam UUID id){
        сityRepo.delete(id);
        return сityRepo.findAll();
    }

    @GetMapping("/delete_city_def")
    public Iterable deleteCityDef(@RequestParam UUID id){
        cityDefRepo.delete(id);
        return cityDefRepo.findAll();
    }

    @GetMapping("/find_all_cities")
    public Iterable getAllCities(){
        return сityRepo.findAll();
    }

    @GetMapping("/find_all_city_defs")
    public Iterable getAllCityDefs(){
        return cityDefRepo.findAll();
    }

    @PutMapping("/save_new_city")
    public City saveNewCity(@RequestBody City city)throws Exception{
        return сityRepo.save(city);
    }


    @PutMapping("/save_new_city_def")
    public String saveNewDef(@RequestBody CityDTO cityDTO)throws Exception{
        return cityService.saveCityDTO(cityDTO);
    }

    @GetMapping("/get_city_dto")
    public CityDTO getCityDto(@RequestParam UUID id){
        return cityService.findById(id);
    }

}
