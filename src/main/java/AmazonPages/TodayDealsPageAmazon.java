package AmazonPages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TodayDealsPageAmazon extends AmazonBasePage {

    private WebDriver _driver;

    @FindBy(how = How.ID, using = "twotabsearchtextbox")
    private WebElement _search;

    @FindBy(how = How.XPATH, using = "//a[text()='Next']/ancestor::li")
    private WebElement _nextButton;

    public TodayDealsPageAmazon(WebDriver driver)
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

    public void SelectFilterByName(String name)
    {
        WebElement filter = _driver.findElement(By.xpath("//span[text()='"+name+"']/ancestor::label/input"));
        filter.click();
    }

    public void SelectDiscountByText(String text)
    {
        WebElement discount = _driver.findElement(By.xpath("//span[text()='"+text+"']"));
        discount.click();
    }

    public void NavigateToPageByNumber(int number) throws InterruptedException {

        for (int i = 1; i<number;i++)
        {
            Thread.sleep(2000);
            Utilities.MoveToElement(_driver,_nextButton);
            _nextButton.click();
        }
    }

    public ProductDetailsPageAmazon SelectProductByIndex(int index)
    {
        WebElement product = _driver.findElement(By.xpath("(//div[@data-testid='deal-card'])["+index+"]/a"));
        product.click();
        return new ProductDetailsPageAmazon(_driver);
    }

}
