import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void BeforeMethod()
    {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
    }


    @AfterMethod
    public void AfterMethod()
    {
        driver.quit();
    }
}
