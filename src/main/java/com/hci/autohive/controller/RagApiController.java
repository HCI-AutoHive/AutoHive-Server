package com.hci.autohive.controller;

import com.hci.autohive.controller.dto.request.RagQueryRequest;
import com.hci.autohive.controller.dto.response.RagResponse;
import com.hci.autohive.service.RagApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Tag(name = "RAG API", description = "RAG 서버와 통신하는 API")
public class RagApiController {

  private final RagApiService ragApiService;

  @Operation(summary = "RAG Query API", description = "RAG 서버에 질문을 보내고 응답을 받습니다.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "요청 성공"),
      @ApiResponse(responseCode = "400", description = "잘못된 요청"),
      @ApiResponse(responseCode = "500", description = "서버 오류")
  })
  @PostMapping("/rag-query")
  public ResponseEntity<RagResponse> getRagAnswer(@RequestBody RagQueryRequest request) {
    RagResponse response = ragApiService.fetchRagAnswer(request.query());
    return ResponseEntity.ok(response);
  }
}
