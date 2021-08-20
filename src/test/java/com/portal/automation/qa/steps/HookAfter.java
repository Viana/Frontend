package com.portal.automation.qa.steps;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import com.core.automation.BrowserDriver;
import com.portal.automation.pages.HomePage;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class HookAfter {	
	@After
	public void after(Scenario scenario) throws ConfigurationException, IOException, InterruptedException {
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) BrowserDriver.getCurrentDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		HomePage home = PageFactory.initElements(BrowserDriver.getCurrentDriver(), HomePage.class);
		home.logout();
	}
}
