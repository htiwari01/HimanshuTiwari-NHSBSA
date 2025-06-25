package com.nhs.pages;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.nhs.utils.commonUtils;

public class JobSearchResultPage {
	
	private WebDriver driver;
	
	private By searchResultList = By.cssSelector("[data-test='search-result']");
	private By searchJobTitleInput = By.cssSelector("[data-test='search-jobTitle-input']");
	private By searchResultText = By.cssSelector("[data-test='search-result-query']");
	private By searchResultLocation = By.cssSelector("[data-test='search-result-location']");
	private By sortInput = By.cssSelector("[data-test='sort-input']");
	private By searchResultPulicationDate = By.cssSelector("[data-test='search-result-publicationDate']");
	private By searchResultHeadingText = By.cssSelector(".nhsuk-heading-l[data-test='search-result-query']");
	private By searchResultDistance = By.cssSelector("li[data-test='search-result-distance'] > strong");
	private By workingPatternFullTimeFilter = By.cssSelector("[data-test='working-pattern-full-time']");
	private By contractTypePermamentFilter = By.cssSelector("[data-test='contract-type-permanent']");
	private By searchButton = By.cssSelector("[data-test='search-button']");
	private By fullTimeFilterText = By.cssSelector("label[for='working-pattern-full-time']");
	private By permanentContractTypeFilterText = By.cssSelector("label[for='contract-type-permanent']");
	private By locationAttribute = By.cssSelector("#refineFilter input[name='location']");
	private By filterWorkingPattern = By.cssSelector("[data-test='filter-working-pattern']");
	private By filterContractType = By.cssSelector("[data-test='filter-contract-type']");
	private By applyFilterButton = By.cssSelector("[data-test='refine-search-button']");
	private By searchResultWorkingPattern = By.cssSelector("li[data-test='search-result-workingPattern'] strong");
	private By searchResultContractType = By.cssSelector("li[data-test='search-result-jobType'] strong");
	
	public JobSearchResultPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getSearchResultText() {
		return driver.findElement(searchResultText).getText();
	}
	
	public int getSearchResultListSize() {
		return driver.findElements(searchResultLocation).size();
		
	}
	
	public String getSearchJobTitleInput() {
		return driver.findElement(searchJobTitleInput).getAttribute("value");
	}
	
	public void getSearchResultList() {
		driver.findElements(searchResultList);
		
	}
	
	public String getHeadingSearchResultText() {
		return driver.findElement(searchResultHeadingText).getText();
	}
	
	public void getSortByNewestDatePosted() {
		driver.findElement(sortInput).click();
		WebElement dropdownElement = driver.findElement(sortInput);
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByValue("publicationDateDesc");	
		
	}
	
	
	public List<String> getSearchResultPulicationDate() throws ParseException {
		List<String> formattedDateList = new ArrayList<>();
		List<WebElement> publishDates = driver.findElements(searchResultPulicationDate);
		for(WebElement publishDate : publishDates) {
			String formattedDate = publishDate.getText().split(":")[1].trim();
			formattedDateList.add(formattedDate);
			
		}
		return formattedDateList;
		
	}
	
	public List<String> getSearchResultDistance() throws ParseException {
		List<String> formattedDistanceList = new ArrayList<>();
		List<WebElement> publishDistances = driver.findElements(searchResultDistance);
		for(WebElement publishDistance : publishDistances) {
			String formattedDistance = publishDistance.getText().split("\\s+")[0].trim();
			formattedDistanceList.add(formattedDistance);	
		}
		return formattedDistanceList;
		
	}
	
	public List<String> getSearchResultWithFullTimeFilter() throws ParseException{
		commonUtils.waitForElementVisible(driver, searchResultWorkingPattern, 20);
		List<String> fullTimeFilterList = new ArrayList<>();
		List<WebElement> fullTimeFilters = driver.findElements(searchResultWorkingPattern);
		for(WebElement fullTimeFilter : fullTimeFilters) {
			String formateFullTimeFilter = fullTimeFilter.getText().trim();
			fullTimeFilterList.add(formateFullTimeFilter);	
		}
		return fullTimeFilterList;
		
	}
	
	public List<String> getSearchResultWithMyPreferencePermanentFilter() throws ParseException {
		commonUtils.waitForElementVisible(driver, searchResultContractType, 20);
		List<String> permanentFilterList = new ArrayList<>();
		List<WebElement> permanentFilters = driver.findElements(searchResultContractType);
		for(WebElement permanentFilter : permanentFilters) {
			String formatepermanentFilter = permanentFilter.getText().trim();
			permanentFilterList.add(formatepermanentFilter);	
		}
		return permanentFilterList;
		
	}
	
	public void selectWorkingPatternFullTimeFilter() {
		driver.findElement(workingPatternFullTimeFilter).click();;
	}
	
	public void selectContractTypePermamentFilter() {
		driver.findElement(contractTypePermamentFilter).click();;
	}
	
	public void clickOnSearch() {
		driver.findElement(searchButton).click();
	}
	
	public String getFullTimeFilterText() {
		return driver.findElement(fullTimeFilterText).getText().trim();
	}
	
	public String getPermanentContractTypeFilterText() {
		return driver.findElement(permanentContractTypeFilterText).getText().trim();
	}
	
	public String getLocationAttributeText() {
		return driver.findElement(locationAttribute).getAttribute("value");
	}
	
	public void clickWorkingPatternFilter() {
		driver.findElement(filterWorkingPattern).click();;
	}
	
	public void clickFilterContractType() {
		driver.findElement(filterContractType).click();;
	}
	
	public void clickApplyFilterButton() {
		driver.findElement(applyFilterButton).click();;
	}
	
	
	

}
