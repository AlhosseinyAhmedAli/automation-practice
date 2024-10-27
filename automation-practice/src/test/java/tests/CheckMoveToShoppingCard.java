package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckMoveToShoppingCard extends TestBase {

    @Test
    public void CheckMoveToShoppingCard() {
        page.homePage().clickAddToBasket();
        page.homePage().ClickViewBusket();

        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,System.getProperty("Basket"));
    }
}

