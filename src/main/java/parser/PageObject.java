package parser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageObject {
    /** Переменная объекта WebDriver */
    private WebDriver driver;
    By tendersButton = By.xpath("//a [@title = 'Тендеры']");
    By tenderPage = By.xpath("//h1 [text() = 'Тендеры']");
    By qntOfPages = By.xpath("//div [@class = 'b-paging'][1]//strong[1][text()] ");
    By numberOfTender = By.xpath("//div [@class = 'table-constructor']/div [@class" +
            " = 'tender-row'][1]//div [@class ='tender-info']/div [@class = 'row']/" +
            "div[@class = 'col-lg-6'] [text()]");
    By dateOfTender = By.xpath("//div [@class = 'table-constructor']/div [@class = " +
            "'tender-row'][1]//div [@class ='tender-info']//div [@class = 'col-lg-3 text-center']//" +
            "div [@class = 'tender-date-info'][text()]");
    By endDateOfTender = By.xpath("//div [@class = 'table-constructor']/div [@class = 'tender-row'][1]//" +
            "div [@class ='tender-info']//div [@class = 'col-lg-6 text-right']//" +
            "div [@class = 'tender-date-info'][text()]");
    By nameOfTender = By.xpath("//div [@class = 'table-constructor']/div [@class = 'tender-row'][1]//" +
            "div [@class ='tender-info']//div [@class = 'description'][text()]");
    By costOfTender = By.xpath("//div [@class = 'table-constructor']/div [@class = 'tender-row'][1]//" +
            "div [@class ='starting-price'][text()]");
    By placeOfTender = By.xpath("//div [@class = 'table-constructor']/div [@class = 'tender-row'][1]//" +
            "div [@class ='tender-address'][text()]");
    By openListPlaceLabel = By.xpath("//div [@class = 'table-constructor']/div [@class = 'tender-row'][1]//" +
            "div [@class ='column col-lg-3 branch-column']//label");
    By categoriesOfTender = By.xpath("//div [@class = 'table-constructor']/div [@class = 'tender-row'][1]//" +
            "div [@class ='column col-lg-3 branch-column']//li");
    By refToPage = By.xpath("//div [@class = 'table-constructor']/div [@class = 'tender-row'][1]//" +
            "div [@class ='tender-info']//div [@class = 'description']//a");

    PageObject(WebDriver driver) {
        this.driver = driver;
        // Вызов функции неявного ожидания
        driver.manage().timeouts().
                implicitlyWait(11, TimeUnit.SECONDS);
        // Открываем страницу, используя драйвер
        driver.get("http://rostender.info/");
        driver.findElement(tendersButton).click();
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(tenderPage));
    }

    public String getNumber() {
        String number = driver.findElement(numberOfTender).getText();
        return number;
    }

    public String getDate() {
        String date = driver.findElement(dateOfTender).getText();
        return date;
    }

    public String getEndDate() {
        String endDate = driver.findElement(endDateOfTender).getText();
        return endDate;
    }

    public String getName() {
        String name = driver.findElement(nameOfTender).getText();
        return name;
    }

    public String getStartCost() {
        String startCost = driver.findElement(costOfTender).getText();
        return startCost;
    }

    public String getPlace() {
        String place = driver.findElement(placeOfTender).getText();
        return place;
    }

    public List<WebElement> getCategory() {
        driver.findElement(openListPlaceLabel).click();
        List<WebElement> listOfElements = driver.findElements(categoriesOfTender);
        return listOfElements;
    }

    public String getRef() {
        String ref = driver.findElement(refToPage).getAttribute("href");
        return ref;
    }

    public void getElements(PageObject po) {
        System.out.println(po.getNumber());
        System.out.println(po.getDate());
        System.out.println(po.getEndDate());
        System.out.println(po.getName());
        System.out.println(po.getStartCost());
        System.out.println(po.getPlace());
        for(WebElement category:po.getCategory()) {
            System.out.println(category.getText());
        }
        System.out.println(po.getRef());
    }

    public static void main(String[] args) {
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
