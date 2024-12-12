package SeleniumPractise.Test.SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class locator1 {

    @Test
    public void launch() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//Implicit Wait
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        String name="Rahul";
        // identify element by "id" locators
        driver.findElement(By.id("inputUsername")).sendKeys(name);

        //idnetify element with css regular expression
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxTwo")).click();

        //identify element with xpath regular expression
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        Thread.sleep(1000);
        System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
        System.out.println(driver.findElement(By.cssSelector("div p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
        //Identify element with xpath text()
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        driver.close();

    }
}
