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
@Table(name="city_def")
@Data
public class CityDef implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "def_id", updatable = false, nullable = false)
    protected UUID defId;

    public CityDef() {
        defId = UUID.randomUUID();
    }

    @Column
    String name;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="city")
    @JsonIgnoreProperties(value = {"cityDef"},allowSetters=true)
    City city;

}
