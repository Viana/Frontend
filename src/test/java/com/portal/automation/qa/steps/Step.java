package com.portal.automation.qa.steps;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.PageFactory;

import com.core.automation.BrowserDriver;
import com.core.automation.ConfiguracaoArquivoPropertiesUsers;
import com.core.automation.UtilidadesSelenium;
import com.portal.automation.AlterarCodigoProdutoXML;
import com.portal.automation.pages.HomePage;
import com.portal.automation.pages.LoginPage;
import com.portal.automation.pages.intax.CouchDBPage;
import com.portal.automation.pages.intax.GestaoDocumentosPage;
import com.portal.automation.pages.intax.ImportacoesPage;
import com.portal.automation.pages.intax.PlanoDeRegrasPage;
import com.portal.automation.pages.intax.RegrasPage;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step {

	SessionId session;
	static String usuarioNoArquivo;
	static String arquivoControle = System.getProperty("user.dir") + "/target/classes/controleUsuario.txt";
	String nomeRegraFixo = null;
	static String caminho = System.getProperty("user.home") + "/Downloads/";
	static File fileCaminho = new File(caminho);
	String codigoRegra = null;
	Scenario scenario;

	@Before
	public void getScenarios(Scenario scenario) {
		this.scenario = scenario;
	}

	@Given("^que acessei sistema e informei o login e senha validos$")
	public void que_acessei_sistema_e_informei_o_nome_do_usuário() throws Throwable {
		LoginPage loginPage = PageFactory.initElements(BrowserDriver.getCurrentDriver(), LoginPage.class);
		usuarioNoArquivo = ConfiguracaoArquivoPropertiesUsers.verificaUsuarioNaoLogado(arquivoControle,
				((RemoteWebDriver) BrowserDriver.getCurrentDriver()).getSessionId());
		String user = ConfiguracaoArquivoPropertiesUsers.getProp().getProperty(usuarioNoArquivo);
		// String user = Configuracao.getProp().getProperty("config.user");
		String password = ConfiguracaoArquivoPropertiesUsers.getProp()
				.getProperty("config.pass" + usuarioNoArquivo.charAt(usuarioNoArquivo.length() - 1));
		loginPage.authenticate(user, password);
	}

	@Given("^que na tela principal eu acesso o menu \"([^\"]*)\"$")
	public void que_acessei_o_menu(String menu) throws Throwable {
		HomePage home = PageFactory.initElements(BrowserDriver.getCurrentDriver(), HomePage.class);
		String[] itensDoMenu = menu.split(" > ");
		home.aceitaCookies();
		home.acessarMenu(itensDoMenu);
	}



}
