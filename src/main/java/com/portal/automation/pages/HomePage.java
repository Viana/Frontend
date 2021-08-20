package com.portal.automation.pages;

import static com.core.automation.BrowserDriver.getCurrentDriver;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.core.automation.UtilidadesSelenium;

public class HomePage extends UtilidadesSelenium {

	public HomePage() throws ConfigurationException, IOException, InterruptedException {
		getCurrentDriver().switchTo().defaultContent();
	}

	public HomePage aceitaCookies() throws ConfigurationException, IOException, InterruptedException {
		aguardeElementoAparecerTela(By.xpath("//ul[@id='side-menu']/li"), 120);
		By aceitaCookies = By.xpath("//a[normalize-space(text())='Aceitar todos os cookies']");
		if (elementIsPresent(aceitaCookies)) {
			cliqueNoElemento(aceitaCookies);
		}
		return PageFactory.initElements(getCurrentDriver(), HomePage.class);
	}

	public HomePage acessarMenu(String[] itensDoMenu) throws ConfigurationException, InterruptedException, IOException {
		String temp = null;
		for (String menu : itensDoMenu) {
			if (temp != null && temp.equals(menu)) {
				cliqueNoElemento(By.xpath(
						"//ul[@id='side-menu']//ul[contains(@class,'nav-second')]//ul[contains(@class,'nav-third')]//a[@title='"
								+ menu + "']"));
			} else {
				cliqueNoElemento(By.linkText(menu));
			}
			temp = menu;
		}
		return PageFactory.initElements(getCurrentDriver(), HomePage.class);
	}

	public LoginPage logout() throws ConfigurationException, IOException, InterruptedException {
		cliqueNoElemento(By.linkText("Sair"));
		return PageFactory.initElements(getCurrentDriver(), LoginPage.class);
	}
}
