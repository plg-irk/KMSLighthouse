package com.kmslh;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScenarioFirst {
    WebDriver driver;

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
        driver.get("https://www.kmslh.com/automation-test/");

    }

    @Test
    void testFirst() throws InterruptedException {

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String phone = faker.phoneNumber().phoneNumber();
        String company = faker.company().name();

        WebElement elementFirstName = driver.findElement(
                By.id("firstname-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814"));
        elementFirstName.sendKeys(firstName);

        WebElement elementLastName = driver.findElement(
                By.id("lastname-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814"));
        elementLastName.sendKeys(lastName);

        WebElement elementEMail = driver.findElement(
                By.id("email-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814"));
        elementEMail.sendKeys(lastName + "@gb.com");

        WebElement elementPhone = driver.findElement(
                By.id("phone-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814"));
        elementPhone.sendKeys(phone);

        WebElement elementCompany = driver.findElement(
                By.id("company-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814"));
        elementCompany.sendKeys(company);

        Thread.sleep(3000);

        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//button[@class='leadinModal-close']")));
            driver.findElement(
                    By.xpath("//button[@class='leadinModal-close']")).click();
        } catch (TimeoutException ignored) {

        }

        WebElement elementSubmit = driver.findElement(By.xpath("//div[@class='actions']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                elementSubmit);

        Thread.sleep(500);

        driver.findElement(By.xpath("//div[@class='actions']")).click();

        Thread.sleep(3000);

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
