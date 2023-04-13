package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {

    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
    */

    @Test
    public void jsonObje1(){

        JSONObject ilkJsonObje = new JSONObject();

        ilkJsonObje.put("title","Ahmet");
        ilkJsonObje.put("body","Merhaba");
        ilkJsonObje.put("userId",1);
        System.out.println("ilkJsonObje : " + ilkJsonObje);

    }

    @Test
    public void jsonObje2(){

        /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */
        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");

        JSONObject outherJson = new JSONObject();

        outherJson.put("firstname","Jim");
        outherJson.put("additionalneeds","Breakfast");
        outherJson.put("bookingdates",bookingdates);
        outherJson.put("totalprice",111);
        outherJson.put("depositpaid",true);
        outherJson.put("lastname","Brown");

        System.out.println(outherJson);

    }

}
