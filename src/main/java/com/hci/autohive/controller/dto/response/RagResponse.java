package com.hci.autohive.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(description = "RAG 서버 응답 DTO")
public record RagResponse(
    @Schema(description = "RAG 서버로부터의 응답", example = "차량의 안전 점수는 4.5입니다.")
    String answer
) {}
