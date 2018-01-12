package com.example.repo;


import com.example.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends CrudRepository<City,Long>{

    City findByCityId(Long id);
}
