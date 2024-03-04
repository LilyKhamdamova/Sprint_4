import org.junit.Test;
import pageobjects.FormToOrder;

import java.util.concurrent.TimeUnit;


public class OrderFromSecondButtonTest extends BeforeAfterAnnotations {

    @Test
    public void orderTestSecondButton() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(FormToOrder.SCOOTER_PRAKTIKUM_SERVICES_RU);

        FormToOrder objFormToOrder = new FormToOrder(driver);
        objFormToOrder.clickToSecondButton();
        objFormToOrder.findAndCheckIfTheInputIsVisiable();
    }
}

