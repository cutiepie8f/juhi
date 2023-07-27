package RunnerTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/FeatureFile/Feature1.feature",glue= {"stepDefinition"})
public class TestRunner {

}
System.out.println("hi all");