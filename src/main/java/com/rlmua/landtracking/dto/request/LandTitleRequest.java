package com.rlmua.landtracking.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record LandTitleRequest(
        @NotNull Long ownerId,
        @NotNull Long landParcelId,
        @NotBlank String titleNumber,
        @NotNull LocalDate issueDate
) {
}
