package SeleniumPractise.Test.SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class webtablessorted
{
    @Test
    public void webtablessorted()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();
       // driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> originallist=elementList.stream().map(s->s.getText()).collect(Collectors.toList());
        List<String>sortedlist=originallist.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(originallist.equals(sortedlist));
        List<String> price;
        do

        {

            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

            price = rows.stream().filter(s -> s.getText().contains("Mango"))

                    .map(s -> getPriceVeggie(s)).collect(Collectors.toList());


            price.forEach(a -> System.out.println(a));

            if(price.size()<1)

            {

                driver.findElement(By.cssSelector("[aria-label='Next']")).click();

            }

        }while(price.size()<1);


      driver.close();
    }

    private static String getPriceVeggie(WebElement s)
    {
       String pricevalue= s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return pricevalue;
    }

    @Test
    public void filters()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();
        driver.findElement(By.id("search-field")).sendKeys("Rice");

        List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));

        //1 results

        List<WebElement> filteredList= veggies.stream().filter(veggie->veggie.getText().contains("Rice")).

                collect(Collectors.toList());

        //1 result

        Assert.assertEquals(veggies.size(), filteredList.size());
    }


}
