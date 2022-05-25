import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class restTCs {

    @Test
    public void validateResponseCode(){
        given()
                .get("https://parabank.parasoft.com/parabank/services/bank/customers/12212/")
                .then().assertThat().statusCode(200);



    }


    @Test
    public void validateResponseCodeSecondWay(){
        Response responseBody= RestAssured.get("https://parabank.parasoft.com/parabank/services/bank/customers/12212/");
                Assert.assertEquals(responseBody.statusCode(),200);



    }


    @Test
    public void validateResponseBody(){
        given()
                .get("https://parabank.parasoft.com/parabank/services/bank/customers/12212/")
                .then().assertThat().body("customer.id",equalTo( "12212"))
                .and()
                .assertThat().body("customer.firstName",equalTo("John"))
                .and()
                .assertThat().body("customer.address.street",equalTo("1431 Main St"))
                .and()
                .assertThat().body("customer.address.city",equalTo("Beverly Hills"))
                .and()
                .assertThat().body("customer.address.state",equalTo("CA"))
                .and()
                .assertThat().body("customer.address.zipCode",equalTo("90210"));



    }

}
