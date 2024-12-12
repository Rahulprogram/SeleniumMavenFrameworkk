package EcommerceTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Standalone
{
    public static void main(String[] args)
{
    String productname="ZARA COAT 3";
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
    driver.get("https://rahulshettyacademy.com/client");
    driver.manage().window().maximize();
    driver.findElement(By.cssSelector("#userEmail")).sendKeys("rahul.k.rawat786@gmail.com");
    driver.findElement(By.cssSelector("#userPassword")).sendKeys("123456");
    driver.findElement(By.cssSelector("#login")).click();
    List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
    WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
    prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
    driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

    List<WebElement> cartproducts= driver.findElements(By.cssSelector(".cartSection h3"));
    Boolean match=cartproducts.stream().anyMatch((cartproduct->cartproduct.getText().equalsIgnoreCase(productname)));
    Assert.assertTrue(match);

    driver.findElement(By.cssSelector(".totalRow button")).click();

    Actions a = new Actions(driver);
    a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

    driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
    driver.findElement(By.cssSelector(".action__submit")).click();

    String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));




    driver.close();
}

}
