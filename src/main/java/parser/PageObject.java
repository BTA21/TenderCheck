package parser;

import org.apache.xpath.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seachMethods.StringSearchUsingAhoCorasickAlgorithm;
import utils.exelDataUtils.CreateExcel;
import utils.tenderUtils.Tender;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class PageObject {
    /** Переменная объекта WebDriver */
    private WebDriver driver;
    By tendersButton = By.xpath("//a [@title = 'Тендеры']");
    By tenderPage = By.xpath("//h1 [text() = 'Расширенный поиск тендеров']");
    By qntOfPages = By.xpath("//div [@class = 'b-paging'][1]//strong[1][text()] ");
    By numberOfTender = By.xpath("//div [@class = 'table-constructor']/div [@class" +
            " = 'tender-row']//div [@class ='tender-info']/div [@class = 'row']/" +
            "div[@class = 'col-lg-6'] [text()]");
    By dateOfTender = By.xpath("//div [@class = 'table-constructor']/div [@class = " +
            "'tender-row']//div [@class ='tender-info']//div [@class = 'col-lg-3 text-center']//" +
            "div [@class = 'tender-date-info'][text()]");
    By endDateOfTender = By.xpath("//div [@class = 'table-constructor']/div [@class = 'tender-row']//" +
            "div [@class ='tender-info']//div [@class = 'col-lg-6 text-right']//" +
            "div [@class = 'tender-date-info'][text()]");
    By nameOfTender = By.xpath("//div [@class = 'table-constructor']/div [@class = 'tender-row']//" +
            "div [@class ='tender-info']//div [@class = 'description'][text()]");
    By costOfTender = By.xpath("//div [@class = 'table-constructor']/div [@class = 'tender-row']//" +
            "div [@class ='starting-price'][text()]");
    By placeOfTender = By.xpath("//div [@class = 'table-constructor']/div [@class = 'tender-row']//" +
            "div [@class ='tender-address'][text()]");
    By openListPlaceLabel = By.xpath("//div [@class = 'table-constructor']/div [@class = 'tender-row']//" +
            "div [@class ='column col-lg-3 branch-column']//label");
    By refToPage = By.xpath("//div [@class = 'table-constructor']/div [@class = 'tender-row']//" +
            "div [@class ='tender-info']//div [@class = 'description']//a");

    PageObject(WebDriver driver) {
        this.driver = driver;
        // Вызов функции неявного ожидания
        driver.manage().timeouts().
                implicitlyWait(11, TimeUnit.SECONDS);

    }

    public PageObject pageChanger(Integer pageCounter) {
            // Открываем страницу, используя драйвер
            driver.get("http://rostender.info/extsearch.php?pgsearch=" + pageCounter + "&extsearch=2&branch32=on&branch33=on&branch" +
                    "34=on&branch35=on&branch36=on&branch37=on&branch38=on&branch39=on&branch40=on&branch41=on&bra" +
                    "nch42=on&branch43=on&branch44=on&branch45=on&branch46=on&branch47=on&branch312=on&branch332=o" +
                    "n&kwd=&from=&to=&pfrom=&pto=");
            WebElement dynamicElement = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(tenderPage));
            return this;
    }
    public Integer startPageSelector(Integer page) {
        pageChanger(page);
        Integer startPage = page;
        Boolean startPageState = false;
        ArrayList endDateArray = new ArrayList();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss");
        Date date = new Date();
        String pattern = "Дата окончания: " + dateFormat.format(date);
        try {
            endDateArray = (ArrayList) driver.findElements(By.xpath("//*[contains(text(), " + pattern + ")]"));
        } catch (Exception e) {
            startPage--;
            startPageSelector(startPage);
        }
        if (endDateArray.size() > 0) {
            startPageState = true;
        }
        return startPage;
    }

    public Integer tenderDateChecker() throws ParseException {
        pageChanger(1);
        Integer pageTotal = Integer.parseInt(driver.findElement(qntOfPages).getText());
        Integer startPage = startPageSelector(pageTotal);
        return startPage;
    }

    public Integer tenderDateChecker(Integer page) {
        pageChanger(page);
        Integer pageTotal = Integer.parseInt(driver.findElement(qntOfPages).getText());
        return pageTotal;
    }

    public ArrayList getNumber() {
        ArrayList listOfNumbers = new ArrayList();
        List<WebElement> list = driver.findElements(numberOfTender);
        for (WebElement element : list) {
            listOfNumbers.add(element.getText());
        }
        return listOfNumbers;
    }

    public ArrayList getDate() {
        ArrayList listOfDates = new ArrayList();
        List<WebElement> list = driver.findElements(dateOfTender);
        for (WebElement element : list) {
            listOfDates.add(element.getText());
        }
        return listOfDates;
    }

    public ArrayList getEndDate() {
        ArrayList listOfEndDate = new ArrayList();
        List<WebElement> list = driver.findElements(endDateOfTender);
        for (WebElement element : list) {
            StringBuffer sb = new StringBuffer(element.getText());
            sb.delete(0,16);
            listOfEndDate.add(sb);
        }
        return listOfEndDate;
    }

    public ArrayList getName() {
        ArrayList listOfName = new ArrayList();
        List<WebElement> list = driver.findElements(nameOfTender);
        for (WebElement element : list) {
            listOfName.add(element.getText());
        }
        return listOfName;
    }

    public ArrayList getStartCost() {
        ArrayList listOfStartCost = new ArrayList();
        List<WebElement> list = driver.findElements(costOfTender);
        for (WebElement element : list) {
            listOfStartCost.add(element.getText());
        }
        return listOfStartCost;
    }

    public ArrayList getPlace() {
        ArrayList listOfPlace = new ArrayList();
        List<WebElement> list = driver.findElements(placeOfTender);
        for (WebElement element : list) {
            listOfPlace.add(element.getText());
        }
        return listOfPlace;
    }

    public void openList(Integer counter) {
        driver.findElements(openListPlaceLabel).get(counter).click();
    }

    public ArrayList<ArrayList<String>> getCategory() {
        ArrayList<ArrayList<String>> listOfCategoriesArrays = new ArrayList();
        for (Integer tenderCounter = 0; tenderCounter < getNumber().size(); tenderCounter++) {
            ArrayList<String> arrayOfCategoriesOfTender = new ArrayList();
            Integer counter = tenderCounter + 1;
            openList(counter - 1);
            By categoriesOfTender = By.xpath("//div [@class = 'table-constructor']/div [@class = 'tender-row']" +
                    "[" + counter + "]//" + "div [@class ='column col-lg-3 branch-column']//li");
            List<WebElement> listOfCategories = driver.findElements(categoriesOfTender);
            for (int category = 0; category < listOfCategories.size(); category++) {
                arrayOfCategoriesOfTender.add(listOfCategories.get(category).getText());
            }
            listOfCategoriesArrays.add(arrayOfCategoriesOfTender);
        }
        return listOfCategoriesArrays;
    }

    public ArrayList getRef() {
        ArrayList listOfRef = new ArrayList();
        List<WebElement> list = driver.findElements(refToPage);
        for (WebElement element : list) {
            listOfRef.add(element.getAttribute("href"));
        }
        return listOfRef;
    }

    public void getElements(PageObject po) throws IOException, ParseException {
        ArrayList<Tender> result = new ArrayList<>();
        Integer startPage = tenderDateChecker(1);
    for (int page = startPage; page > 0; page--) {
            pageChanger(page);
            List numbers = po.getNumber();
            List dates = po.getDate();
            List endDates = po.getEndDate();
            List names = po.getName();
            List startCosts = po.getStartCost();
            List places = po.getPlace();
            ArrayList<ArrayList<String>> categoriesArrays = po.getCategory();
            List refs = po.getRef();
            for (int i = 0; i < getNumber().size(); i++) {
                String number = numbers.get(i).toString();
                String date = dates.get(i).toString();
                String endDate = endDates.get(i).toString();
                String name = names.get(i).toString();
                String startCost = startCosts.get(i).toString();
                String place = places.get(i).toString();
                ArrayList categories = categoriesArrays.get(i);
                String ref = refs.get(i).toString();
                Tender tender = new Tender(number, date, endDate, name, startCost, place, categories, ref);
                result.add(tender);
            }
        }
        CreateExcel table = new CreateExcel(result, "");
    }

    public static void main(String[] args) throws IOException, ParseException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver",
                new File("src\\main\\resources\\chromedriver_win32\\chromedriver.exe").getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PageObject po = new PageObject(driver);
        po.getElements(po);
        driver.quit();
    }


}
