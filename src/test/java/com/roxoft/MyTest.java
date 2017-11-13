package com.roxoft;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.roxoft.tutby.MainPage;
import com.roxoft.tutby.RegisterPage;
import com.roxoft.tutby.dao.MybatisRegistrationData;
import com.roxoft.tutby.models.RegistrationData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.qaprosoft.carina.core.foundation.webdriver.DriverPool.getDriver;

/**
 * Created by Esenin on 10.11.2017.
 */
public class MyTest extends AbstractTest {

    @Test(dataProvider = "SingleDataProvider")
    @MethodOwner(owner = "egorh")
    @XlsDataSourceParameters(path = "xls/demo.xls", sheet = "demo", dsUid = "TUID", dsArgs = "name, surname, mail")
    public void registrationTest(String name, String surname, String email) {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened(), "Main page is not opened");
        mainPage.clickLoginButton();
        RegisterPage registerPage = mainPage.clickRegistrationButton();
        registerPage.enterEmail("eg@gmail");
        registerPage.enterPass("1234");
        registerPage.enterFio(name);
        registerPage.enterDateOfBirth("25.03.1992");
        registerPage.clickGender();
        registerPage.enterAddress("Minsk");
        registerPage.enterPhoneNumber("2502525");
        registerPage.enterCode("UA");
        registerPage.clickMailingButton();
        registerPage.clickRegistrationButton();
    }

    @Test(dataProvider = "MyDataProvider")
    @MethodOwner(owner = "egorh")
    public void registrationTestWithDataPrvider(String name, String surname, String mail) {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();
        Assert.assertTrue(mainPage.isPageOpened(), "Main page is not opened");
        mainPage.clickLoginButton();
        RegisterPage registerPage = mainPage.clickRegistrationButton();
        registerPage.enterEmail(mail);
        registerPage.enterPass("1234");
        registerPage.enterFio(name + " " + surname);
        registerPage.enterDateOfBirth("25.03.1992");
        registerPage.clickGender();
        registerPage.enterAddress("Minsk");
        registerPage.enterPhoneNumber("2502525");
        registerPage.enterCode("UA");
        registerPage.clickMailingButton();
        registerPage.clickRegistrationButton();
    }

    @DataProvider(name = "MyDataProvider")
    public Object[][] getData() {
        return new Object[][]{
                {"egor", "khegor", "egor1234@gmail.com"},
                {"egorka", "ananas", "egorkaananas@huimail.com"}
        };
    }

    @Test
    @MethodOwner(owner = "egorh")
    public void registrationTestWithDB() {

        MybatisRegistrationData mybatisRegistrationData = new MybatisRegistrationData();
        RegistrationData registrationData = new RegistrationData();
        List<RegistrationData>regData = mybatisRegistrationData.getAllRegistartionData();
        for(RegistrationData r : regData) {
            MainPage mainPage = new MainPage(getDriver());
            mainPage.open();
            Assert.assertTrue(mainPage.isPageOpened(), "Main page is not opened");
            mainPage.clickLoginButton();
            RegisterPage registerPage = mainPage.clickRegistrationButton();
            registerPage.enterEmail(r.getMail());
            registerPage.enterPass("1234");
            registerPage.enterFio(r.getName() + " " + r.getSurname());
            registerPage.enterDateOfBirth("25.03.1992");
            registerPage.clickGender();
            registerPage.enterAddress("Minsk");
            registerPage.enterPhoneNumber("2502525");
            registerPage.enterCode("UA");
            registerPage.clickMailingButton();
            registerPage.clickRegistrationButton();
        }
    }
}
