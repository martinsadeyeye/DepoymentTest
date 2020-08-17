package requests;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_GET_Request {

    @Test
    public void getWeatherDetials()  {

        RestAssured.baseURI = "https://demoqa.com/BookStore/v1"; // URI

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "/Books");

        //Extract body from response
        String responsebody = response.getBody().asString(); // captured the response body from jon to string format
        System.out.println(responsebody);

        int statusCode = response.getStatusCode(); //CAPTURE STATUS CODE
        String statusLine = response.getStatusLine();  // CAPTURE STATUS LINE

        //validatation

        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }


}