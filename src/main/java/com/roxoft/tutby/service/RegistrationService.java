package com.roxoft.tutby.service;

import com.roxoft.tutby.MainPage;
import com.roxoft.tutby.RegisterPage;
import org.testng.Assert;

import static com.qaprosoft.carina.core.foundation.webdriver.DriverPool.getDriver;

/**
 * Created by Esenin on 13.11.2017.
 */
public class RegistrationService {

    public void openPage() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened(), "Main page is not opened");
    }

    public void clickRegButton(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickLoginButton();
        mainPage.clickRegistrationButton();
    }

    public void registrationTest(String name, String surname, String mail, String password,
                                        String dataOfBirth, String address, String phone) {
        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.enterEmail(mail);
        registerPage.enterPass(password);
        registerPage.enterFio(name + " " + surname);
        registerPage.enterDateOfBirth(dataOfBirth);
        registerPage.clickGender();
        registerPage.enterAddress(address);
        registerPage.enterPhoneNumber(phone);
        registerPage.enterCode("UA");
    }

    public void clickMailingButton() {
        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.clickMailingButton();
    }

    public void finishRegistration(){
        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.clickRegistrationButton();
    }

}
