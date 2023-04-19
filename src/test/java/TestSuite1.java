import AmazonPages.*;
import dev.failsafe.internal.util.Assert;
import org.testng.annotations.*;



public class TestSuite1 extends BaseTest {





    @Test
    public void TestCase1(){
        driver.navigate().to("https://www.amazon.com/");
        HomePageAmazon home = new HomePageAmazon(driver);
        SearchResultsPageAmazon search = home.SearchOnAmazon("car accessories");
        ProductDetailsPageAmazon productDetails = search.selectItemByIndex(2);
        String productName = productDetails.GetProductName();
        productDetails.AddToProductCart();
        CartPageAmazon cart = new CartPageAmazon(driver);
        cart.OpenCartsPage();
        boolean result = productName.contains(cart.GetProductNameByIndex(1));
        Assert.isTrue(result,"Products are different");
    }

    @Test
    public void TestCase2() throws InterruptedException {
        driver.navigate().to("https://www.amazon.com/");
        TodayDealsPageAmazon deals = new TodayDealsPageAmazon(driver);
        deals.OpenTodayDealsPage();
        deals.SelectFilterByName("Grocery");
        deals.SelectFilterByName("Headphones");
        deals.SelectDiscountByText("10% off or more");
        deals.NavigateToPageByNumber(4);
        ProductDetailsPageAmazon productDetails = deals.SelectProductByIndex(1);
        productDetails.AddToProductCart();
        Assert.isTrue(productDetails.DoesAddToCartSuccessMessageDisplayed(),"Product isn't added to cart");
    }

}
