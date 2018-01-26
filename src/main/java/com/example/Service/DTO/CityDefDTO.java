package com.example.Service.DTO;

import com.example.entity.City;

import java.util.UUID;

public class CityDefDTO {
    String name;
    UUID id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
