import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.CoreMatchers.*;



public class SamokatTest {


    private WebDriver driver;

    private By linkButton = By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/a[2]/img");
    private By orderButton = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");
    private By mainPageText = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[4]");

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void DropdownTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(orderButton).click();
        driver.findElement(linkButton).click();
        String testText = driver.findElement(mainPageText).getText();
        Assert.assertThat(testText, startsWith("Самокат"));

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

