package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class CheckAddingBookToCart extends TestBase {

    @Test
    public void testItemInCart(){
       page.homePage().clickAddToBasket();
        System.out.println("The Busket Amount is : " +page.homePage().getBusketAmount());
        System.out.println("The Busket Content is : " +page.homePage().getBusketContent());
        Assert.assertFalse(page.homePage().IsBusketAmountEmpty(), "");
        Assert.assertFalse(page.homePage().IsBusketContentEmpty(), "");
    }
}
