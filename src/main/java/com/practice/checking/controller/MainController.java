package com.practice.checking.controller;

import com.practice.checking.dto.DBData;
import com.practice.checking.dto.ExcelData;
import com.practice.checking.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : yongjukim
 * @version : 1.0.0
 * @package : checking
 * @name : MainController
 * @date : 9/5/24
 * @modifyed : $
 **/

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MemberService memberService;

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");

        return "hello";
    }

//    @GetMapping("/excel")
//    public String main() { // 1
//        return "excel";
//    }


//    @PostMapping("/excel/read")
//    public String readExcel(@RequestParam("file") MultipartFile file, Model model)
//            throws IOException { // 2
//
//        List<ExcelData> dataList = new ArrayList<>();
//
//        String extension = FilenameUtils.getExtension(file.getOriginalFilename()); // 3
//
//        if (!extension.equals("xlsx") && !extension.equals("xls")) {
//            throw new IOException("엑셀파일만 업로드 해주세요.");
//        }
//
//        Workbook workbook = null;
//
//        // 엑셀파일만
//        if (extension.equals("xlsx")) {
//            workbook = new XSSFWorkbook(file.getInputStream());
//        } else if (extension.equals("xls")) {
//            workbook = new HSSFWorkbook(file.getInputStream());
//        }
//
//        Sheet worksheet = workbook.getSheetAt(0);
//
//        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) { // 4
//
//            Row row = worksheet.getRow(i);
//
//            ExcelData data = new ExcelData();
//
//            data.setNumber((int) row.getCell(0).getNumericCellValue());
//            data.setName(row.getCell(1).getStringCellValue());
//            data.setPhoneNumber(String.valueOf((int) row.getCell(2).getNumericCellValue()));
//            data.setRegion(row.getCell(3).getStringCellValue());
//
//            dataList.add(data);
//        }
//
//        model.addAttribute("datas", dataList); // 5
//
//        return "excelList";
//
//    }

    @GetMapping("/db/read")
    public String readDb(Model model) {
        List<DBData> dbData = memberService.getDbData();

        model.addAttribute("datas", dbData);
        return "/db/userList";
    }

    @GetMapping("/db/write")
    public String writeDb() {
        return "db/write";
    }

    @PostMapping("/db/write")
    public String writeDb(@RequestParam("name") String name,
                          @RequestParam("phoneNumber") String phoneNumber,
                          @RequestParam("region") String region) {

        DBData dbData = DBData
                .builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .region(region)
                .build();

        memberService.dbWrite(dbData);
        return "redirect:/db/read";
    }
}
