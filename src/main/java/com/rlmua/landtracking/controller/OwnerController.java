package com.rlmua.landtracking.controller;

import com.rlmua.landtracking.dto.request.OwnerRequest;
import com.rlmua.landtracking.dto.response.OwnerResponse;
import com.rlmua.landtracking.service.OwnerService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @Operation(summary = "Create owner")
    @PostMapping
    public ResponseEntity<OwnerResponse> create(@Valid @RequestBody OwnerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ownerService.create(request));
    }

    @Operation(summary = "List owners (paginated)")
    @GetMapping
    public ResponseEntity<Page<OwnerResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(ownerService.findAll(pageable));
    }
}
