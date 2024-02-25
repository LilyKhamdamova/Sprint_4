import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class WebTest {

    private WebDriver driver;
    private By theMainQuestions = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[1]");
    private By openListToDown = By.xpath("//*[@id=\"accordion__heading-0\"]");
    private By dropdownText = By.xpath("//*[@id=\"accordion__panel-0\"]/p");
    private String expectedDropdownText;

    public WebTest(String expectedDropdownText) {
        this.expectedDropdownText = expectedDropdownText;
    }

    @Parameterized.Parameters
    public static Object[][] checkTheDrop() {
        return new Object[][] {
                { "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                { "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void DropdownTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebElement element = driver.findElement(theMainQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(openListToDown).click();
        WebElement dropdownElement = driver.findElement(dropdownText);
        String newDropdownText = dropdownElement.getText();
        assertThat(newDropdownText, is(expectedDropdownText));
        System.out.println("Expected: " + expectedDropdownText + " | Actual: " + newDropdownText);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
