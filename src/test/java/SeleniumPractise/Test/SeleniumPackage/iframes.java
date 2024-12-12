package SeleniumPractise.Test.SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class iframes {
    @Test
    public void iframes()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/draggable/");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Droppable")).click();
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        //driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
        driver.switchTo().frame(0);
        //driver.findElement(By.id("draggable")).click();
        Actions a = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement destination= driver.findElement(By.id("droppable"));
        a.dragAndDrop(source,destination).build().perform();
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("Accept")).click();


    }
}
