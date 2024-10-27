package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//td[@class='product-name']")
    private WebElement ProductName;

    @FindBy(xpath = "//td[@class='product-total']//span[@class='woocommerce-Price-amount amount']")
    private WebElement ProductTotal;

    @FindBy(xpath = "//tr[@class='cart-subtotal']//span[@class='woocommerce-Price-amount amount']")
    private WebElement ProductSubTotal;

    @FindBy(xpath = "//tr[@class='tax-rate tax-rate-in-tax-1']//span[@class='woocommerce-Price-amount amount']")
    private WebElement ProductTax;

    @FindBy(xpath = "//tr[@class='order-total']//span[@class='woocommerce-Price-amount amount']")
    private WebElement Total;



    public String GetProductName() {
        fluentWaitForElement(ProductName);
        return ProductName.getText();
    }

    public String GetProductTotal() {
        fluentWaitForElement(ProductTotal);
        return ProductTotal.getText();
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
}
