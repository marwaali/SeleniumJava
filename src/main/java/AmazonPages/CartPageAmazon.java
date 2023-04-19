package AmazonPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPageAmazon extends AmazonBasePage {

    private WebDriver _driver;


    public CartPageAmazon(WebDriver driver)
    {
        super(driver);
        _driver = driver;
    }

    public String GetProductNameByIndex(int index) {
        String text =  _driver.findElement(By.cssSelector("[data-item-index='"+index+"'] span.a-truncate-cut")).getText();
        return text.split("…|\\.{3}")[0];
    }
}
