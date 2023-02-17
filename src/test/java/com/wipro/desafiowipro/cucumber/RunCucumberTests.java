package com.wipro.desafiowipro.cucumber;

import com.wipro.desafiowipro.DesafioWiproApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.wipro.desafiowipro.cucumber.steps",
        plugin = {"pretty", "json:target/cucumber-report.json"}
)
@SpringBootTest(classes = {DesafioWiproApplication.class})
@ContextConfiguration(classes = {DesafioWiproApplication.class})
public class RunCucumberTests {

    private final RestTemplateBuilder restTemplateBuilder;

    public RunCucumberTests(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
}
