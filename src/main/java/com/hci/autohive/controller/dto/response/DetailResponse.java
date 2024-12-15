package com.hci.autohive.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(description = "자동차 세부 정보 응답 DTO")
public record DetailResponse(
    @Schema(description = "자동차 ID", example = "1")
    Long carId,

    @Schema(description = "자동차의 안전 장비", example = "안전장비: ~")
    String safety,

    @Schema(description = "자동차의 주행 성능", example = "직선주행: ~")
    String perform
) {
}
