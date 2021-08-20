

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"json:target/cucumber-json/Resultado.json","junit:target/resultados/TEST-Resultado.xml"}
		,features = {"src/test/java/com/portal/automation/qa/feature"}
		,glue={"cucumberJava"}
		)
public class RunTest {
	
}


