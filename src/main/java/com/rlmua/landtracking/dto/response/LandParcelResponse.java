package com.rlmua.landtracking.dto.response;

import com.rlmua.landtracking.enums.LandUseType;

import java.time.LocalDate;

public record LandParcelResponse(
        Long id,
        String plotNumber,
        Double landSize,
        String landLocation,
        LandUseType landUseType,
        LocalDate registrationDate
) {
}
