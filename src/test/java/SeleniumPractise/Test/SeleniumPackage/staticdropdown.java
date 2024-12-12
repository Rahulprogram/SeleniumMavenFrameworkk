package SeleniumPractise.Test.SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class staticdropdown
{
    @Test
    public void selectdropdown() throws InterruptedException {
        WebDriver  dr = new ChromeDriver();
        dr.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement element= dr.findElement(By.cssSelector("select[name='ctl00$mainContent$DropDownListCurrency']"));
        Select select = new Select(element);
        select.selectByValue("INR");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByIndex(2);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByVisibleText("USD");
        System.out.println(select.getFirstSelectedOption().getText());

        // Selecting passenger
        dr.findElement(By.cssSelector("#divpaxinfo")).click();
        Thread.sleep(1000);
        for(int i=1;i<4;i++)
        {
            dr.findElement(By.id("hrefIncAdt")).click();
        }
        dr.findElement(By.id("hrefDecAdt")).click();
        System.out.println(dr.findElement(By.cssSelector("#divpaxinfo")).getText());

        dr.close();
    }
}
