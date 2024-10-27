package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBillingDetails extends TestBase {

    @Test
    public void testItemInCart(){
        page.homePage().clickAddToBasket();
        page.homePage().ClickViewBusket();
        page.cartPage().ClickProceedToCheckout();

        Assert.assertEquals(page.CheckoutPage().GetProductName(), System.getProperty("Title")+"  × "+System.getProperty("Quentity"));
        Assert.assertEquals(page.CheckoutPage().GetProductTotal(), System.getProperty("Ruba")+System.getProperty("Price"));
        Assert.assertEquals(page.CheckoutPage().GetProductSubTotal(), System.getProperty("Ruba")+System.getProperty("SubTotal"));
        Assert.assertEquals(page.CheckoutPage().GetProductTax(), System.getProperty("Ruba")+System.getProperty("Tax"));
        Assert.assertEquals(page.CheckoutPage().GetTotal(), System.getProperty("Ruba")+System.getProperty("Total"));
    }
}
