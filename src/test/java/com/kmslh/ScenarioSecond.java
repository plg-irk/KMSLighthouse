package com.kmslh;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ScenarioSecond {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
        driver.get("https://www.kmslh.com/automation-test/");
    }

    @Test
    void test() throws InterruptedException {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(120));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("leadinModal-content-wrapper-2379091")));

        WebElement element = driver.findElement(By.xpath(
                "//*[@id=\"leadinModal-content-wrapper-2379091\"]/div/div/span/div/p/a"));
        element.click();
        Thread.sleep(5000);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String st = "GE Healthcare: A KMS Lighthouse Success Story";
        WebElement element1 = driver.findElement(
                By.xpath("//*[@id=\"container\"]/h1/yt-formatted-string"));
        Assertions.assertEquals(st, element1.getText());
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
