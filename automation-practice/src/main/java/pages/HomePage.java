package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[normalize-space()='Thinking in HTML']")
    private WebElement bookTitle;

    @FindBy(xpath = "//ins//span[contains(@class,'woocommerce-Price-amount amount')]")
    private WebElement bookPrice;

    @FindBy(xpath = "(//a[@class='button product_type_simple add_to_cart_button ajax_add_to_cart'][normalize-space()='Add to basket'])[2]")
    private WebElement addToBasketButton;

    @FindBy(xpath = "//i[@class='wpmenucart-icon-shopping-cart-0']")
    private WebElement BusketIcon;

    @FindBy(xpath = "//span[@class='cartcontents']")
    private WebElement BusketContent;

    @FindBy(xpath = "//span[@class='amount']")
    private WebElement BusketAmount;
    @FindBy(xpath = "//a[normalize-space()='View Basket']")
    private WebElement ViewBasket;


    public String getBookTitle() {
        fluentWaitForElement(bookTitle);
        return bookTitle.getText();
    }
    public String getBookPrice() {
        fluentWaitForElement(bookPrice);
        return bookPrice.getText();
    }
    public void ClickViewBusket(){
        fluentWaitForElement(ViewBasket);
        ViewBasket.click();
    }

    public void clickAddToBasket(){
        fluentWaitForElement(addToBasketButton);
        addToBasketButton.click();
        fluentWaitForElement(ViewBasket);
    }
    public void HoverOnBusketContent(){
        fluentWaitForElement(BusketContent);
        hover(BusketIcon);
    }
    public void HoverOnBusketAmount(){
        fluentWaitForElement(BusketContent);
        hover(BusketIcon);
    }
    public String getBusketAmount() {
        fluentWaitForElement(BusketAmount);
        return BusketAmount.getText();
    }
    public String getBusketContent() {
        fluentWaitForElement(BusketContent);
        return BusketContent.getText();
    }

    public Boolean IsBookExist() {
        fluentWaitForElement(bookTitle);
        try
        {
            if (bookTitle.isDisplayed())
            {
                return true;
            }
        }
        catch (NoSuchElementException e) {return false;}
        return false;
    }
    public Boolean IsBookPriceExist() {
        fluentWaitForElement(bookPrice);
        try
        {
            if (bookPrice.isDisplayed())
            {
                return true;
            }
        }
        catch (NoSuchElementException e) {return false;}
        return false;
    }
    public Boolean IsBusketAmountEmpty() {
        fluentWaitForElement(BusketAmount);
        try
        {
            if (BusketAmount.getText().equals("₹0.00"))
            {
                return true;
            }
        }
        catch (NoSuchElementException e) {return false;}
        return false;
    }
    public Boolean IsBusketContentEmpty() {
        fluentWaitForElement(BusketContent);
        try
        {
            if (BusketContent.getText().equals("0 items"))
            {
                return true;
            }
        }
        catch (NoSuchElementException e) {return false;}
        return false;
    }
}
