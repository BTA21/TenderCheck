package seachMethods;

import org.junit.Before;
import org.junit.Test;
import utils.exelDataUtils.ReadExcel;
import utils.tenderUtils.Categories;
import utils.tenderUtils.MakeTendersList;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class StringSearchUsingAhoCorasickAlgorithmTest {
    String AD;
    String RD;
    ReadExcel readItNow;
    MakeTendersList listOfTenders;
    BufferedReader br;

    @Before
    public void start() throws IOException {
        AD = "ADtest1";
//        AD = "ADtest2";
//        AD = "ADtest3";
//        RD = "10-04-2020 21.35.27";
//        RD = "12-04-2020 21.08.49";
//        RD = "27-03-2020 04.20.22";
//        listOfTenders = new MakeTendersList(13000, AD);
//        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Aho-Corasick Algorithm Test\n");
        String fileName = "D:/Documents/" + AD + ".xls";
//        String fileName = "D:/Documents/RData/" + RD + ".xls";
        readItNow = new ReadExcel(fileName);
        listOfTenders = readItNow.getListOfSavedTenders();
    }

    @Test
    public void ADTest0() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
                StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                        (Categories.valueOf("C0").getCategory(),
                                listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }

    @Test
    public void ADTest1() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C1").getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }

    @Test
    public void ADTest2() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C2").getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }


    @Test
    public void ADTest3() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C3").getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }

    @Test
    public void ADTest4() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C4").getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }

    @Test
    public void ADTest5() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C5").getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }

    @Test
    public void ADTest6() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C6").getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }

    @Test
    public void ADTest7() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C7").getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }

    @Test
    public void ADTest8() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C8").getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }


    @Test
    public void ADTest9() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C9").getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }

    @Test
    public void ADTest10() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C10").getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }

    @Test
    public void ADTest11() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C11").getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }

    @Test
    public void ADTest12() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C12").getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }

    @Test
    public void ADTest13() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C13").getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }

    @Test
    public void ADTest14() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C14").getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }


    @Test
    public void ADTest15() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C15").getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }

    @Test
    public void ADTest16() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C16").getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }

    @Test
    public void ADTest17() throws IOException {
        for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C17").getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
        }
    }

    @Test
    public void ADFullTest() throws IOException {
        for (int enumIntegerValue = 0; enumIntegerValue < 18; enumIntegerValue++) {
            for (int i = 0; i < listOfTenders.getListOfTenders().size(); i++) {
            StringSearchUsingAhoCorasickAlgorithm ak = new StringSearchUsingAhoCorasickAlgorithm
                    (Categories.valueOf("C"+enumIntegerValue).getCategory(),
                            listOfTenders.getListOfTenders().get(i).getStringCategory());
            }
        }
    }
}