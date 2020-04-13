package utils.exelDataUtils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import utils.tenderUtils.MakeTendersList;
import utils.tenderUtils.Tender;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadExcel {
    private ArrayList listOfSavedTenders;
    private MakeTendersList makeList;
    public ReadExcel(String fileName) throws IOException {
        ArrayList listOfSavedTenders = new ArrayList();
        // Read XSL file
        FileInputStream inputStream = new FileInputStream(new File(fileName));

        // Get the workbook instance for XLS file
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

        // Get first sheet from the workbook
        HSSFSheet sheet = workbook.getSheetAt(0);
        for (int row = 1; row < 1001; row++) {
//        for (int row = 1; row < 980; row++) {
//        for (int row = 1; row < 1000; row++) {
//        for (int row = 1; row < 5000; row++) {
//        for (int row = 1; row < 13000; row++) {
                HSSFCell cell1 = sheet.getRow(row).getCell(1);
                HSSFCell cell2 = sheet.getRow(row).getCell(2);
                HSSFCell cell3 = sheet.getRow(row).getCell(3);
                HSSFCell cell4 = sheet.getRow(row).getCell(4);
                HSSFCell cell5 = sheet.getRow(row).getCell(5);
                HSSFCell cell6 = sheet.getRow(row).getCell(6);
                HSSFCell cell7 = sheet.getRow(row).getCell(7);
                HSSFCell cell8 = sheet.getRow(row).getCell(8);
                // Change to getCellType() if using POI 4.x
                CellType cellType = cell1.getCellTypeEnum();
                if (cellType != CellType.BLANK) {
                    Tender savedTender = new Tender(cell1.toString(), cell2.toString(), cell3.toString(),
                            cell4.toString(), cell5.toString(), cell6.toString(), cell7.toString(), cell8.toString());
                    listOfSavedTenders.add(savedTender);
                } else {
                    break;
                }
            }
//        System.out.println(listOfSavedTenders);
        makeList = new MakeTendersList(listOfSavedTenders);
    }

    public MakeTendersList getListOfSavedTenders() {
        return makeList;
    }

    public static void main(String[] args) throws IOException {
//        String fileName = "D:/Documents/ADtest.xls";
        String fileName = "D:/Documents/RData/10-04-2020 21.35.27.xls";
        ReadExcel readItNow = new ReadExcel(fileName);

    }



}
