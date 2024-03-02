package pageobjects;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.startsWith;
@RunWith(Parameterized.class)
public class FormSecondPage {

    private WebDriver driver;

    public FormSecondPage(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка "Когда привезти самокат"
    private By deliveryTimeButton = By.xpath(".//div[2]/div[1]/div/div/input");

    // Дата "Когда привезти самокат"
    private By deliveryDate = By.xpath(".//div[2]/div[2]/div[4]/div[7]");

    // Дата "Срок аренды"
    private By rentPeriod = By.xpath(".//div[2]/div[2]/div[2]/div[1]");

    // Период аренды самоката
    private By rentFor3days = By.xpath(".//div[2]/div[2]/div[3][text()='трое суток']");

    // Чек-бокс "Черный цвет самоката"
    private By color = By.xpath(".//div[2]/div[2]/div[3]/label[1]");

    private By comment = By.xpath(".//div[2]/div[2]/div[4]/input");

    private By toOrderButton = By.xpath(".//div[2]/div[3]/button[2]");

    // Кнопка "да"
    private By yesButton = By.xpath(".//div[2]/div[5]/div[2]/button[2]");

    private By orderStatus = By.xpath(".//div[2]/div[5]/div[1][text()=\"Заказ оформлен\"]");


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

    public void checkTheResult() {
        String orderText = driver.findElement(orderStatus).getText();
        String orderIsProcessed = "Заказ оформлен";
        Assert.assertThat(orderText, startsWith(orderIsProcessed));
    }
}
