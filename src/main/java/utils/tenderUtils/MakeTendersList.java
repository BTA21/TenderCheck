package utils.tenderUtils;
import utils.exelDataUtils.CreateExcel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MakeTendersList {
    private ArrayList<Tender> listOfTenders;
    private Integer numberOfTenders;

    public ArrayList<Tender> getListOfTenders() {
        return listOfTenders;
    }

    public MakeTendersList(Integer numberOfTenders) throws IOException {
        this.listOfTenders = new ArrayList<Tender>(0);
        makeTenderList(numberOfTenders);
        CreateExcel table = new CreateExcel(listOfTenders, "");

    }

        public MakeTendersList(ArrayList<Tender> tendersArray) {
        this.listOfTenders = tendersArray;
    }

    public MakeTendersList(Integer numberOfTenders, String nameOfExcelFile) throws IOException {
        this.listOfTenders = new ArrayList<Tender>(0);
        makeTenderList(numberOfTenders);
        CreateExcel table = new CreateExcel(listOfTenders, "", nameOfExcelFile);

    }

    public String makeTender() {
        Random enumValueRandom = new Random();
        Integer enumIntegerValue = enumValueRandom.nextInt(18);
        String enumValue = "C" + enumIntegerValue;
        String category = Categories.valueOf(enumValue).getCategory();
        return category;
    }

    public void makeTenderList(Integer numberOfTenders) {
        for (int i = 0; i < numberOfTenders; i++) {
            String category = makeTender();
            ArrayList<String> categoriesList = new ArrayList<String>();
            categoriesList.add(category);
            Tender tenderObject = new Tender(categoriesList);
            this.listOfTenders.add(tenderObject);
        }
    }

    public void showListOfTenders() {
        for (Object tender : this.listOfTenders)
            System.out.println(tender);
    }

}
