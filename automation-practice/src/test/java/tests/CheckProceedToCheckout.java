package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckProceedToCheckout extends TestBase {

    @Test
    public void CheckMoveToShoppingCard() {
        page.homePage().clickAddToBasket();
        page.homePage().ClickViewBusket();
        page.cartPage().ClickProceedToCheckout();

        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,System.getProperty("CheckOut"));
    }
}

