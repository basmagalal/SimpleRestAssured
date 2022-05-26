import DataReader.ExelReader;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static javax.swing.UIManager.get;


public class xmlDataDriven {



    @DataProvider(name = "excelsheet")
    public Object[][] readExcel() throws IOException, InvalidFormatException {

        ExelReader exelReader=new ExelReader();
        return  exelReader.readXsls();
    }

    @Test(dataProvider = "excelsheet")
    public void excelTest(String id,String firstname,String street,String city,String state, String zipcode){
        Response responsexml = RestAssured.get("https://parabank.parasoft.com/parabank/services/bank/customers/12212/");
        String body = responsexml.getBody().asString();
       // String headerValue = response.getHeader("headerName");

       // String xml=get("https://parabank.parasoft.com/parabank/services/bank/customers/12212/").;
        XmlPath xmlPath=new XmlPath(body).setRootPath("customer");
        String resId=xmlPath.getString("id");
        String resFname=xmlPath.getString("firstName");
        String resStreet=xmlPath.getString("address.street");
        String resCity=xmlPath.getString("address.city");
        String resState=xmlPath.getString("address.state");
        String resZipcode=xmlPath.getString("address.zipCode");

        Assert.assertEquals(resId,id);




    }



}
