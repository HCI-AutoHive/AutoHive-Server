package com.hci.autohive.service;

import com.hci.autohive.domain.Car;
import com.hci.autohive.domain.Detail;
import com.hci.autohive.repository.CarRepository;
import com.hci.autohive.repository.DetailRepository;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ExcelService {

  private final CarRepository carRepository;
  private final DetailRepository detailRepository;

  @Transactional
  public void saveExcelData(MultipartFile file) throws IOException {

    Workbook workbook = new XSSFWorkbook(file.getInputStream());
    Sheet sheet = workbook.getSheetAt(0);

    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
      Row row = sheet.getRow(i);

      Car car = new Car();
      car.setModel(row.getCell(0).getStringCellValue());
      car.setStarRating((float) row.getCell(1).getNumericCellValue());
      car.setImageUrl(row.getCell(4).getStringCellValue());
      Car savedCar = carRepository.save(car);

      Detail detail = new Detail();
      detail.setCar(savedCar);
      detail.setSafety(row.getCell(3).getStringCellValue());
      detail.setPerform(row.getCell(2).getStringCellValue());
      detailRepository.save(detail);

    }

    workbook.close();
  }
}
