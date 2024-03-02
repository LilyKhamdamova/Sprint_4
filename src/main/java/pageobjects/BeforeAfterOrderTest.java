package pageobjects;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BeforeAfterOrderTest {

    protected boolean useFirefox;
    protected WebDriver driver;

    public WebDriver getWebDriver(boolean useFirefox) {
        this.useFirefox = useFirefox;
        if (useFirefox) {
            return new FirefoxDriver();
        } else {
            return new ChromeDriver();
        }
    }

    @Before
    public void setUp() {
        driver = getWebDriver(true);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
