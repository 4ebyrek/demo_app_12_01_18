package com.example.Service.DTO;

import lombok.Data;

import java.util.Objects;
import java.util.UUID;

@Data
public class CityDTO {

    UUID id;

    String location;

    String name;

}
