package com.hci.autohive.controller;

import com.hci.autohive.service.ExcelService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/excel")
public class ExcelController {

  private final ExcelService excelDataService;

  @PostMapping("/upload")
  public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) {
    try {
      excelDataService.saveExcelData(file);
      return ResponseEntity.ok("successfully.");
    } catch (IOException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Failed");
    }
  }
}

