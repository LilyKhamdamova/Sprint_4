import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageobjects.BeforeAfter;
import pageobjects.FormToOrder;
import pageobjects.SamokatFields;

import java.util.concurrent.TimeUnit;

public class SamokatTest extends BeforeAfter {

    private WebDriver driver;

    @Override
    public void tearDown() {
        {
            driver.quit();
        }
    }

    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void linkToSamokatTest() {
        SamokatFields objSamokatFields =  new SamokatFields(driver);
        driver.get(FormToOrder.SCOOTER_PRAKTIKUM_SERVICES_RU);
        objSamokatFields.findElementOnPage();
        objSamokatFields.textToCompare();

    }
}

