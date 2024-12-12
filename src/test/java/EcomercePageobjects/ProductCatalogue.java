package EcomercePageobjects;

import AbstractComponents.AbstactResuablee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AbstactResuablee
{
    WebDriver driver;
    public ProductCatalogue(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

   @FindBy(css=".mb-3")
   List<WebElement> products;

   @FindBy(css=".ng-animating")
    WebElement spinner;



    By addtocart= By.cssSelector(".card-body button:last-of-type");
    By toastmessage= By.cssSelector("#toast-container");


     public List<WebElement> getProductsList()
     {
         return products;
     }

     public WebElement getProductName(String productname)
     {
         WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
         return prod;
     }

     public void addProductToCart(String productname) throws InterruptedException {
         WebElement prod= getProductName( productname);
         prod.findElement(addtocart).click();
         waitForElementToAppear(toastmessage);
         waitForInvisiablityOfElement(spinner);
     }



}
