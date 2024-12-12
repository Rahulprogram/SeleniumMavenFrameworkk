package SeleniumPractise.Test.SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class locator2 {
    @Test
    public void launch() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //Identify element with 'parent to child and child-sibling'
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
        //Identify element with child to parent -parent sibling
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a")).getText());

        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[3]")).getText());
        driver.close();
    }
}
