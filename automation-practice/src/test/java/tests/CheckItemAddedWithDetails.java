package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckItemAddedWithDetails extends TestBase {

    @Test
    public void CheckMoveToShoppingCard() {
        page.homePage().clickAddToBasket();
        page.homePage().ClickViewBusket();

        Assert.assertTrue(page.cartPage().IsProductNameExist());
        Assert.assertTrue(page.cartPage().IsProductPriceExist());
        Assert.assertEquals(page.cartPage().GetProductName(), System.getProperty("Title"));
        Assert.assertEquals(page.cartPage().GetProductPrice(), System.getProperty("Ruba")+System.getProperty("Price"));
        Assert.assertEquals(page.cartPage().GetProductSubTotal(), System.getProperty("Ruba")+System.getProperty("SubTotal"));
        Assert.assertEquals(page.cartPage().GetProductTax(), System.getProperty("Ruba")+System.getProperty("Tax"));
        Assert.assertEquals(page.cartPage().GetTotal(), System.getProperty("Ruba")+System.getProperty("Total"));
    }
}

