import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageobjects.FormToOrder;
import pageobjects.SamokatFields;

import java.util.concurrent.TimeUnit;

public class SamokatTest {

    private WebDriver driver;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void dropdownTest() {
        SamokatFields objSamokatFields =  new SamokatFields(driver);
        driver.get(FormToOrder.SCOOTER_PRAKTIKUM_SERVICES_RU);
        objSamokatFields.findElementOnPage();
        objSamokatFields.textToCompare();

    }

    @After
    public void tearDown() {
        {
            driver.quit();
        }
    }
}

