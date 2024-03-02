import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.concurrent.TimeUnit;

import pageobjects.BeforeAfterOrderTest;
import pageobjects.FormSecondPage;
import pageobjects.FormToOrder;

@RunWith(Parameterized.class)
public class OrderTest extends BeforeAfterOrderTest {

    private String name;
    private String familyName;
    private String address;
    private String phoneNumber;

    public OrderTest(String name, String familyName, String address, String phoneNumber) {
        this.name = name;
        this.familyName = familyName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"Анна", "Тестовая", "ул. Костромская д.2 кв.120", "+79961218586"},
                {"Юлий", "Иванов", "г.Казань, ул.Фучика д.15", "+79992221234"},
        };
    }

    @Test
    public void orderTestFirstButton() {
        driver.get(FormToOrder.SCOOTER_PRAKTIKUM_SERVICES_RU);
        FormToOrder objFormToOrder = new FormToOrder(driver);
        objFormToOrder.clickToOrderButton();
        objFormToOrder.fillTheForm(name, familyName, address, phoneNumber);
        objFormToOrder.clickNextButton();

        FormSecondPage objFormSecondPage = new FormSecondPage(driver);
        objFormSecondPage.fillTheSecondForm("Есть шлагбаум");
        objFormSecondPage.orderComplete();
        objFormSecondPage.checkTheResult();
    }

    @Test
    public void orderTestSecondButton() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(FormToOrder.SCOOTER_PRAKTIKUM_SERVICES_RU);

        pageobjects.FormToOrder objFormToOrder = new pageobjects.FormToOrder(driver);
        objFormToOrder.clickToSecondButton();
        objFormToOrder.findAndCheckIfTheInputIsVisiable();
    }

}
