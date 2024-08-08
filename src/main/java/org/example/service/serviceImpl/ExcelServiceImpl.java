package org.example.service.serviceImpl;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.User;
import org.example.service.ExcelService;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelServiceImpl implements ExcelService {
    private final String filePath;

    public ExcelServiceImpl(String filePath) {
        this.filePath = filePath;
    }
    @Override
    public void write(User user) {
        try (FileInputStream inputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheet("Users");

            if (sheet == null) {
                sheet = workbook.createSheet("Users");
            }

            boolean userExists = false;
            for (Row row : sheet) {
                Cell idCell = row.getCell(0);
                if (idCell != null && idCell.getStringCellValue().equals(user.getAccountId())) {
                    row.getCell(1).setCellValue(user.getUserName());
                    row.getCell(2).setCellValue(user.getBalance());
                    userExists = true;
                    break;
                }
            }
            if (!userExists) {
                int lastRowNum = sheet.getLastRowNum();
                Row newRow = sheet.createRow(lastRowNum + 1);
                newRow.createCell(0).setCellValue(user.getAccountId());
                newRow.createCell(1).setCellValue(user.getUserName());
                newRow.createCell(2).setCellValue(user.getBalance());
            }
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User readUser(String accountId) {
        try (FileInputStream inputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheet("Users");
            if (sheet == null) {
                return null;
            }
            for (Row row : sheet) {
                Cell idCell = row.getCell(0);
                Cell nameCell = row.getCell(1);
                Cell balanceCell = row.getCell(2);

                if (idCell != null && idCell.getCellType() == CellType.STRING
                        && idCell.getStringCellValue().equals(accountId)) {
                    String userName =nameCell.getStringCellValue();
                    double balance = balanceCell.getNumericCellValue();

                    User user = new User(accountId, userName);
                    user.setBalance(balance);
                    return user;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
