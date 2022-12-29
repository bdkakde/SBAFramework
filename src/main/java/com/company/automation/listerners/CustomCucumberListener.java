package com.company.automation.listerners;

import com.company.automation.reporter.AllureReportManager;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestStepStarted;
import org.springframework.beans.factory.annotation.Autowired;


public class CustomCucumberListener implements ConcurrentEventListener {


    @Autowired
    private AllureReportManager allureReportManager;


    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepStarted.class, this::testStepStartedHandler);

        publisher.registerHandlerFor(TestRunFinished.class, this::testRunFinishedHandler);
    }

    private  void testStepStartedHandler(TestStepStarted event) {
        if (event.getTestStep() instanceof PickleStepTestStep testStep) {
            String stepName = testStep.getStep().getText();
            System.out.println("STEP STARTED:  " + stepName);
        }
    }

    private void testRunFinishedHandler(TestRunFinished event) {

        allureReportManager.setAllureEnvironmentInformation();

    }
}
