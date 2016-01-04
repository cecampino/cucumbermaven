package CucumberRunner;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features"
		,glue="CucumberTestSteps"
		)
public class RunCucumberTest {

}
