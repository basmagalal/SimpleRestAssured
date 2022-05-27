import DataReader.jsonExcelReader;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class jsonDataDriven {

    @DataProvider(name = "jsonExcel")
    public  Object[][] jsonReadExcel() throws IOException, InvalidFormatException {

        jsonExcelReader jsReader=new jsonExcelReader();
        return jsReader.jsonResponsereadFromExcel();
    }


    @Test(dataProvider = "jsonExcel")
    public void validateJSBody(String id,String email,String fname,String lname,String av){

        Response body= RestAssured.get("https://reqres.in/api/users?page=2");
       String bd=  body.asString();
       Assert.assertTrue(bd.contains(id));
       Assert.assertTrue(bd.contains(email));
       Assert.assertTrue(bd.contains(fname));
       Assert.assertTrue(bd.contains(lname));
       Assert.assertTrue(bd.contains(av));







    }


}
