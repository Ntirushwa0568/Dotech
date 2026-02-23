package com.rlmua.landtracking.controller;

import com.rlmua.landtracking.dto.request.LandTitleRequest;
import com.rlmua.landtracking.dto.response.LandTitleResponse;
import com.rlmua.landtracking.service.LandTitleService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/titles")
@RequiredArgsConstructor
public class LandTitleController {

    private final LandTitleService landTitleService;

    @Operation(summary = "Create land title")
    @PostMapping
    public ResponseEntity<LandTitleResponse> create(@Valid @RequestBody LandTitleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(landTitleService.create(request));
    }

    @Operation(summary = "List land titles history (paginated)")
    @GetMapping
    public ResponseEntity<Page<LandTitleResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(landTitleService.findAll(pageable));
    }
}
