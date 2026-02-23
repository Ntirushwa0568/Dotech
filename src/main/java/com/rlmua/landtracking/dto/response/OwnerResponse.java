package com.rlmua.landtracking.dto.response;

public record OwnerResponse(
        Long id,
        String names,
        String nationalId,
        String phoneNumber,
        String address
) {
}
