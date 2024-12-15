package com.hci.autohive.controller;

import com.hci.autohive.controller.dto.response.CarsResponse;
import com.hci.autohive.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Tag(name = "Car API", description = "자동차 관련 API")
public class CarController {

  private final CarService carService;

  @Operation(summary = "모든 자동차 조회", description = "DB에 저장된 모든 자동차 정보를 조회합니다.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "요청 성공"),
      @ApiResponse(responseCode = "500", description = "서버 오류")
  })
  @GetMapping("/cars")
  public ResponseEntity<List<CarsResponse>> getAllCars() {
    List<CarsResponse> response = carService.getAllCars();
    return ResponseEntity.ok(response);
  }
}
