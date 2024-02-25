import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import static org.hamcrest.CoreMatchers.startsWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

class FormToOrder {

    private WebDriver driver;
    public FormToOrder(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка заказать 1
    private By orderButton = By.xpath(".//div[1]/div[2]/button[1]");

    //Кнопка заказать 2
    private By orderButton2 = By.xpath(".//div/div[4]/div[2]/div[5]/button");

    // Поле "Имя"
    private By nameInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");

    // Поле "Фамилия"
    private By lastNameInput = By.xpath(".//div[2]/div[2]/div[2]/input");

    // Поле "Адрес"
    private By addressInput = By.xpath(".//div[2]/div[2]/div[3]/input");

    // Выпадающий список "Станция метро"
    private By metroStationDropdown = By.xpath(".//div[2]/div[2]/div[4]/div/div[1]/input");

    // Метро "Сокольники"
    private By metroStationSokolniki = By.xpath(".//div[2]/div[2]/div[4]/div/div[2]/ul/li[4]");

    // Поле "Телефон"
    private By phoneInput = By.xpath(".//div[2]/div[2]/div[5]/input");

    // Кнопка "Далее"
    private By nextButton = By.xpath(".//div[2]/div[3]/button");

    public void clickToOrderButton (){
        driver.findElement(orderButton).click();
    }

    public void clickToSecondButton (){
        WebElement element = driver.findElement(orderButton2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderButton2).click();
    }

    public void fillTheForm(String name, String familyName, String address, String phoneNumber) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(lastNameInput).sendKeys(familyName);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(metroStationDropdown).click();
        driver.findElement(metroStationSokolniki).click();
        driver.findElement(phoneInput).sendKeys(phoneNumber);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
}

class FormSecondPage {

    private WebDriver driver;
    public FormSecondPage(WebDriver driver) {
        this.driver = driver;
    }
    // Кнопка "Когда привезти самокат"
    private By deliveryTimeButton = By.xpath(".//div[2]/div[2]/div[1]/div/div/input");

    // Дата "Когда привезти самокат"
    private By deliveryDate = By.xpath(".//div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[7]");

    // Дата "Срок аренды"
    private By rentPeriod = By.xpath(".//div[2]/div[2]/div[2]/div[1]");

    // Период аренды самоката
    private By rentFor3days = By.xpath(".//div[2]/div[2]/div[2]/div[2]/div[3][text()='трое суток']");

    // Чек-бокс "Черный цвет самоката"
    private By color = By.xpath(".//div[2]/div[2]/div[3]/label[1]");

    private By comment = By.xpath(".//div[2]/div[2]/div[4]/input");

    private By toOrderButton = By.xpath(".//div[2]/div[3]/button[2]");

    // Кнопка "да"
    private By yesButton = By.xpath(".//div[2]/div[5]/div[2]/button[2]");

    private By orderStatus = By.xpath(".//div/div/div[2]/div[5]/div[1][text()=\"Заказ оформлен\"]");


    public void fillTheSecondForm(String commentText) {
        driver.findElement(deliveryTimeButton).click();
        driver.findElement(deliveryDate).click();
        driver.findElement(rentPeriod).click();
        driver.findElement(rentFor3days).click();
        driver.findElement(color).click();
        driver.findElement(comment).sendKeys(commentText);
        driver.findElement(toOrderButton).click();
    }
    public void orderComplete() {
        driver.findElement(yesButton).click();
    }

    public void checkTheResult () {
        String orderText = driver.findElement(orderStatus).getText();
        String orderIsProcessed = "Заказ оформлен";
        String good = "good";
        Assert.assertThat(orderText, startsWith(orderIsProcessed));
    }
}


public class OrderTest {

    private WebDriver driver;


    @Before
    public void setUp() {

    }

    @Test
    public void orderTestChrome() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        FormToOrder objFormToOrder = new FormToOrder(driver);
        objFormToOrder.clickToOrderButton();
        objFormToOrder.fillTheForm("Анна", "Тестовая",  "ул. Костромская д.2 кв.120", "+79961218586");
        objFormToOrder.clickNextButton();
        FormSecondPage objFormSecondPage = new FormSecondPage(driver);
        objFormSecondPage.fillTheSecondForm("Есть шлагбаум");
        objFormSecondPage.orderComplete();
        objFormSecondPage.checkTheResult ();
    }

    @Test
    public void orderTestFirefox() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        FormToOrder objFormToOrder = new FormToOrder(driver);
        objFormToOrder.clickToSecondButton();
        objFormToOrder.fillTheForm("Юлий", "Иванов", "г.Казань, ул.Фучика д.15", "+79992221234");
        objFormToOrder.clickNextButton();
        FormSecondPage objFormSecondPage = new FormSecondPage(driver);
        objFormSecondPage.fillTheSecondForm("Есть шлагбаум");
        objFormSecondPage.orderComplete();
        objFormSecondPage.checkTheResult();
    }

    @After

    public void tearDown() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.quit();
    }
}
