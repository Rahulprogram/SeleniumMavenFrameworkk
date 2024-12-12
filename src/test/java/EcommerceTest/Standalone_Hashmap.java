package EcommerceTest;

import EcomercePageobjects.*;
import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Standalone_Hashmap extends BaseTest
{
   // String productname="ZARA COAT 3";
  //  String username="rahul.k.rawat786@gmail.com";
   // String password="123456";
    String countryname="India";


    @Test(dataProvider = "GetData",groups={"Purchase"})

    public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException
    {
    ProductCatalogue pc= lp.loginApplication(input.get("Email"),input.get("Password"));
    List<WebElement> products=pc.getProductsList();
    pc.addProductToCart(input.get("Product"));
    CartPage cp =pc.goToCart();
    Boolean match=cp.verifyProductDisplay(input.get("Product"));
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
    HashMap<String,String> map= new HashMap<String,String>();
    map.put("Email","rahul.k.rawat786@gmail.com");
    map.put("Password","123456");
    map.put("Product","ZARA COAT 3");

    HashMap<String,String> map1= new HashMap<String,String>();
    map1.put("Email","rawat786@gmail.com");
    map1.put("Password","123456");
    map1.put("Product","ZARA COAT 34");

    return new Object[][] {{map},{map1}};
}


}
