package com.kmslh;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ScenarioSecondTest {
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
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.get("https://www.kmslh.com/automation-test/");
    }

    @Test
    void testSecond() {

//      for stable popup loading
        Actions actions = new Actions(driver);
        actions.moveToElement(new MainPage(driver).elementFirstName)
                .build()
                .perform();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("leadinModal-content-wrapper-2379091")));

        new MainPage(driver).elementLinkPopupVideo.click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        final String locatedElementSuccessStory = "//*[@id='container']/h1/yt-formatted-string";

        String st = "GE Healthcare: A KMS Lighthouse Success Story";
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(locatedElementSuccessStory)));
        WebElement elementSuccessStory = driver.findElement(
                By.xpath(locatedElementSuccessStory));
        Assertions.assertEquals(st, elementSuccessStory.getText());
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
