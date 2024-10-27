package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBookExist extends TestBase {

    @Test
    public void CheckBookExist() {

        Assert.assertTrue(page.homePage().IsBookExist(), "Book Not Exist");
        Assert.assertTrue(page.homePage().IsBookPriceExist(), "Book Price Not Exist");
    }
}
