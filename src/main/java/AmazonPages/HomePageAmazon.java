package AmazonPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageAmazon extends AmazonBasePage {

    private WebDriver _driver;

    @FindBy(how = How.ID, using = "twotabsearchtextbox")
    private WebElement _search;

    public HomePageAmazon(WebDriver driver)
    {
        super(driver);
        _driver = driver;
        PageFactory.initElements(_driver, this);
    }

    public SearchResultsPageAmazon SearchOnAmazon(String searchString)
    {
        _search.sendKeys(searchString);
        _search.sendKeys(Keys.ENTER);
        return new SearchResultsPageAmazon(_driver);
    }



}
