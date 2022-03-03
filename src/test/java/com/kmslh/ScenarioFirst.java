package com.kmslh;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ScenarioFirst {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MILLISECONDS);

    }

    @Test
    void test() throws InterruptedException {
        driver.get("https://www.kmslh.com/automation-test/");
        Thread.sleep(5000);
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
