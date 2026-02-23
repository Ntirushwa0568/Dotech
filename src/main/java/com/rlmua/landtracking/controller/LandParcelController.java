package com.rlmua.landtracking.controller;

import com.rlmua.landtracking.dto.request.LandParcelRequest;
import com.rlmua.landtracking.dto.response.LandParcelResponse;
import com.rlmua.landtracking.service.LandParcelService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parcels")
@RequiredArgsConstructor
public class LandParcelController {

    private final LandParcelService landParcelService;

    @Operation(summary = "Create land parcel")
    @PostMapping
    public ResponseEntity<LandParcelResponse> create(@Valid @RequestBody LandParcelRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(landParcelService.create(request));
    }

    @Operation(summary = "List land parcels (paginated)")
    @GetMapping
    public ResponseEntity<Page<LandParcelResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(landParcelService.findAll(pageable));
    }
}
