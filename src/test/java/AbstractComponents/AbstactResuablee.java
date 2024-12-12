package AbstractComponents;

import EcomercePageobjects.CartPage;
import EcomercePageobjects.OrderHistoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstactResuablee
{
    WebDriver driver;
    public AbstactResuablee(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
   public void waitForElementToAppear(By findBy)
   {

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
       wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
   }

    public void waitForInvisiablityOfElement(WebElement element) throws InterruptedException {
        Thread.sleep(200);
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        //wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForWebElementToAppear(WebElement findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.visibilityOf(findBy));

    }


    @FindBy(css="[routerlink*='cart']")
    WebElement cartheader;

    @FindBy(css="[routerlink*='myorders']")
    WebElement orderheaders;

    public CartPage goToCart()
    {
      cartheader.click();
        CartPage cp= new CartPage(driver);
        return cp;
    }

    public OrderHistoryPage goToOrder()
    {
        orderheaders.click();
        OrderHistoryPage  op= new OrderHistoryPage(driver);
        return op;
    }

}
