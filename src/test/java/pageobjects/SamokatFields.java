package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.startsWith;

public class SamokatFields {
    private WebDriver driver;

    private By linkButton = By.xpath(".//div[1]/div[1]/a[2]");
    private By orderButton = By.xpath(".//div[1]/div[2]/button[1]");
    private By mainPageText = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[4]");

    public SamokatFields(WebDriver driver) {
        this.driver = driver;
    }

    public void findElementOnPage() {
        driver.findElement(orderButton).click();
        driver.findElement(linkButton).click();
    }

    public void textToCompare() {
        String testText = driver.findElement(mainPageText).getText();
        Assert.assertThat(testText, startsWith("Самокат"));
    }
}