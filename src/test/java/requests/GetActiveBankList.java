package requests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestUtilities;

public class GetActiveBankList {


    @Test
    void when_getBankListIsCalled_Expect_HTTPStatusCode200() {

        // Base URI
        RestAssured.baseURI = "http://192.168.19.29:6200/microservice/remita/gateway/send/api/rpgsvc/rpg/api/v2";

        //Request Object
        RequestSpecification requestSpecification = RestAssured.given();

        //Specify body type is Json/content type
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.header("API_KEY", "QzAwMDAxMzU0MzMxMjM0fEMwMDAwMTM1NDMz");
        requestSpecification.header("REQUEST_ID", TestUtilities.mrequestId());
        requestSpecification.header("REQUEST_TS", "");
        requestSpecification.header("API_DETAILS_HASH", "a096ed4933260fb256a041d65206841ce4e2af55ff8f61f376c2453e911c91b187c470d1fdae230c50f6c5252780963fa5840f1db48be67dfaee4abfaeb5b3aa");

        //Response Object
        Response response = requestSpecification.request(Method.POST, "/fi/banks");

        // Printing Response
        String responseBody = response.asString();
        System.out.println(responseBody);
    }

    @Test
    void when_getBankListIsCalled_Expect_ArrayIsNotEmpty() {

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city"; // URI

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "/Delhi");

        //Extract body from response
        String responsebody = response.getBody().asString(); // captured the response body from jon to string format
        System.out.println(responsebody);

        int statusCode = response.getStatusCode(); //CAPTURE STATUS CODE
        String statusLine = response.getStatusLine();  // CAPTURE STATUS LINE

        //validatation

        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }

    @Test
    void when_getBankListIsCalled_Expect_ArrayListOfActiveBanks() throws InterruptedException {
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";

        RequestSpecification request = RestAssured.given();

        //Specifying request Payload in JSON format
        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "xydddzabc1232oo3");
        requestParams.put("LastName", "abcdddxyz1220oo2");
        requestParams.put("UserName", "xydddzabc123o21");
        requestParams.put("Password", "abddcxyz120oo2");
        requestParams.put("Email", "xyz1dd2002111@gmail.com");

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

    @Test
    void when_getBankListIsCalled_Expect_HeaderContentType_ApplicationJson() {


    }


}
