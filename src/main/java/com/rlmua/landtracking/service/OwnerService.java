package com.rlmua.landtracking.service;

import com.rlmua.landtracking.dto.request.OwnerRequest;
import com.rlmua.landtracking.dto.response.OwnerResponse;
import com.rlmua.landtracking.entity.Owner;
import com.rlmua.landtracking.exception.ResourceNotFoundException;
import com.rlmua.landtracking.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerResponse create(OwnerRequest request) {
        Owner owner = ownerRepository.save(Owner.builder()
                .names(request.names())
                .nationalId(request.nationalId())
                .phoneNumber(request.phoneNumber())
                .address(request.address())
                .build());
        log.info("Owner created with id={}", owner.getId());
        return map(owner);
    }

    public Page<OwnerResponse> findAll(Pageable pageable) {
        return ownerRepository.findAll(pageable).map(this::map);
    }

    public Owner getEntityById(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with id=" + id));
    }

    private OwnerResponse map(Owner owner) {
        return new OwnerResponse(owner.getId(), owner.getNames(), owner.getNationalId(), owner.getPhoneNumber(), owner.getAddress());
    }
}
