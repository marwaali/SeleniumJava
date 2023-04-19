package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeatsPage {

    WebDriver _driver;
    WebDriverWait wait;

    @FindBy(how = How.CSS, using = "ul[class=bus-select-seat] li[onclick] ")
    private List <WebElement> _emptySeats;


    public SeatsPage(WebDriver driver)
    {
        _driver = driver;
        PageFactory.initElements(_driver, this);
        wait = new WebDriverWait(_driver, Duration.ofSeconds(20));
    }


    //zero based element
    public void ClickSeatByIndex(int index)
    {
        WebElement element = _driver.findElement(By.cssSelector("div[class='select-service'] [id = SrvcSelectBtnForward"+index+"]"));
        element.click();
    }

    public void SelectFirstEmptySeat()
    {
        for (WebElement seat: _emptySeats) {
            seat.click();
            break;
        }
    }
}
