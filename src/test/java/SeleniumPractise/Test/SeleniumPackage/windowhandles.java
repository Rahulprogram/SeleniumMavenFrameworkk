package SeleniumPractise.Test.SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.*;

public class windowhandles
{
    @Test
    public void windowhandles()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> window=driver.getWindowHandles();
        Iterator<String> it=window.iterator();
        String parentid = it.next();
        String childid= it.next();
        driver.switchTo().window(childid);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        String message= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ") [0];
        System.out.println(message);
        driver.close();
        driver.switchTo().window(parentid);
        driver.findElement(By.cssSelector("#username")).sendKeys(message);
        driver.close();

    }
}
