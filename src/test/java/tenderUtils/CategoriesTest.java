package tenderUtils;

import org.junit.Test;
import utils.tenderUtils.Categories;

import java.util.Random;

public class CategoriesTest {


    @Test
    public void getCategory() {
        Random enumValueRandom = new Random();
        Integer enumIntegerValue = enumValueRandom.nextInt(17);
        String enumValue = "C" + enumIntegerValue;
        String category = Categories.valueOf(enumValue).getCategory();
        System.out.println(category);
    }
}