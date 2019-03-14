package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class ListenerSuite implements ISuiteListener {
    public void onStart(ISuite iSuite) {
        System.out.printf("Starting tests on group(s): %s%n", iSuite.getName());
    }
    public void onFinish(ISuite iSuite) {

    }
}