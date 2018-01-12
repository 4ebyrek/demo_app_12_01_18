package com.example.Controller;





import com.example.Service.CityService;
import com.example.Service.DTO.CityDTO;
import com.example.entity.City;
import com.example.entity.CityDef;
import com.example.repo.CityDefRepo;
import com.example.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class RestPersonController {

    @Autowired
    CityRepo сityRepo;

    @Autowired
    CityDefRepo cityDefRepo;

    @Autowired
    CityService cityService;

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
    public CityDef saveNewDef(@RequestBody CityDef cityDef)throws Exception{

        Long city_id = cityDef.getCity().getCityId();
        Long city_def_id = cityDefRepo.save(cityDef).getDefId();

        City city = сityRepo.findByCityId(city_id);

        city.setCityDef(cityDef);

        сityRepo.save(city);
       return cityDefRepo.save(cityDef);
    }

    @GetMapping("/get_city_dto")
    public CityDTO getCityDto(@RequestParam Long id){
        return cityService.findById(id);
    }

}