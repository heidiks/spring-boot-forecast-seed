package com.heidiks.forecast.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by heidi on 15/05/2017.
 */
@Data
@Entity
public class City {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String country;

    public City() {
    }

    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
