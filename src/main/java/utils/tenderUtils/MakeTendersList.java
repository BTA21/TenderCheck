package utils.tenderUtils;
import utils.exelDataUtils.CreateExcel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MakeTendersList {
    private ArrayList<String> listOfTenders;
    private Integer numberOfTenders;

    public MakeTendersList(Integer numberOfTenders) throws IOException {
        this.listOfTenders = new ArrayList<String>(0);
        makeTenderList(numberOfTenders);
        showListOfTenders();
        CreateExcel table = new CreateExcel(listOfTenders);

    }

    public String makeTender() {
        Random enumValueRandom = new Random();
        Integer enumIntegerValue = enumValueRandom.nextInt(17);
        String enumValue = "C" + enumIntegerValue;
        String category = Categories.valueOf(enumValue).getCategory();
        return category;
    }

    public void makeTenderList(Integer numberOfTenders) {
        for (int i = 0; i < numberOfTenders; i++) {
            String tender = makeTender();
            this.listOfTenders.add(tender);
        }
    }

    public void showListOfTenders() {
        for (Object tender : this.listOfTenders)
            System.out.println(tender);
    }

}
