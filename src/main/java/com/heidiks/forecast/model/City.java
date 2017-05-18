package com.heidiks.forecast.model;

import com.heidiks.forecast.model.listner.CitySaveOrUpdateListener;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by heidi on 15/05/2017.
 */
@Data
@Entity
@EntityListeners(CitySaveOrUpdateListener.class)
public class City {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String country;

    public City() {
    }

    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }
}
