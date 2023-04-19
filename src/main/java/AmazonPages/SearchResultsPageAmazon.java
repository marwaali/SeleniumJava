package AmazonPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPageAmazon extends AmazonBasePage {

    private WebDriver _driver;

    public SearchResultsPageAmazon(WebDriver driver)
    {
        super(driver);
        _driver = driver;
    }

    public ProductDetailsPageAmazon selectItemByIndex(int index)
    {
        WebElement element = _driver.findElement(By.xpath("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-"+index+"']"));
        element.click();
        return new ProductDetailsPageAmazon(_driver);
    }



}
