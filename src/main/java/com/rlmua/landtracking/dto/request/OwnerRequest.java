package com.rlmua.landtracking.dto.request;

import jakarta.validation.constraints.NotBlank;

public record OwnerRequest(
        @NotBlank String names,
        @NotBlank String nationalId,
        @NotBlank String phoneNumber,
        @NotBlank String address
) {
}
