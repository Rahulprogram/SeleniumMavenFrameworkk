package EcommerceTest;

import EcomercePageobjects.*;
import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Standalone2 extends BaseTest
{
   // String productname="ZARA COAT 3";
  //  String username="rahul.k.rawat786@gmail.com";
   // String password="123456";
    String countryname="india";
    @Test(dataProvider = "GetData",groups={"Purchase"})

    public void SubmitOrder(String email, String password, String productname) throws IOException, InterruptedException
    {
    ProductCatalogue pc= lp.loginApplication(email,password);
    List<WebElement> products=pc.getProductsList();
    pc.addProductToCart(productname);
    CartPage cp =pc.goToCart();
    Boolean match=cp.verifyProductDisplay(productname);
    Assert.assertTrue(match);
    CheckoutPage checkpage=cp.ClickonCheckout();
    checkpage.setSelectcountry(countryname);
    ConfirmationPage confirmpage=checkpage.SubmitOrder();
    String confirmmessaged= confirmpage.getconnfirmationmessage();
    Assert.assertTrue(confirmmessaged.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

}

@Test(dependsOnMethods = {"SubmitOrder"}, dataProvider = "GetData")
public void OrderHistoryTest(String email, String password, String productname)
{
    ProductCatalogue pc= lp.loginApplication(email,password);
    OrderHistoryPage  op=pc.goToOrder();
    Assert.assertTrue(op.verifyOrderDisplay(productname));
}

@DataProvider
public Object[][] GetData()
{
    return new Object[][] {{"rahul.k.rawat786@gmail.com","123456","ZARA COAT 3"},{"rawat786@gmail.com","123456789","ZARA COAT 3"}};
}


}
