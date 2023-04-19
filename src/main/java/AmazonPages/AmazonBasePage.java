package AmazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonBasePage {

    private WebDriver _driver;
    WebDriverWait wait;

    @FindBy(how = How.ID, using = "nav-cart")
    private WebElement _cart;

    @FindBy(how = How.XPATH, using = "//a[text()=\"Today's Deals\"]")
    private  WebElement _todayDeals;

    @FindBy(how = How.CSS, using = "[data-action-type='DISMISS']")
    private WebElement _dismissChange;
    public AmazonBasePage(WebDriver driver) {
        _driver = driver;
        PageFactory.initElements(_driver,this);
        wait = new WebDriverWait(_driver, Duration.ofSeconds(20));
    }

    public CartPageAmazon OpenCartsPage()
    {
        wait.until(ExpectedConditions.elementToBeClickable(_cart));
        _cart.click();
        return new CartPageAmazon(_driver);
    }

    public TodayDealsPageAmazon OpenTodayDealsPage()
    {
        if (_dismissChange.isDisplayed()){
            _dismissChange.click();
        }
        _todayDeals.click();
        return new TodayDealsPageAmazon(_driver);
    }



}
