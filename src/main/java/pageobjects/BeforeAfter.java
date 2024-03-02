package pageobjects;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BeforeAfter {
    WebDriver driver;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        long time = 10;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
