package com.rlmua.landtracking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "land_titles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LandTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne(optional = false)
    @JoinColumn(name = "land_parcel_id")
    private LandParcel landParcel;

    @Column(nullable = false, unique = true)
    private String titleNumber;

    @Column(nullable = false)
    private LocalDate issueDate;
}
