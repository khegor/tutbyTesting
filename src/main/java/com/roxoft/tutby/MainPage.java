package com.roxoft.tutby;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Esenin on 10.11.2017.
 */
public class MainPage extends AbstractPage {

    @FindBy(className = "b-topbar-h")
    private OpenForm openForm;

    public MainPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.tut.by/?trnd=66024");
    }

    public void clickLoginButton(){
        openForm.getLoginButton().click();
    }

    public RegisterPage clickRegistrationButton(){
        openForm.getLogFormButton().click();
        return new RegisterPage(getDriver());
    }
}