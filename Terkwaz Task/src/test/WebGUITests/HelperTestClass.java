import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HelperTestClass {
    private static String google = "https://google.com/ncr";
    private static String internet = "https://the-internet.herokuapp.com/";
    private static WebDriver driver;
    private static Robot r;
    private static int sleep;
    private static int minSleep;
    private static long timeOut;
private String imagePah = "C:\\image.jpg";

    public HelperTestClass() {
    }

    public static void Delay(int sleep) {
        r.delay(sleep);
    }

        public static String getGoogle() {
        return google;
    } /**
     *
     */

    public void setGoogle(String google) {
        this.google = google;
    }

    public static String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        HelperTestClass.driver = driver;
    }

    public static String getScreenshot(String screenshotName) throws Exception {
//ExtentTest extent=new ExtentTest();

        String dateName = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/TestScreenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        //  byte[] fileContent = FileUtils.readFileToByteArray(new File(destination));
        //   String encodedString = getEncoder().encodeToString(fileContent);
      return finalDestination.getAbsolutePath();


        // Reporter.log(path);
        //  return destination;
    }

    public static void WaitForPageLoad() {
        driver.manage().timeouts().pageLoadTimeout(getTimeOut(), TimeUnit.SECONDS);
    }

    public static Robot getR() {
        return r;
    }

    public static void setR(Robot r) {
        HelperTestClass.r = r;
    }

    public static int getSleep() {
        return sleep;
    }

    public static void setSleep(int sleep) {
        HelperTestClass.sleep = sleep;
    }

    public static int getMinSleep() {
        return minSleep;
    }

    public static void setMinSleep(int minSleep) {
        HelperTestClass.minSleep = minSleep;
    }

    public static long getTimeOut() {
        return timeOut;
    }

    public static void setTimeOut(long timeOut) {
        HelperTestClass.timeOut = timeOut;
    }


//    public static void SetUpReport() {
//        setExtent(new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", false));
//        getExtent()
//                .addSystemInfo("Host Name", "SoftwareTestingMaterial")
//                .addSystemInfo("Environment", "Automation Testing");
//        getExtent().loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
//    }

    /**
     * can be changed for your image path
     */
    public java.lang.String getImagePah() {
        return imagePah;
    }

    public void setImagePah(String imagePah) {
        this.imagePah = imagePah;
    }

    public void Setup() {


        /** where chrome driver is on PC*/
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        setDriver(new ChromeDriver());
        setSleep(3 * 1000);  /** time in seconds*/
        setMinSleep(1 * 1000);    /** time in seconds*/
        setTimeOut(5);        /**page load maximum timeout  */
        {
            try {
                setR(new Robot());
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }

//    public static ExtentTest getLogger() {
//        return logger;
//    }
//
//    public void setLogger(ExtentTest logger) {
//        this.logger = logger;
//    }
}