package EcomercePageobjects;

import AbstractComponents.AbstactResuablee;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderHistoryPage extends AbstactResuablee
{
    WebDriver driver;
    public OrderHistoryPage(WebDriver driver)
    {

        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="tr td:nth-child(3)")
    private List<WebElement> productnames;

    public Boolean verifyOrderDisplay(String productname)
    {
        Boolean match=productnames.stream().anyMatch((product->product.getText().equalsIgnoreCase(productname)));
        return match;
    }


}
