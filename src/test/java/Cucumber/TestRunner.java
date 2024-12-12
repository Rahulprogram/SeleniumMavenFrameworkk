package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="/src/test/java/Cucumber/PurchaseOrder.feature",glue="/src/test/java/Cucumber/StepDefination.java",
monochrome = true,tags="@Submitorder",plugin={"html:target/cucumber.html"})
public class TestRunner extends AbstractTestNGCucumberTests
{

}
