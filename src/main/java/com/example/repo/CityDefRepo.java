package com.example.repo;


import com.example.entity.CityDef;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDefRepo extends CrudRepository<CityDef,Long>{
}
