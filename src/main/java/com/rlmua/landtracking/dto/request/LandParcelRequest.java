package com.rlmua.landtracking.dto.request;

import com.rlmua.landtracking.enums.LandUseType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record LandParcelRequest(
        @NotBlank String plotNumber,
        @NotNull @Positive Double landSize,
        @NotBlank String landLocation,
        @NotNull LandUseType landUseType,
        @NotNull LocalDate registrationDate
) {
}
