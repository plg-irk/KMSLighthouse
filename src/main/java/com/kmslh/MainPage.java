package com.kmslh;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;

    @FindBy(xpath = "//input[contains(@id, 'firstname')]")
    public WebElement elementFirstName;

    @FindBy(xpath = "//input[contains(@id, 'lastname')]")
    public WebElement elementLastName;

    @FindBy(xpath = "//input[contains(@id, 'email')]")
    public WebElement elementEMail;

    @FindBy(xpath = "//input[contains(@id, 'phone')]")
    public WebElement elementPhone;

    @FindBy(xpath = "//input[contains(@id, 'company')]")
    public WebElement elementCompany;

    @FindBy(xpath = "//div[@class='actions']")
    public WebElement elementSubmit;

    @FindBy(xpath = "//*[@id='leadinModal-content-wrapper-2379091']/div/div/span/div/p/a")
    public WebElement elementLinkPopupVideo;

    @FindBy(xpath = "//button[@class='leadinModal-close']")
    public WebElement elementClosePopupVideo;


    public MainPage fillFirstName(String firstName) {
        elementFirstName.sendKeys(firstName);
        return this;
    }

    public MainPage fillLastName(String lastName) {
        elementLastName.sendKeys(lastName);
        return this;
    }

    public MainPage fillEMail(String eMail) {
        elementEMail.sendKeys(eMail);
        return this;
    }

    public MainPage fillPhone(String phone) {
        elementPhone.sendKeys(phone);
        return this;
    }

    public MainPage fillCompany(String company) {
        elementCompany.sendKeys(company);
        return this;
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

