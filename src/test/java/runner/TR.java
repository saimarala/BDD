package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = "faetures",
        glue={"com.qa.hrm","Hooks"},
        plugin = "ddd")
public class TR extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider
        public Object[][] scenarios(){
           return super.scenarios();
        }
}
