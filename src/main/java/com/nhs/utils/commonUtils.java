package com.nhs.utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;


public class commonUtils {
	
	public static boolean isSortedByNewest(List<String> dateStrings) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);
        List<LocalDate> actualDates = new ArrayList<>();

        for (String dateStr : dateStrings) {
            try {
                actualDates.add(LocalDate.parse(dateStr, formatter));
            } catch (DateTimeParseException e) {
                System.out.println("Failed to parse date: " + dateStr);
                return false;
            }
        }

        List<LocalDate> sortedDates = new ArrayList<>(actualDates);
        sortedDates.sort(Comparator.reverseOrder());

        return actualDates.equals(sortedDates);
    }
	
	public static boolean areAllNumbersLessThan(List<String> numberStrings, double reference) {
        for (String numStr : numberStrings) {
            try {
                double value = Double.parseDouble(numStr.trim());
                if (value >= reference) {
                    return false; 
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
	
	
	public static boolean areAllStringsMatching(List<String> listOfStrings, String expectedResult) {
        for (String str : listOfStrings) {
            if (!str.equals(expectedResult)) {
                return false;
            }
        }
        return true;
    }
	
	//explicit wait for deal with Stale element exception
	public static WebElement waitForElementVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
