package com.hci.autohive.service;

import com.hci.autohive.controller.dto.response.CarsResponse;
import com.hci.autohive.repository.CarRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {

  private final CarRepository carRepository;

  public List<CarsResponse> getAllCars() {
    return carRepository.findAll().stream()
        .map(car -> CarsResponse.builder()
            .carId(car.getCarId())
            .model(car.getModel())
            .imageUrl(car.getImageUrl())
            .starRating(car.getStarRating())
            .build()
        )
        .collect(Collectors.toList());
  }
}
