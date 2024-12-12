package TestComponents;


import EcomercePageobjects.LandingPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest
{
   public  WebDriver driver;
   public LandingPage lp;
    public WebDriver initializeBrowser() throws IOException {
        Properties props= new Properties();
        FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\GlobalProperties.properties");
        props.load(fis);
        //Broswer Command from Terminal
        //String browsername= System.getProperty("browser")!=null? System.getProperty("browser"):props.getProperty("browser");

       String browsername=props.getProperty("browser");

        if(browsername.contains("chrome"))
        {
            //Run in headless mode
            /*
            ChromeOptions options = new ChromeOptions();
            if (browsername.contains("headless"))
            {
                options.addArguments("headless");
            }
             driver = new ChromeDriver(options);
           */
             driver= new ChromeDriver();

        }
        else
        {
            System.out.println("Browser is FireFox");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
   public LandingPage launchApplication() throws IOException {
       driver=initializeBrowser();
       lp= new LandingPage(driver);
       lp.GoTo();
       return lp;
   }

   @AfterMethod(alwaysRun = true)
    public void CloseBrowser()
    {
        driver.close();
    }

    public List<HashMap<String, String>> getJsonDataToHasmap(String filepath) throws IOException {
        //Reading json to string
        String jsoncontent= FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
        //String to Hashmap
        ObjectMapper mapper= new ObjectMapper();
        List<HashMap<String,String>> data=mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>()
        {
        });
        return data;

    }

    public String getScreenshot(String testcasename,WebDriver driver)
    {
        TakesScreenshot ts= (TakesScreenshot)driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        File filepath= new File(System.getProperty("user.dir")+"\\src\\Screenshot\\"+testcasename+".png");
        return System.getProperty("user.dir")+"\\src\\Screenshot\\"+testcasename+".png";
    }


}
