package com.rlmua.landtracking.repository;

import com.rlmua.landtracking.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
