package com.rlmua.landtracking.entity;

import com.rlmua.landtracking.enums.LandUseType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "land_parcels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LandParcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String plotNumber;

    @Column(nullable = false)
    private Double landSize;

    @Column(nullable = false)
    private String landLocation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LandUseType landUseType;

    @Column(nullable = false)
    private LocalDate registrationDate;
}
