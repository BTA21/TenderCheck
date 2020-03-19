package parser;

import org.openqa.selenium.By;

public class PageObject {
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
    By categoriesOfTender = By.xpath("//div [@class = 'table-constructor']/div [@class = 'tender-row'][1]//" +
            "div [@class ='tender-branch']//li[text()]");
    By refToPage = By.xpath("//div [@class = 'table-constructor']/div [@class = 'tender-row'][1]//div [@class ='tender-info']//div [@class = 'description']//a");


}
