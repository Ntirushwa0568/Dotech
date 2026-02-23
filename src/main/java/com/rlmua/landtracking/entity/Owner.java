package com.rlmua.landtracking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "owners")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String names;

    @Column(nullable = false, unique = true)
    private String nationalId;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;
}
