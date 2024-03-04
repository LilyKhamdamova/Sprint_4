package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class FormToOrder {

    private WebDriver driver;
    private boolean isVisible = true;

    public FormToOrder(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка заказать 1
    private By orderButton = By.xpath(".//div[1]/div[2]/button[1]");

    //Кнопка заказать 2
    private By orderButton2 = By.xpath(".//div[4]/div[2]/div[5]/button");

    // Поле "Имя"
    private By nameInput = By.xpath(".//div[2]/div[2]/div[1]/input");

    // Поле "Фамилия"
    private By lastNameInput = By.xpath(".//div[2]/div[2]/div[2]/input");

    // Поле "Адрес"
    private By addressInput = By.xpath(".//div[2]/div[2]/div[3]/input");

    // Выпадающий список "Станция метро"
    private By metroStationDropdown = By.xpath(".//div[4]/div/div[1]/input");

    // Метро "Сокольники"
    private By metroStationSokolniki = By.xpath(".//div/div[2]/ul/li[4]");

    // Поле "Телефон"
    private By phoneInput = By.xpath(".//div[2]/div[2]/div[5]/input");

    // Кнопка "Далее"
    private By nextButton = By.xpath(".//div[2]/div[3]/button");

    public static final String SCOOTER_PRAKTIKUM_SERVICES_RU = "https://qa-scooter.praktikum-services.ru/";


    public void clickToOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickToSecondButton() {
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

    public void findAndCheckIfTheInputIsVisiable() {
        List<WebElement> elements = driver.findElements(nameInput);
        assertEquals(this.isVisible, elements.size()>0 );
    }
}

