package EcommerceTest;

import EcomercePageobjects.CartPage;
import EcomercePageobjects.ProductCatalogue;
import TestComponents.BaseTest;
import TestComponents.RetryAnalyzer;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ErrorValidation extends BaseTest
{


    @Test(groups = {"ErrorHandling"}, retryAnalyzer = RetryAnalyzer.class)
    public void LoginErrorValidation()  {

        String username="rahul.k.rawat786@gmail.com";
        String password="1234569076";
        lp.loginApplication(username,password);
        Assert.assertEquals("Incorrect email orr password.", lp.getErrorMessage());

    }


    @Test
    public void ProductErrorValidation() throws InterruptedException {

        String username="rahul.k.rawat786@gmail.com";
        String password="123456";
        String productname="ZARA COAT 3";

        ProductCatalogue pc= lp.loginApplication(username,password);
        List<WebElement> products=pc.getProductsList();
        pc.addProductToCart(productname);
        CartPage cp =pc.goToCart();
        Boolean match=cp.verifyProductDisplay("ZARA COAT 33");
        Assert.assertTrue(match);



    }




}
