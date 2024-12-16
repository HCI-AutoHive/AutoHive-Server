package com.hci.autohive.controller;

import com.hci.autohive.controller.dto.response.DetailResponse;
import com.hci.autohive.service.DetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Tag(name = "Detail API", description = "자동차 세부 정보 관련 API")
public class DetailController {

  private final DetailService detailService;

  @Operation(summary = "자동차 세부 정보 조회", description = "특정 자동차의 세부 정보를 조회합니다.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "요청 성공"),
      @ApiResponse(responseCode = "400", description = "잘못된 요청 (carId 누락)"),
      @ApiResponse(responseCode = "404", description = "해당 ID의 자동차 정보 없음"),
      @ApiResponse(responseCode = "500", description = "서버 오류")
  })
  @GetMapping("cars/{carId}/detail")
  public ResponseEntity<DetailResponse> getDetail(
      @Parameter(description = "조회할 자동차의 ID", required = true, example = "1")
      @PathVariable Long carId
  ) {
    DetailResponse response = detailService.getDetail(carId);
    return ResponseEntity.ok(response);
  }
}
