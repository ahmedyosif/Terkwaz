import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class CustomListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {
        try {
            HelperTestClass.getScreenshot(iTestResult.getTestName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestFailure(ITestResult iTestResult) {
        try {
            HelperTestClass.getScreenshot(iTestResult.getTestName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        try {
            HelperTestClass.getScreenshot(iTestResult.getTestName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
