package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/feature",glue= {"StepDefn","hooks"},monochrome=true)
public class RunCucumberTests extends AbstractTestNGCucumberTests {

}
