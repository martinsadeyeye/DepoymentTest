package requests;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2_POST_Request {

    @Test
    public void registerCustomer() throws InterruptedException {
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";

        RequestSpecification request = RestAssured.given();

        //Specifying request Payload in JSON format
        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "xydddzabc12233");
        requestParams.put("LastName", "abcdddxyz13222");
        requestParams.put("UserName", "xydddzabc12221");
        requestParams.put("Password", "abddcxyz12322");
        requestParams.put("Email", "xyz1dd23567ab111@gmail.com");

        //Specify body type is Json/content type
        request.header("Content-Type", "application/json");

        // Add the Json to the body of the request
        request.body(requestParams.toJSONString());   // Must be there

        //POST request

        Response response = request.request(Method.POST, "/register");
        //Response response=request.post("/register");
        System.out.println(response);

        Thread.sleep(3000);

        //Validate the Response status code
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 201);


        //Validate the Response success code
        String successCode = response.jsonPath().get("SuccessCode");
        System.out.println(successCode);
        Assert.assertEquals(successCode, "OPERATION_SUCCESS");

    }

}
