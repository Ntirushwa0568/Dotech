package com.rlmua.landtracking.dto.response;

import java.time.LocalDate;

public record LandTitleResponse(
        Long id,
        Long ownerId,
        String ownerNames,
        Long landParcelId,
        String plotNumber,
        String titleNumber,
        LocalDate issueDate
) {
}
