package com.rlmua.landtracking.service;

import com.rlmua.landtracking.dto.request.LandTitleRequest;
import com.rlmua.landtracking.dto.response.LandTitleResponse;
import com.rlmua.landtracking.entity.LandTitle;
import com.rlmua.landtracking.repository.LandTitleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LandTitleService {

    private final LandTitleRepository landTitleRepository;
    private final OwnerService ownerService;
    private final LandParcelService landParcelService;

    public LandTitleResponse create(LandTitleRequest request) {
        LandTitle title = landTitleRepository.save(LandTitle.builder()
                .owner(ownerService.getEntityById(request.ownerId()))
                .landParcel(landParcelService.getEntityById(request.landParcelId()))
                .titleNumber(request.titleNumber())
                .issueDate(request.issueDate())
                .build());

        log.info("Land title created id={}, titleNumber={}", title.getId(), title.getTitleNumber());
        return map(title);
    }

    public Page<LandTitleResponse> findAll(Pageable pageable) {
        return landTitleRepository.findAll(pageable).map(this::map);
    }

    private LandTitleResponse map(LandTitle title) {
        return new LandTitleResponse(
                title.getId(),
                title.getOwner().getId(),
                title.getOwner().getNames(),
                title.getLandParcel().getId(),
                title.getLandParcel().getPlotNumber(),
                title.getTitleNumber(),
                title.getIssueDate()
        );
    }
}
