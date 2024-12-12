package EcomercePageobjects;

import AbstractComponents.AbstactResuablee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstactResuablee
{
    WebDriver driver;
    public CheckoutPage(WebDriver driver)
    {

        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

@FindBy(css="[placeholder='Select Country']")
WebElement country;

@FindBy(css=".action__submit")
WebElement submit;

@FindBy(xpath = "//button[contains(@class,'ta-item')])[2]")
 WebElement  selectcountry;

By result=By.cssSelector(".ta-results");



public void setSelectcountry(String countryname)
{
    Actions a = new Actions(driver);
    a.sendKeys(country,countryname).build().perform();
    waitForElementToAppear(result);
    selectcountry.click();
}

public ConfirmationPage SubmitOrder()
{
submit.click();
ConfirmationPage confirmpage= new ConfirmationPage(driver);
return confirmpage;

}

}



