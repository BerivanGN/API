package test;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C19_Put_TestDataClassKullanimi extends JsonPlaceHolderBaseURL {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
      PUT request yolladigimizda donen response’in
      status kodunun 200, content type’inin “application/json; charset=utf-8”,
      Connection header degerinin “keep-alive”
      ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
      TEST DATA CLASS KULLANIMI

    Expected Data :
              {
                "title": "Ahmet",
                "body": "Merhaba",
                "userId": 10,
                "id": 70
              }
   Request Body
              {
                "title": "Ahmet",
                "body": "Merhaba",
                "userId": 10,
                "id": 70
              }
     */

    @Test
    public void put01(){

        // 1 - url ve body hazırla

        specJsonPlace.pathParams("pp1","posts","pp2",70);

        JSONObject reqBody = new JSONObject();

        reqBody.put("title", "Ahmet");
        reqBody.put("body", "Merhaba");
        reqBody.put("userId", 10);
        reqBody.put("id", 70);

        // 2 - Expected Data hazırla

        TestDataJsonPlaceHolder testDataJsonPlaceHolder = new TestDataJsonPlaceHolder();

        JSONObject expData = testDataJsonPlaceHolder.expectedBodyOlusturC19();

        // 3 - Response'ı kaydet

        Response response = given().spec(specJsonPlace).contentType(ContentType.JSON).body(reqBody.toString()).when().put("/{pp1}/{pp2}");
        response.prettyPrint();

        // 4 - Assertion

        JsonPath respJP = response.jsonPath();

        assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        assertTrue(response.contentType().equals(("application/json; charset=utf-8")));
        //assertTrue(response.headers().equals("keep-alive"));

        assertEquals(expData.get("title"),respJP.get("title"));
        assertEquals(expData.get("body"),respJP.get("body"));
        assertEquals(expData.get("userId"),respJP.get("userId"));
        assertEquals(expData.get("id"),respJP.get("id"));
    }



}
