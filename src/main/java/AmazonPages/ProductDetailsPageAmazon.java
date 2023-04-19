package AmazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPageAmazon extends AmazonBasePage {

    private WebDriver _driver;

    @FindBy(how = How.ID, using = "add-to-cart-button")
    private WebElement _addToCart;

    @FindBy(how = How.ID, using = "title")
    private WebElement _productName;

    @FindBy(how = How.ID, using = "NATC_SMART_WAGON_CONF_MSG_SUCCESS")
    private WebElement _successMessage;

    @FindBy(how = How.CLASS_NAME, using = "added-to-cart-message-box")
    private WebElement _message;

    public ProductDetailsPageAmazon(WebDriver driver)
    {
        super(driver);
        _driver = driver;
        PageFactory.initElements(_driver, this);
    }

    public void AddToProductCart()
    {
        _addToCart.click();
        wait.until(ExpectedConditions.visibilityOf(_successMessage));
    }
    public String GetProductName() {
        return  _productName.getText();
    }

    public boolean DoesAddToCartSuccessMessageDisplayed()
    {
        return _successMessage.isDisplayed();
    }
}
