package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti {

    /*
    http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
Request Body
          {
          "status": "success",
          "data": {
                    "name": “Ahmet",
                    "salary": "1230",
                    "age": "44",
                    "id": 40
                  }
          }
Response Body
        {
        "status": "success",
         "data": {
                 "status": "success",
                 "data": {
                         "name": “Ahmet",
                          "salary": "1230",
                          "age": "44",
                          "id": 40
                          }
                 },
         "message": "Successfully! Record has been updated."
        }

    */

    @Test
    public void put01(){

        // 1 - url ve body hazırla
        String url = "https://dummy.restapiexample.com/api/v1/update/21";

        JSONObject reqData = new JSONObject();

        reqData.put("name", "Ahmet");
        reqData.put("salary", "1230");
        reqData.put("age", "44");
        reqData.put("id",40);

        JSONObject reqBody = new JSONObject();

        reqBody.put("status", "success");
        reqBody.put("data",reqData);
        System.out.println("reqBody : " + reqBody);

        // 2 - Expected Data hazırla
        /*
        Response Body
        {
        "status": "success",
         "data": {
                 "status": "success",
                 "data": {
                         "name": “Ahmet",
                          "salary": "1230",
                          "age": "44",
                          "id": 40
                          }
                 },
         "message": "Successfully! Record has been updated."
        }
         */
        JSONObject datain = new JSONObject();

        datain.put("name", "Ahmet");
        datain.put("salary","1230");
        datain.put("age", "44");
        datain.put("id",40);

        JSONObject data = new JSONObject();

        data.put("status", "success");
        data.put("data",datain);

        JSONObject expBody = new JSONObject();
        expBody.put("status", "success");
        expBody.put("data",data);
        expBody.put("message", "Successfully! Record has been updated.");

        System.out.println("expBody : " + expBody);

        // 3 - Response'ı kaydet

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .put(url);
        response.prettyPrint();

        // 4 - Assertion

        JsonPath respJS = response.jsonPath();

        Assert.assertEquals(expBody.getJSONObject("data").getJSONObject("datain").get("name"),respJS.get("data.name"));

    }

}
