package EcomercePageobjects;

import AbstractComponents.AbstactResuablee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstactResuablee
{
    WebDriver driver;
    public LandingPage(WebDriver driver)
    {

        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="userEmail")
    WebElement useremail;

    @FindBy(id="userPassword")
    WebElement userpassword;

    @FindBy(id="login")
    WebElement login;



    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;


    public ProductCatalogue loginApplication(String username, String Password)
    {
        useremail.sendKeys(username);
        userpassword.sendKeys(Password);
        login.click();
        ProductCatalogue pc= new ProductCatalogue(driver);
        return pc;
    }

    public void GoTo()
    {
        driver.get("https://rahulshettyacademy.com/client");
    }

    public String getErrorMessage()
    {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }
}
