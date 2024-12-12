package Cucumber;

import EcomercePageobjects.*;
import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class StepDefination extends BaseTest
{
    public LandingPage lp;
    public ProductCatalogue pc;
    public ConfirmationPage confirmpage;
    @Given("I landed on ecommerce page")
    public void I_landed_on_ecommerce_page() throws IOException {
       lp= launchApplication();
    }

    @Given("^logged in with username (.+) and password (.+)$")
    public void logged_in_withusername_and_password(String username, String Password)
    {
         pc= lp.loginApplication(username,Password);
    }

    @When("^I add product (.+) to cart$")
    public void I_add_product_to_cart(String productname) throws InterruptedException {
        List<WebElement> products=pc.getProductsList();
        pc.addProductToCart(productname);
    }

    @And("^Checkout(.+) and submit order$")
    public void Checkout_and_submit_order(String productname)
    {
        CartPage cp =pc.goToCart();
        Boolean match=cp.verifyProductDisplay(productname);
        Assert.assertTrue(match);
        CheckoutPage checkpage=cp.ClickonCheckout();
        checkpage.setSelectcountry("india");
         confirmpage=checkpage.SubmitOrder();
    }

   @Then("{string}message displayed on confirmationpage")
    public void message_displayed_on_confirmationpage(String string)
   {
       String confirmmessaged= confirmpage.getconnfirmationmessage();
       Assert.assertTrue(confirmmessaged.equalsIgnoreCase(string));
   }

}
