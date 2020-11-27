//import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.List;

public class WebGUITests {
    static HelperTestClass helperTestClass = new HelperTestClass();

    @BeforeClass
    public static void OneTimeSetup() {
        helperTestClass.Setup();
    }

    @Test(priority = 1)

    public void GoogleTest() {
        /**this tests opens googles and asserts that the third result
         contains What's selenium web driver.

         This depends on google search result so "What's selenium web driver"
         might appear in different order than demanded
         */

        HelperTestClass.getDriver().navigate().to(HelperTestClass.getGoogle());


        String strToSearch = "selenium webdriver";
        String strToFind = "What is Selenium WebDriver?";
        HelperTestClass.getDriver().findElement(By.name("q")).sendKeys(strToSearch + Keys.ENTER);
        HelperTestClass.Delay(HelperTestClass.getSleep());
        List<WebElement> results = HelperTestClass.getDriver().findElements(By.tagName("a"));
        WebElement thirdElement = results.get(2);

        Assert.assertTrue(thirdElement.getText().contains(strToFind));


    }

    @Test(priority = 2)
    public void UploadFileTest() {    /**this test navigates to https://the-internet.herokuapp.com/
     uploads an image and makes sure it's uploaded  */
    HelperTestClass.Delay(HelperTestClass.getSleep());
        HelperTestClass.getDriver().navigate().to(helperTestClass.getInternet());
        HelperTestClass.Delay(HelperTestClass.getSleep());
        HelperTestClass.getDriver().findElement(By.linkText("File Upload")).click();
        HelperTestClass.Delay(HelperTestClass.getMinSleep());
        HelperTestClass.getDriver().findElement(By.cssSelector("input#file-upload")).sendKeys(helperTestClass.getImagePah());
        HelperTestClass.Delay(HelperTestClass.getMinSleep());

        HelperTestClass.Delay(HelperTestClass.getMinSleep());
        HelperTestClass.getDriver().findElement(By.className("button")).click();
        HelperTestClass.Delay(HelperTestClass.getSleep());
        WebElement element = HelperTestClass.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(element.isDisplayed());
    }

    @Test(priority = 3)
    public void DynamicLoadTest() { /**this test goes to https://www.youtube.com/watch?v=QKUBpUSn-Kw
     /then dynamic loading and then example 2
     /and then tests the loading process and wait till it's finished
     */
        HelperTestClass.Delay(HelperTestClass.getSleep());

        HelperTestClass.getDriver().navigate().to(helperTestClass.getInternet());
        HelperTestClass.Delay(HelperTestClass.getSleep());

        HelperTestClass.getDriver().findElement(By.partialLinkText("Dynamic Loading")).click();
        HelperTestClass.Delay(HelperTestClass.getSleep());
        HelperTestClass.getDriver().findElement(By.partialLinkText("Example 2")).click();
        HelperTestClass.Delay(HelperTestClass.getSleep());
        HelperTestClass.getDriver().findElement(By.xpath("/html/body/div[2]/div/div/div/button")).click();
        HelperTestClass.Delay(HelperTestClass.getSleep());
        WebElement element = null;
        try {
            element = HelperTestClass.getDriver().findElement(By.id("loading"));
            while (element.isDisplayed()) {
                /** wait for loading to finish*/
            }
        } catch (Exception e) {

        }
        HelperTestClass.Delay(HelperTestClass.getSleep());

        WebElement finish = null;
        try {
            finish = HelperTestClass.getDriver().findElement(By.id("finish"));
            while (!finish.isDisplayed()) {
                /** wait for finish to appear*/
            }
            HelperTestClass.Delay(HelperTestClass.getSleep());
            HelperTestClass.WaitForPageLoad();
            element = finish.findElement(By.tagName("h4"));
            Assert.assertEquals(element.getText(), "Hello World!");
        } catch (Exception e) {

        }


    }

    @BeforeMethod
    public void BeforeTest() {
        /** before each test wait for page to load*/
        HelperTestClass.WaitForPageLoad();


    }

    @AfterMethod
    public void Screenshot(Method method) {
        try {

         String path=   HelperTestClass.getScreenshot(method.getName());
            Reporter.log(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void TearDown() {
        /*** after all tests the browser will be closed
         * and web driver will quit
         */


        HelperTestClass.getDriver().quit();
    }
}
