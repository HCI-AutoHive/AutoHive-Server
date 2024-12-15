package com.hci.autohive.service;

import com.hci.autohive.controller.dto.response.CarsResponse;
import com.hci.autohive.repository.CarRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class CarService {

  private final CarRepository carRepository;

  public List<CarsResponse> getAllCars() {
    List<CarsResponse> carsResponseList = carRepository.findAll().stream()
        .map(car -> CarsResponse.builder()
            .carId(car.getCarId())
            .model(car.getModel())
            .imageUrl(car.getImageUrl())
            .starRating(car.getStarRating())
            .build()
        )
        .collect(Collectors.toList());

    if (carsResponseList.isEmpty()) {
      throw new NotFoundException("자동차 데이터가 존재하지 않습니다.");
    }

    return carsResponseList;
  }
}
