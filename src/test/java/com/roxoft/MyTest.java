package com.roxoft;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.roxoft.tutby.MainPage;
import com.roxoft.tutby.RegisterPage;
import com.roxoft.tutby.dao.MybatisRegistrationData;
import com.roxoft.tutby.models.RegistrationData;
import com.roxoft.tutby.service.RegistrationService;
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

        RegistrationService registrationService = new RegistrationService();
        registrationService.openPage();
        registrationService.clickRegButton();
        registrationService.registrationTest(name, surname, email, "1234", "25.03.1992", "Minskas", "5502964");
        registrationService.clickMailingButton();
        registrationService.finishRegistration();
    }

    @Test(dataProvider = "MyDataProvider")
    @MethodOwner(owner = "egorh")
    public void registrationTestWithDataPrvider(String name, String surname, String mail) {

        RegistrationService registrationService = new RegistrationService();
        registrationService.openPage();
        registrationService.clickRegButton();
        registrationService.registrationTest(name, surname, mail, "1234", "25.03.1992", "Minsk", "5502964");
        registrationService.clickMailingButton();
        registrationService.finishRegistration();
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
        List<RegistrationData> regData = mybatisRegistrationData.getAllRegistartionData();
        for (RegistrationData r : regData) {
            RegistrationService registrationService = new RegistrationService();
            registrationService.openPage();
            registrationService.clickRegButton();
            registrationService.registrationTest(r.getName(), r.getSurname(), r.getMail(), "1234", "25.03.1992", "Minsk", "5502964");
            registrationService.clickMailingButton();
            registrationService.finishRegistration();
        }
    }

    @Test
    @MethodOwner(owner = "egorh")
    public void registrationTestLast() {

        RegistrationService registrationService = new RegistrationService();
        registrationService.openPage();
        registrationService.clickRegButton();
        registrationService.registrationTest("egor", "khegor", "khegorshmegor", "1234", "25.03.1992", "minsk", "5502964");
        registrationService.clickMailingButton();
        registrationService.finishRegistration();
    }
}
