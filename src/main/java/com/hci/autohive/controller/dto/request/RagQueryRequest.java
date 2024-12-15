package com.hci.autohive.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "RAG 서버에 전달할 질문 요청 DTO")
public record RagQueryRequest(
    @NotBlank(message = "질문은 비어있을 수 없습니다.")
    @Schema(description = "사용자가 입력한 질문", example = "차량의 안전 점수는?")
    String query
) {}
