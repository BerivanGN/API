package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {

    /*
        https://restful-booker.herokuapp.com/booking/10 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
*/

    @Test
    public void get01(){

        // 1 - Göndereceğimiz Request için gerekli olan URL ve ihtiyacımız varsa Request Body hazırla
        // 2 - Eğer soruda bize verilmişse Expected Data hazırla
        // 3 - Bize dönen Response'ı Actual Data olarak kaydet
        // 4 - Expected Data ile Actual Datayı karşılaştırmamız yani Assertion yapmamız gerek

        // 1 - Göndereceğimiz Request için gerekli olan URL ve ihtiyacımız varsa Request Body hazırla
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2 - Eğer soruda bize verilmişse Expected Data hazırla

        // 3 - Bize dönen Response'ı Actual Data olarak kaydet
        Response response = given().when().get(url);

        response.prettyPrint();

        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Content Type : " + response.getContentType());
        System.out.println("Server Header Degeri : " + response.getHeader("Server"));
        System.out.println("Status Line : " + response.getStatusLine());
        System.out.println("Response Süresi : " + response.getTime());


    }
}
