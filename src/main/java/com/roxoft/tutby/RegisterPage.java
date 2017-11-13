package com.roxoft.tutby;

import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Esenin on 10.11.2017.
 */
public class RegisterPage extends AbstractPage {



    @FindBy(xpath = "//div[@class = 'b-form-subsection__content' and .//input[@id = 'field-create-email']]")
    private UserRegistr userRegistr;

    @FindBy (xpath = "//div[@id = 'js-phone-block']")
    private UserRegistr phoneInput;

    @FindBy(xpath = "//div[@class = 'b-form-subsection' and .//@name = 'fio']")
    private UserRegistr fioSignIn;

    @FindBy(xpath = "//button[@class = 'b-button b-button-m-big']")
    private ExtendedWebElement finRegButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://profile.tut.by/register.html");
    }

    public void enterEmail(String email){
        userRegistr.getEmail().type(email);
    }

    public  void enterPass(String pass){
        userRegistr.getPassword().type(pass);
    }

    public void enterPhoneNumber(String phone){
        phoneInput.getPhone().type(phone);
    }

    public void enterCode(String lang){
        phoneInput.getCode().click();
    }

    public void clickMailingButton(){
        phoneInput.getCheckMailingButton().click();
    }

    public void enterFio(String name){
        fioSignIn.getFio().type(name);
    }

    public void enterDateOfBirth(String data){
        fioSignIn.getDateOfBirth().type(data);
    }

    public void clickGender(){
        fioSignIn.getGender().click();
    }

    public void enterAddress(String address){
        fioSignIn.getAddress().type(address);
    }

    public ExtendedWebElement getFinRegButton() {
        return finRegButton;
    }

    public void clickRegistrationButton(){
        getFinRegButton().click();
    }


}
