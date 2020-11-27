import com.sun.org.glassfish.gmbal.Description;
import io.restassured.RestAssured;
import io.restassured.internal.ValidatableResponseImpl;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest {

    @BeforeClass
    public static void Setup() {
        RestAssured.baseURI = "https://cat-fact.herokuapp.com";
        RestAssured.basePath = "/facts/random";
    }

    @Test
    @Description("get random fact")
    public void GetRandomFact() {
        /**gets one random cat fact*/

        ValidatableResponseImpl response = (ValidatableResponseImpl) given().queryParam("animal_type", "cat")
                .queryParam("amount", 1)
                .get().then().log().body();
        Assert.assertNotEquals(response.rootPath("text").toString(), "");

        Reporter.log(response.body().toString());


    }
}
