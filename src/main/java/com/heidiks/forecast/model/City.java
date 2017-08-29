package com.heidiks.forecast.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by heidi on 15/05/2017.
 */
@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @NonNull
    @Getter
    private String name;

    @Column(nullable = false)
    @NonNull
    private String country;

}
