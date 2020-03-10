package utils.exelDataUtils;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class CreateExcel {
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public CreateExcel(ArrayList listOfTenders) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Тестовая выборка");

        int rownum = 0;
        Cell cell;
        Row row;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);

        // Number
        cell = row.createCell(0, CellType.NUMERIC);
        cell.setCellValue("№");
        cell.setCellStyle(style);
        // Category name
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Категория");
        cell.setCellStyle(style);

        // Data
        for (int tender = 0; tender < listOfTenders.size();tender ++) {
            rownum++;
            row = sheet.createRow(rownum);

            // Number (A)
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(tender + 1);
            // Category name (B)
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(listOfTenders.get(tender).toString());
        }
        File file = new File("D:/Documents/categories.xls");
        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());

    }
}

