package SeleniumPractise.Test.SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class locators
{

    @Test
    public void launch()
    {
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//Implicit Wait
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // identify element by "id" locators
        driver.findElement(By.id("inputUsername")).sendKeys("Rahul");

        /*
        // identify element by "name" locators
        driver.findElement(By.name("inputPassword")).sendKeys("Rawat");
        */

        //idnetify element with css regular expression
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("Rawat");
        //identify element with xpath regular expression
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        /*
        // identify element by "class" locators
        driver.findElement(By.className("submit")).click();
        */
        // identify element by "css" locators"
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        // identify element by "linktext" locators"
        driver.findElement(By.linkText("Forgot your password?")).click();


        // identify element by "xpath" locators"
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rawat");
        // identify element by "css" locators"
        //driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Rawat@gmail.com");

        // identify element by "xpath indexes" locators"
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("Rawat@gmail.com");
       /*
        // identify element by "css indexes" locators"
        driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("9027611256");
        */
        // identify element by "xpath indexes with parent child tag" locators"
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("4464678");

        /*
        //Identify element by css selectors
        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        */

        //identify element with xpath expression

        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[2]")).click();

        // identify element by "css indexes with parent child tag" locators"
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());



        driver.close();


    }


}
