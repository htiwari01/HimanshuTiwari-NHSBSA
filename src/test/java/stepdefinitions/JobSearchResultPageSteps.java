package stepdefinitions;

import java.text.ParseException;
import org.testng.Assert;
import com.nhs.factory.DriverFactory;
import com.nhs.pages.JobSearchResultPage;
import com.nhs.utils.commonUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class JobSearchResultPageSteps {
	
	private JobSearchResultPage jobSearchResultPage = new JobSearchResultPage(DriverFactory.getDriver());
	
	@Then("I should get a list of jobs which matches my preferences")
	public void i_should_get_a_list_of_jobs_which_matches_my_preferences() throws ParseException {
		String resultText = " jobs found for " +  jobSearchResultPage.getSearchJobTitleInput() +  " within 5 miles of " +  jobSearchResultPage.getLocationAttributeText();
		Assert.assertTrue(jobSearchResultPage.getSearchResultText().contains(resultText));
		Assert.assertTrue(commonUtils.areAllNumbersLessThan(jobSearchResultPage.getSearchResultDistance(), 5));
	}
	
	@Then("I should get a list of jobs with town preferences")
	public void i_should_get_a_list_of_jobs_with_town_preferences() throws ParseException {
		String resultText = " jobs found within 5 miles of " +  jobSearchResultPage.getLocationAttributeText();
		Assert.assertTrue(jobSearchResultPage.getSearchResultText().contains(resultText));
		Assert.assertTrue(commonUtils.areAllNumbersLessThan(jobSearchResultPage.getSearchResultDistance(), 5));
	}
	
	@Then("I should get a list of jobs with Job Title preferences")
	public void i_should_get_a_list_of_jobs_with_job_title_preferences() throws ParseException {
		String resultText = " jobs found for " +  jobSearchResultPage.getLocationAttributeText();
		Assert.assertTrue(jobSearchResultPage.getSearchResultText().contains(resultText));
		Assert.assertTrue(commonUtils.areAllNumbersLessThan(jobSearchResultPage.getSearchResultDistance(), 5));
	}
	
	@And("I sort my search results with the newest Date Posted")
	public void i_sort_my_search_results_with_the_newest_Date_Posted() throws ParseException {
		jobSearchResultPage.getSortByNewestDatePosted();
		Assert.assertTrue(commonUtils.isSortedByNewest(jobSearchResultPage.getSearchResultPulicationDate()));
		
	}
	
	@Then("I should get a list of jobs")
	public void i_should_get_a_list_of_jobs(){
		Assert.assertTrue(jobSearchResultPage.getSearchResultText().contains("jobs found"));
		
	}
	
	@Then("I should get No result found message")
	public void i_should_get_no_result_found_message(){
		String resultText = "No result found for " + jobSearchResultPage.getSearchJobTitleInput() + " within 5 miles of Newcastle Upon Tyne";
		Assert.assertTrue(jobSearchResultPage.getSearchResultText().contains(resultText));
		
	}
	
	@Then("I should get Location not found message")
	public void i_should_get_location_not_found_message(){
		Assert.assertTrue(jobSearchResultPage.getHeadingSearchResultText().equals("Location not found"));
		
	}
	
	@And("I apply Full Time Working Pattern filter")
	public void I_apply_full_time_working_pattern_filter(){
		jobSearchResultPage.clickWorkingPatternFilter();
		jobSearchResultPage.selectWorkingPatternFullTimeFilter();
		
	}
	
	@And("I apply Contract Type as Permanent filter")
	public void i_apply_contract_type_as_Permanent_filter(){
		jobSearchResultPage.clickFilterContractType();
		jobSearchResultPage.selectContractTypePermamentFilter();
		
	}
	
	@And("I clicks on Apply Filter button")
	public void i_clicks_on_apply_filter_button() throws InterruptedException{
		jobSearchResultPage.clickApplyFilterButton();
		
	}
	
	@Then("I get a list of jobs which matches my preferences with full time filter")
	public void i_get_a_list_of_jobs_which_matches_my_preferences_with_full_time_filter() throws ParseException{
		String resultText = " jobs found for " +  jobSearchResultPage.getSearchJobTitleInput() +  " within 5 miles of " +  jobSearchResultPage.getLocationAttributeText();
		Assert.assertTrue(jobSearchResultPage.getSearchResultText().contains(resultText));
		Assert.assertTrue(commonUtils.areAllStringsMatching(jobSearchResultPage.getSearchResultWithFullTimeFilter(), jobSearchResultPage.getFullTimeFilterText()));	
	
	}
	
	@Then("I get a list of jobs which matches my preferences with Permanent filter")
	public void i_get_a_list_of_jobs_which_matches_my_preferences_with_permanent_filter() throws ParseException{
		String resultText = " jobs found for " +  jobSearchResultPage.getSearchJobTitleInput() +  " within 5 miles of " +  jobSearchResultPage.getLocationAttributeText();
		Assert.assertTrue(jobSearchResultPage.getSearchResultText().contains(resultText));
		Assert.assertTrue(commonUtils.areAllStringsMatching(jobSearchResultPage.getSearchResultWithMyPreferencePermanentFilter(), jobSearchResultPage.getPermanentContractTypeFilterText()));
	}
	
	

}
