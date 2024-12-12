package SeleniumPractise.Test.SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.Iterator;
import java.util.Set;

public class links
{
    @Test
    public void alertss() throws InterruptedException {
        WebDriver  driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement footerlink= driver.findElement(By.id("gf-BIG"));
        System.out.println("No of link in footersection" + footerlink.findElements(By.tagName("a")).size());

        WebElement footersectionlinkfirst =footerlink.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(footersectionlinkfirst.findElements(By.tagName("a")).size());
        //Click on everylink in footersectionlinkfirst
        for(int i=0;i<footersectionlinkfirst.findElements(By.tagName("a")).size();i++)
        {
            String clickonlink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            footersectionlinkfirst.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);

        }
            Set<String> windowhandle=driver.getWindowHandles();
            Iterator<String> it=windowhandle.iterator();
            while(it.hasNext());
            {
                driver.switchTo().window(it.next());
                System.out.println(driver.getTitle());
            }

        driver.close();


    }
}
