package EcommerceTest;

import EcomercePageobjects.*;
import TestComponents.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Standalone_Json extends BaseTest
{
   // String productname="ZARA COAT 3";
  //  String username="rahul.k.rawat786@gmail.com";
   // String password="123456";
    String countryname="India";


    @Test(dataProvider = "GetData",groups={"Purchase"})

    public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException
    {
    ProductCatalogue pc= lp.loginApplication(input.get("email"),input.get("password"));
    List<WebElement> products=pc.getProductsList();
    pc.addProductToCart(input.get("Product"));
    CartPage cp =pc.goToCart();
    Boolean match=cp.verifyProductDisplay(input.get("product"));
    Assert.assertTrue(match);
    CheckoutPage checkpage=cp.ClickonCheckout();
    checkpage.setSelectcountry(countryname);
    ConfirmationPage confirmpage=checkpage.SubmitOrder();
    String confirmmessaged= confirmpage.getconnfirmationmessage();
    Assert.assertTrue(confirmmessaged.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

}

@Test(dependsOnMethods = {"SubmitOrder"}, dataProvider = "GetData")
public void OrderHistoryTest(HashMap<String,String> input)
{
    ProductCatalogue pc= lp.loginApplication(input.get("email"),input.get("password"));
    OrderHistoryPage  op=pc.goToOrder();
    Assert.assertTrue(op.verifyOrderDisplay(input.get("product")));
}

@DataProvider
public Object[][] GetData() throws IOException
{

    List<HashMap<String,String>> data= getJsonDataToHasmap(System.getProperty("user.dir")+"\\src\\test\\java\\DataRead\\Purchase.json");
    return new Object[][] {{data.get(0)},{data.get(1)}};
}




}
