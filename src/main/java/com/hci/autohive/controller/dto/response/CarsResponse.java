package com.hci.autohive.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(description = "자동차 응답 DTO")
public record CarsResponse(
    @Schema(description = "자동차 ID", example = "1")
    Long carId,

    @Schema(description = "자동차 모델명", example = "현대 캐스퍼 일렉트릭 전기 0L(24년~24년)")
    String model,

    @Schema(description = "자동차 이미지 URL", example = "https://dzqerse1lankl.cloudfront.net/carsdata/cars/cm_cardb/file/7166e6bd-affc-403f-804d-205b608c872c.png")
    String imageUrl,

    @Schema(description = "자동차 별점 (1.0 ~ 5.0)", example = "4")
    Float starRating
) {
}
