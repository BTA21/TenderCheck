package utils.exelDataUtils;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import utils.tenderUtils.Tender;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CreateExcel {
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public CreateExcel(ArrayList listOfTenders, Integer opt) throws IOException {

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

    public CreateExcel(ArrayList<Tender> listOfTenders, String opt) throws IOException {

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
        cell.setCellValue("Номер тендера");
        cell.setCellStyle(style);
        // Category name
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Дата");
        cell.setCellStyle(style);
        // Category name
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Дата окончания");
        cell.setCellStyle(style);
        // Category name
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Наименование");
        cell.setCellStyle(style);
        // Category name
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Стартовая цена");
        cell.setCellStyle(style);
        // Category name
        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Место поставки");
        cell.setCellStyle(style);
        // Category name
        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Категория");
        cell.setCellStyle(style);
        // Category name
        cell = row.createCell(8, CellType.STRING);
        cell.setCellValue("Ссылка на страницу");
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
            cell.setCellValue(listOfTenders.get(tender).getNumber());
            // Category name (C)
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(listOfTenders.get(tender).getDate());
             // Category name (D)
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(listOfTenders.get(tender).getEndDate());
             // Category name (E)
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(listOfTenders.get(tender).getName());
             // Category name (F)
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue(listOfTenders.get(tender).getStartCost());
            // Category name (F)
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue(listOfTenders.get(tender).getPlace());
             // Category name (G)
            cell = row.createCell(7, CellType.STRING);
            String categories = "";
            for (int j = 0; j < listOfTenders.get(tender).getCategory().size(); j++) {
                categories += "\n" + listOfTenders.get(tender).getCategory().get(j).toString();
            }
            cell.setCellValue(categories);
            // Category name (F)
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue(listOfTenders.get(tender).getRef());
        }
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss");
        Date date = new Date();
        File file = new File("D:/Documents/" + dateFormat.format(date) + ".xls");
        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());
    }
}

