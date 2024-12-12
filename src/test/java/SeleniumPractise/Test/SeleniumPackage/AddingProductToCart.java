package SeleniumPractise.Test.SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AddingProductToCart
{
    @Test
    public void addproducttocart()
    {
        WebDriver driver= new ChromeDriver();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Explicit wait
        WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(6));


        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        String[]veggeiesname={"Cucumber","Beetroot","Beans"};

        List<WebElement> productname= driver.findElements(By.cssSelector(".product-name"));
        for(int i=0;i<productname.size();i++)
        {
            String[] getproductname= productname.get(i).getText().split("-");

            String formatproductname=getproductname[0].trim();

            List itemneeded= Arrays.asList(veggeiesname);

            if(itemneeded.contains(formatproductname))
            {

                System.out.println(productname.get(i).getText());
               driver.findElements(By.cssSelector(".product-action")).get(i).click();


            }
        }

        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
        driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".promoBtn")).click();
        System.out.println(driver.findElement(By.xpath("//span[text()='Code applied ..!']")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Code applied ..!']")).getText(),"Code applied ..!");

        driver.close();


    }

    @Test
    public void addproducttocart2()
    {
        WebDriver driver= new ChromeDriver();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Explicit wait
        WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(6));


        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        String[]veggeiesname={"Capsicum","Mushroom","Potato"};

        List<WebElement> productname= driver.findElements(By.cssSelector(".product-name"));
        for(int i=0;i<productname.size();i++)
        {
            String[] getproductname= productname.get(i).getText().split("-");

            String formatproductname=getproductname[0].trim();

            List itemneeded= Arrays.asList(veggeiesname);

            if(itemneeded.contains(formatproductname))
            {

                System.out.println(productname.get(i).getText());
                driver.findElements(By.cssSelector(".product-action")).get(i).click();


            }
        }

        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
        driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".promoBtn")).click();
        System.out.println(driver.findElement(By.xpath("//span[text()='Code applied ..!']")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Code applied ..!']")).getText(),"Code applied ..!");

        driver.close();


    }
}
