package com.kmslh;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScenarioFirstTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.get("https://www.kmslh.com/automation-test/");

    }

    @Test
    @DisplayName("Confirmation the submit")
    @Description("•\tOpen the following page: https://www.kmslh.com/automation-test/\n" +
            "•\tFill all the relevant information with random valid values\n" +
            "•\tSubmit\n" +
            "•\tConfirmation the submit was successful")
    void testFirst() throws InterruptedException {

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String phone = faker.phoneNumber().phoneNumber();
        String company = faker.company().name();

        new MainPage(driver)
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEMail(lastName + "@gb.com")
                .fillPhone(phone)
                .fillCompany(company);

        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//button[@class='leadinModal-close']")));
            new MainPage(driver).elementClosePopupVideo.click();
        } catch (TimeoutException ignored) {

        }

        WebElement elementSubmit = new MainPage(driver).elementSubmit;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                elementSubmit);

        Thread.sleep(500);

        new MainPage(driver).elementSubmit.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h1['Thank you for singing up!']")
        ));
        WebElement elementText = driver.findElement(
                By.xpath("//h1['Thank you for singing up!']"));
        String st = "Thank you for singing up!\n" +
                "We will be in touch with you shortly.";
        Assertions.assertEquals(st, elementText.getText());

    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
