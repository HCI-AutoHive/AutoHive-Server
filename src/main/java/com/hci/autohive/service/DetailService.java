package com.hci.autohive.service;

import com.hci.autohive.controller.dto.response.DetailResponse;
import com.hci.autohive.repository.DetailRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class DetailService {

  private final DetailRepository detailRepository;

  public List<DetailResponse> getDetails(Long carId) {
    List<DetailResponse> detailResponseList = detailRepository.findById(carId).stream()
        .map(detail -> DetailResponse.builder()
            .carId(detail.getCarId())
            .safety(detail.getSafety())
            .perform(detail.getPerform())
            .build()
        )
        .collect(java.util.stream.Collectors.toList());

    if (detailResponseList.isEmpty()) {
      throw new NotFoundException("자동차 데이터가 존재하지 않습니다.");
    }

    return detailResponseList;
  }
}
