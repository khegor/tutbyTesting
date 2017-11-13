package com.roxoft.tutby;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Esenin on 10.11.2017.
 */
public class UserRegistr extends AbstractUIObject {

    @FindBy(xpath = "//input[@id = 'field-email']")
    private ExtendedWebElement email;

    @FindBy(id = "field-password")
    private ExtendedWebElement password;

    @FindBy(xpath = "//input[@id = 'field-phone']")
    private ExtendedWebElement phone;

    @FindBy(xpath = "//div[@class = 'select-wrapper btn-bg']//option[@value = 'ua']")
    private ExtendedWebElement code;

    @FindBy(xpath = "//input[@id = 'send-mailing']")
    private ExtendedWebElement checkMailingButton;

    @FindBy(xpath = ".//input[@name = 'fieldFio']")
    private ExtendedWebElement fio;

    @FindBy(id = "field-birthday")
    private ExtendedWebElement dateOfBirth;

    @FindBy(xpath = ".//label[@for = 'field-sex-female']")
    private ExtendedWebElement gender;

    @FindBy(xpath = ".//input[@id  = 'field-city']")
    private ExtendedWebElement address;

    public UserRegistr(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getEmail() {
        return email;
    }

    public ExtendedWebElement getPassword() {
        return password;
    }

    public ExtendedWebElement getPhone() {
        return phone;
    }

    public ExtendedWebElement getCode() {
        return code;
    }

    public ExtendedWebElement getCheckMailingButton() {
        return checkMailingButton;
    }

    public ExtendedWebElement getFio() {
        return fio;
    }

    public ExtendedWebElement getDateOfBirth() {
        return dateOfBirth;
    }

    public ExtendedWebElement getGender() {
        return gender;
    }

    public ExtendedWebElement getAddress() {
        return address;
    }

}
