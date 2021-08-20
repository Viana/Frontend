package com.portal.automation.pages;

import static com.core.automation.BrowserDriver.getCurrentDriver;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.automation.ConfiguracaoArquivoPropertiesUsers;
import com.core.automation.UtilidadesSelenium;


/**
 * Página de "Autenticação" do Sistema.
 * 
 * @author Rodrigo
 */

public class LoginPage extends UtilidadesSelenium{

	@FindBy(xpath = "//input[@id='username']")
	@CacheLookup
	private WebElement usernameInput;

	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	private WebElement passwordInput;

	@FindBy(xpath = "//button[@id='btnSubmit']")
	@CacheLookup
	private WebElement loginButton;



	public LoginPage() throws ConfigurationException, IOException {
		getCurrentDriver().get(ConfiguracaoArquivoPropertiesUsers.getProp().getProperty("config.url"));
	}

	public HomePage authenticate(String user, String password) throws InterruptedException, ConfigurationException, IOException {
		usernameInput.sendKeys(user);
		passwordInput.sendKeys(password);
		loginButton.click();
		WebDriverWait wait = new WebDriverWait(getCurrentDriver(), 20);
		wait.until(ExpectedConditions.stalenessOf(usernameInput));


		String Url = getCurrentDriver().getCurrentUrl();

		if(Url.contains("Session/DuplicatedSession?")) {
			getCurrentDriver().findElement(By.xpath("//input[@value='Prosseguir']")).click();
		}

		return PageFactory.initElements(getCurrentDriver(), HomePage.class);
	}
}

