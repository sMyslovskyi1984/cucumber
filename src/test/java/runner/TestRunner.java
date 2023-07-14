package runner;

//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.presentation.PresentationMode;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/maven-cucumber-report/cucumber.html",
                "json:target/cucumber-report/cucumber.json",
                "de.monochromata.cucumber.report.PrettyReports:target/cucumber"},
        features = {"src/test/resources/features/"},
        glue = {"steps"}
)
public class TestRunner{

    @AfterClass
    public static void tearDown(){
        File reportOutputDirectory = new File("target/maven-cucumber-report");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber-report/cucumber.json");
        String projectName = "cucumberProject";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber("07");
        configuration.addClassifications("Platform", "Android");
        configuration.addClassifications("Branch", "release/1.x");
//        configuration.getSortingMethod(SortingMethod.NATURAL);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        configuration.setTrendsStatsFile(new File("target/test-classes/demo-trends.json"));
        ReportBuilder reportBuilder=new ReportBuilder(jsonFiles,configuration);
        Reportable result=reportBuilder.generateReports();
    }
}
//@CucumberOptions(
//        plugin = {"json:target/test-results/test-results.json", "pretty"},
//        features = {"classpath:features"},
//        glue = {"classpath:steps"},
//        format = {"pretty", "html:test_output"}
//)
//public class TestRunner extends AbstractTestNGCucumberTests {
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
//    @BeforeClass
//    public void setThreadCount(ITestContext context) {
//        context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(1);
//    }
//}
