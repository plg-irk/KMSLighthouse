package com.kmslh;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPage {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));

        driver.get("https://www.kmslh.com/automation-test/");
//        Thread.sleep(5000);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(
                By.id("firstname-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814")))
                .build()
                .perform();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("firstname-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814")));
        driver.findElement(By.id("firstname-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814"));

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("leadinModal-content-wrapper-2379091")));
        driver.findElement(By.id("leadinModal-content-wrapper-2379091"));


//        ((JavascriptExecutor) driver).executeScript(
//                " var elem = document.getElementById('hs-eu-cookie-confirmation');\n" +
//                        "  elem.remove();");
//        driver.findElement(By.xpath("//*[@id=\"hs-eu-cookie-confirmation\"]"));
//        driver.findElement(By.xpath("//*[@id=\"hs-eu-confirmation-button\"]"));


//        WebElement element = driver.findElement(By.xpath(
//                "//*[@id=\"leadinModal-content-wrapper-2379091\"]/div/div/span/div/p/a"));
//        element.click();


        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println("tabs= " + tabs);
//        driver.switchTo().window(tabs.get(1));

        WebElement element1 = driver.findElement(
                By.xpath("//*[@id=\"container\"]/h1/yt-formatted-string"));
        System.out.println(element1.getText());


//        ((JavascriptExecutor) driver).executeScript("window.open()");
//        ((JavascriptExecutor) driver).executeScript(
//                " var elem = document.getElementById('top');\n" +
//                        "  elem.remove();");

        List<String> tabs1 = new ArrayList<>(driver.getWindowHandles());
        System.out.println("tabs1= " + tabs1);

//        Thread.sleep(5000);
//        driver.quit();
    }
}
