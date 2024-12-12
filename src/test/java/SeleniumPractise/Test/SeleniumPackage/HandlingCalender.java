package SeleniumPractise.Test.SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingCalender
{
    @Test
    public void calender() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).click();
        driver.findElement(By.xpath("//a[text()='6']")).click();
        
        driver.close();

    }}
