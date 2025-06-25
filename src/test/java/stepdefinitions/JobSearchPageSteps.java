package stepdefinitions;

import static org.junit.Assert.assertEquals;
import com.nhs.factory.DriverFactory;
import com.nhs.pages.JobSearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class JobSearchPageSteps {
	
	private JobSearchPage jobSearchPage = new JobSearchPage(DriverFactory.getDriver());
	
	@Given("I am a jobseeker on NHS Jobs website")
	public void user_is_on_job_search_page() {
		DriverFactory.getDriver().get("https://www.jobs.nhs.uk/candidate/search");
		assertEquals("Search for jobs in the NHS", jobSearchPage.getJobPageHeading());
	    
	}
	
	@When("I put my preferences into the Search functionality")
	public void i_put_my_preferences_into_the_search_functionality() {
		jobSearchPage.enterJobTitle("QA Engineer");
		jobSearchPage.enterJobLocation("Newcastle Upon Tyne");
		jobSearchPage.clickOnSearch();
	}

	@When("I enters job title {string}")
	public void i_enters_job_title(String jobTitle) {
		jobSearchPage.enterJobTitle(jobTitle);
	}

	@When("I enters town {string}")
	public void i_enters_town(String location) {
		jobSearchPage.enterJobLocation(location);
	}

	@When("I clicks on Search button")
	public void i_clicks_on_search_button() {
		jobSearchPage.clickOnSearch();
	}


}
