package com.example.entity;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name="city")
@Data
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "city_id", updatable = false, nullable = false)
    protected UUID cityId;

    public City() {
        cityId = UUID.randomUUID();
    }

    public City(UUID id){
        this.cityId = id;
    }

    @Column
    String location;

    @OneToOne
    @JoinColumn(name="cityDef")
    @JsonIgnoreProperties("city")
    CityDef cityDef;
}
