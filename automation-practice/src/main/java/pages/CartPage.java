package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[@class='product-name']//a[normalize-space()='Thinking in HTML']")
    private WebElement CartProductName;

    @FindBy(xpath = "//td[@class='product-price']//span[@class='woocommerce-Price-amount amount']")
    private WebElement CartProductPrice;

    @FindBy(xpath = "//a[normalize-space()='Proceed to Checkout']")
    private WebElement ProceedtoCheckout;

    @FindBy(xpath = "//td[@data-title='Subtotal']//span[@class='woocommerce-Price-amount amount']")
    private WebElement ProductSubTotal;

    @FindBy(xpath = "//td[@data-title='Tax']//span[@class='woocommerce-Price-amount amount']")
    private WebElement ProductTax;

    @FindBy(xpath = "//strong//span[@class='woocommerce-Price-amount amount']")
    private WebElement Total;

    public String GetProductName() {
        fluentWaitForElement(CartProductName);
        return CartProductName.getText();
    }

    public String GetProductPrice() {
        fluentWaitForElement(CartProductPrice);
        return CartProductPrice.getText();
    }
    public String GetProductSubTotal() {
        fluentWaitForElement(ProductSubTotal);
        return ProductSubTotal.getText();
    }

    public String GetProductTax() {
        fluentWaitForElement(ProductTax);
        return ProductTax.getText();
    }

    public String GetTotal() {
        fluentWaitForElement(Total);
        return Total.getText();
    }
    public Boolean IsProductNameExist() {
        fluentWaitForElement(CartProductName);
        try
        {
            if (CartProductName.isDisplayed())
            {
                return true;
            }
        }
        catch (NoSuchElementException e) {return false;}
        return false;
    }
    public Boolean IsProductPriceExist() {
        fluentWaitForElement(CartProductPrice);
        try
        {
            if (CartProductPrice.isDisplayed())
            {
                return true;
            }
        }
        catch (NoSuchElementException e) {return false;}
        return false;
    }
    public void ClickProceedToCheckout() {
        fluentWaitForElement(ProceedtoCheckout);
        ProceedtoCheckout.click();
    }
}
