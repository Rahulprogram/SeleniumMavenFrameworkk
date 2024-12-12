package SeleniumPractise.Test.SeleniumPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class handlinghttpcertfications
{
    @Test
    public void httpcertfications()
    {
        ChromeOptions option= new ChromeOptions();
        option.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://expired.badssl.com/");
        driver.close();

    }
}
