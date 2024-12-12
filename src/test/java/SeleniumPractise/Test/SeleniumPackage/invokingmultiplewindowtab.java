package SeleniumPractise.Test.SeleniumPackage;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class invokingmultiplewindowtab
{
    @Test
    public void windowtabinvoke() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> handles=driver.getWindowHandles();

        Iterator<String> it=handles.iterator();

        String parentWindowId = it.next();

        String childWindow =it.next();

        driver.switchTo().window(childWindow);

        driver.get("https://rahulshettyacademy.com/");
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))

                .get(1).getText();

        driver.switchTo().window(parentWindowId);

        WebElement name=driver.findElement(By.cssSelector("[name='name']"));

        name.sendKeys(courseName);

        //Screenshot

        File file=name.getScreenshotAs(OutputType.FILE);


        //FileUtils.copyFile(file, new File("logo.png"));

        //GEt Height & Width

        System.out.println(name.getRect().getDimension().getHeight());

        System.out.println(name.getRect().getDimension().getWidth());

        driver.close();

    }
}
