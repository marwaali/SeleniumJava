package Pages;
import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LandingPage {

    WebDriver _driver;

    @FindBy(how = How.XPATH, using = "//a[contains(@class,'ui-state-highlight')]")
    private WebElement _currentDate;

    @FindBy(how = How.ID, using = "ui-datepicker-div")
    private WebElement _calendar;

    @FindBy(how = How.ID, using = "txtJourneyDate")
    private WebElement _startDate;

    @FindBy(how = How.CSS,using = "button[onclick*='openTTDConfirmPopoUp']")
    private WebElement _searchForBus;

    WebDriverWait wait;

    public LandingPage(WebDriver driver)
    {
        _driver = driver;
        PageFactory.initElements(_driver, this);
        wait = new WebDriverWait(_driver, Duration.ofSeconds(20));
    }

    public void SelectRoutesByCities(String from, String to)
    {
        List <WebElement> routes = _driver.findElements(By.xpath("//a[contains(@onclick,'"+from+"') and contains(@onclick,'"+to+"')]"));
        for(WebElement route: routes)
        {
            wait.until(ExpectedConditions.elementToBeClickable(route));
            String text = route.getText();
            if (text.contains(from+" - " + to))
            {
                route.click();
            }
        }
    }


    public void SelectCurrentDate()
    {
        _startDate.click();
        _currentDate.click();
    }

    public SeatsPage SearchFOrBus()
    {
        _searchForBus.click();
        return new SeatsPage(_driver);
    }

}
