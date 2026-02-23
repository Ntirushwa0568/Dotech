package com.rlmua.landtracking.repository;

import com.rlmua.landtracking.entity.LandParcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandParcelRepository extends JpaRepository<LandParcel, Long> {
}
