package CucumberTestSteps;

import java.io.IOException;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;


public class AmazonSearch {

	@Given("^I access amazon page$")
	public void i_access_amazon_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I search for QA books$")
	public void i_search_for_QA_books() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I get more than (\\d+) results$")
	public void i_get_more_than_results(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Given("^Do the full test$")
	public void do_the_full_test() throws Throwable {
		Pages.AmazonSearch.main("full");
	}

    @After
    public void cleanup(cucumber.api.Scenario scenario) throws IOException {
        try {
            if (scenario.isFailed()) {
                System.out.print(">>>SCENARIO FAILURE<<<: '"+scenario.getName()+"'"); 
                Pages.AmazonSearch.SaveScreenShot(scenario.getName());
            }
        }
        catch (RuntimeException e){
            throw new RuntimeException(e);
        }
        finally {
            //driverquit();
        }
    }
	
    
    
}
