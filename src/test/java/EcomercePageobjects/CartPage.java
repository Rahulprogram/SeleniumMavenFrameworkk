package EcomercePageobjects;

import AbstractComponents.AbstactResuablee;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstactResuablee
{
    WebDriver driver;
    public CartPage(WebDriver driver)
    {

        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".cartSection h3")
    private List<WebElement> producttitles;

    @FindBy(css=".totalRow button")
    WebElement checkout;

    public Boolean verifyProductDisplay(String productname)
    {
        Boolean match=producttitles.stream().anyMatch((cartproduct->cartproduct.getText().equalsIgnoreCase(productname)));
        return match;
    }

    public CheckoutPage ClickonCheckout()
    {
        checkout.click();
        CheckoutPage checkpage= new CheckoutPage(driver);
        return checkpage;
    }

}
