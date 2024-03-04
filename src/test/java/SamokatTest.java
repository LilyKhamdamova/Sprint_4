import org.junit.Test;
import pageobjects.FormToOrder;
import pageobjects.SamokatFields;


public class SamokatTest extends BeforeAfterAnnotations {


    @Test
    public void linkToSamokatTest() {
        SamokatFields objSamokatFields =  new SamokatFields(driver);
        driver.get(FormToOrder.SCOOTER_PRAKTIKUM_SERVICES_RU);
        objSamokatFields.checkingСlickOnSamocatIcon();
        objSamokatFields.textToCompare();

    }
}

