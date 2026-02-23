package com.rlmua.landtracking.service;

import com.rlmua.landtracking.dto.request.LandParcelRequest;
import com.rlmua.landtracking.dto.response.LandParcelResponse;
import com.rlmua.landtracking.entity.LandParcel;
import com.rlmua.landtracking.exception.ResourceNotFoundException;
import com.rlmua.landtracking.repository.LandParcelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LandParcelService {

    private final LandParcelRepository landParcelRepository;

    public LandParcelResponse create(LandParcelRequest request) {
        LandParcel parcel = landParcelRepository.save(LandParcel.builder()
                .plotNumber(request.plotNumber())
                .landSize(request.landSize())
                .landLocation(request.landLocation())
                .landUseType(request.landUseType())
                .registrationDate(request.registrationDate())
                .build());

        log.info("Land parcel created id={}, plotNumber={}", parcel.getId(), parcel.getPlotNumber());
        return map(parcel);
    }

    public Page<LandParcelResponse> findAll(Pageable pageable) {
        return landParcelRepository.findAll(pageable).map(this::map);
    }

    public LandParcel getEntityById(Long id) {
        return landParcelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Land parcel not found with id=" + id));
    }

    private LandParcelResponse map(LandParcel parcel) {
        return new LandParcelResponse(parcel.getId(), parcel.getPlotNumber(), parcel.getLandSize(), parcel.getLandLocation(), parcel.getLandUseType(), parcel.getRegistrationDate());
    }
}
