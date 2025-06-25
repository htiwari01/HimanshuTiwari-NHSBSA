package com.nhs.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobSearchPage {
	
	private WebDriver driver;
	
	private By jobSearchPageHeading = By.id("heading");
	private By searchJobTitleInput = By.cssSelector("[data-test='search-jobTitle-input']");
	private By searchLocatioInput = By.cssSelector("[data-test='search-location-input']");
	private By searchDistanceInput = By.cssSelector("[data-test='search-distance-input']");
	private By searchButton = By.cssSelector("[data-test='search-button']");
	
	
	public JobSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getJobPageHeading() {
		return driver.findElement(jobSearchPageHeading).getText();
	}
	
	public void enterJobTitle(String jobTitle) {
		driver.findElement(searchJobTitleInput).sendKeys(jobTitle);	
	}
	
	public void enterJobLocation(String jobLocation) {
		driver.findElement(searchLocatioInput).sendKeys(jobLocation);	
	}
	
	public void enterJobDistance(String jobDistance) {
		driver.findElement(searchDistanceInput).sendKeys(jobDistance);	
	}
	
	public void clickOnSearch() {
		driver.findElement(searchButton).click();
	}
	
	
	

}
