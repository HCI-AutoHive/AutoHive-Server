package com.hci.autohive.service;

import com.hci.autohive.controller.dto.response.DetailResponse;
import com.hci.autohive.domain.Car;
import com.hci.autohive.domain.Detail;
import com.hci.autohive.repository.CarRepository;
import com.hci.autohive.repository.DetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class DetailService {

  private final CarRepository carRepository;
  private final DetailRepository detailRepository;

  public DetailResponse getDetail(Long carId) {
    Car car = carRepository.findById(carId)
        .orElseThrow(() -> new NotFoundException("자동차 데이터가 존재하지 않습니다."));

    Detail detail = detailRepository.findById(carId)
        .orElseThrow(() -> new NotFoundException("자동차 세부 정보가 존재하지 않습니다."));

    return DetailResponse.builder()
        .carId(car.getCarId())
        .safety(detail.getSafety())
        .perform(detail.getPerform())
        .build();
  }
}
