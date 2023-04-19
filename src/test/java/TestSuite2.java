import Pages.LandingPage;
import Pages.SeatsPage;
import org.testng.annotations.*;
public class TestSuite2 extends BaseTest {

    @Test
    public void TestCase3()
    {
        driver.navigate().to("https://ksrtc.in/oprs-web/guest/home.do?h=1");
        LandingPage landingPage = new LandingPage(driver);
        landingPage.SelectRoutesByCities("Chikkamagaluru", "Bengaluru");
        landingPage.SelectCurrentDate();
        SeatsPage seats = landingPage.SearchFOrBus();
        seats.ClickSeatByIndex(0);
        seats.SelectFirstEmptySeat();


    }


}
