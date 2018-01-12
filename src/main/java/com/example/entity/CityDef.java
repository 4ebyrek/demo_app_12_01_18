package com.example.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="city_def")
public class CityDef implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "city_def_seq")
    @SequenceGenerator(sequenceName = "city_defs",name = "city_def_seq",allocationSize = 1)
    @Column(name = "def_id", updatable = false, nullable = false)
    Long defId;

    @Column
    String name;

//    @Column(name="city_id")
//    Long cityId;

    @ManyToOne
    @JoinColumn(name="city")
    City city;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getDefId() {
        return defId;
    }

    public void setDefId(Long defId) {
        this.defId = defId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public CityDef(String name, City city) {

        this.name = name;
        this.city = city;
    }

    public CityDef() {

    }
}
