import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class jsonRestAssuredResponse {

    @Test
    public void validateStatusCode(){

        given().get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat().statusCode(200);

    }

    @Test
    public  void validateStatusCodeSecondWay(){

        Response body= RestAssured.get("https://reqres.in/api/users?page=2");
        Assert.assertEquals(body.statusCode(),200);

    }

    @Test
    public void validateResponseBody(){

        given().get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat().body("data[0].id",equalTo(7))
                .and()
                .assertThat().body("data[0].email",equalTo("michael.lawson@reqres.in"));


    }


}
