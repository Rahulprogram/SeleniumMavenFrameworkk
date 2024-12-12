package SeleniumPractise.Test.SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class scrolling
{
    @Test
    public void scrollings()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        List<WebElement> amountlist= driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum=0;
        for(int i=0;i<amountlist.size();i++)
        {
            sum=sum+Integer.parseInt(amountlist.get(i).getText());


        }
        System.out.println(sum);
        driver.close();


    }

}
