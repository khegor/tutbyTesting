package com.roxoft.tutby;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Esenin on 10.11.2017.
 */
public class OpenForm extends AbstractUIObject {

    @FindBy(xpath = ".//div[@class = 'b-auth-i']/a")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//a[@class= 'button wide auth__reg']")
    private ExtendedWebElement logFormButton;

    public OpenForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public ExtendedWebElement getLoginButton() {
        return loginButton;
    }

    public ExtendedWebElement getLogFormButton() {
        return logFormButton;
    }
}