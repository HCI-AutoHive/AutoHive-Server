package com.hci.autohive.service;

import com.hci.autohive.controller.dto.response.RagResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class RagApiService {

  private final RestTemplate restTemplate;

  @Value("${rag.server-url}")
  private String RAG_SERVER_URL;

  public RagResponse fetchRagAnswer(String query) {
    try {
      Map<String, String> requestBody = Map.of("query", query);
      HttpHeaders headers = new HttpHeaders();
      headers.set("Content-Type", "application/json");

      HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

      ResponseEntity<Map> responseEntity = restTemplate.exchange(
          RAG_SERVER_URL, HttpMethod.POST, requestEntity, Map.class
      );

      Map<String, Object> responseBody = responseEntity.getBody();
      if (responseBody != null && responseBody.containsKey("answer")) {
        return RagResponse.builder()
            .answer(responseBody.get("answer").toString())
            .build();
      }

      throw new RuntimeException("RAG 서버에서 유효한 응답을 받지 못했습니다.");

    } catch (HttpClientErrorException e) {
      throw new RuntimeException("RAG 서버 호출 중 오류 발생: " + e.getMessage(), e);
    }
  }
}
