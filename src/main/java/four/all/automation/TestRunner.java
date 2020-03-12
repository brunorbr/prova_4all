package four.all.automation;

import four.all.automation.testing.ChallengeSuite;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class TestRunner {

    public static SummaryGeneratingListener listener = new SummaryGeneratingListener();

    public static void runChallengeSuite(){
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(ChallengeSuite.class))
                .build();
        Launcher launcher = LauncherFactory.create();
        TestPlan challenge = launcher.discover(request);
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
    }

    public static void main (String args[]){
        runChallengeSuite();
    }
}
/*
public class RunJUnit5TestsFromJava {
    SummaryGeneratingListener listener = new SummaryGeneratingListener();

    public void runOne() {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(FirstUnitTest.class))
                .build();
        Launcher launcher = LauncherFactory.create();
        TestPlan testPlan = launcher.discover(request);
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
    }
    // main method...

    ublic static void main(String[] args) {
        RunJUnit5TestsFromJava runner = new RunJUnit5TestsFromJava();
        runner.runAll();

        TestExecutionSummary summary = runner.listener.getSummary();
        summary.printTo(new PrintWriter(System.out));
    }*/