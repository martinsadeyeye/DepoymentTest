package requests;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TC3_GET_Request {

    @Test
    public void googleMapTest()  {

        RestAssured.baseURI = "https://maps.googleapis.com"; // URI

        RequestSpecification httpRequest = RestAssured.given();


        Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

        //Extract body from response
        String responsebody = response.getBody().asString(); // captured the response body from jon to string format
        System.out.println("Response Body is:  " +responsebody);

        






       /* int statusCode = response.getStatusCode(); //CAPTURE STATUS CODE
        String statusLine = response.getStatusLine();  // CAPTURE STATUS LINE

        //validatation

        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
*/
    }


}