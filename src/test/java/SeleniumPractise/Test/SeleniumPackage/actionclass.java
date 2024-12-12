package SeleniumPractise.Test.SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class actionclass
{
    @Test
    public void actiondemo() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=713930225169&hvpos=&hvnetw=g&hvrand=410410226821664267&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9298310&hvtargid=kwd-64107830&hydadcr=14452_2402225&gad_source=1");
        driver.manage().window().maximize();
        Actions a = new Actions(driver);
        Thread.sleep(1);
        a.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).build().perform();
        a.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        //rightclick
        a.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).contextClick().build().perform();

    }
}
