package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JSONObjectVerileriCagirma {

    /* ==============iç içe json objesi oluşturma===========
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
    },
    "phoneNumbers": [
        {
            "type": "iPhone",
            "number": "0123-4567-8888"
        },
        {
            "type": "home",
            "number": "0123-4567-8910"
        }
    ]
}
     */

    @Test
    public void jsonPath01(){

        JSONObject ceptel = new JSONObject();

        ceptel.put("type","iPhone");
        ceptel.put("number","0123-4567-8888");

        JSONObject evTel = new JSONObject();

        evTel.put("type","home");
        evTel.put("number","0123-4567-8910");

        JSONArray phoneNumbers = new JSONArray();

        phoneNumbers.put(1,evTel);
        phoneNumbers.put(0,ceptel);

        JSONObject address = new JSONObject();

        address.put("streetAddress","naist street");
        address.put("city","Nara");
        address.put("postalCode","630-0192");

        JSONObject kisiBilgisi = new JSONObject();

        kisiBilgisi.put("firstName","John");
        kisiBilgisi.put("lastName","doe");
        kisiBilgisi.put("age",26);
        kisiBilgisi.put("address",address);
        kisiBilgisi.put("phoneNumbers",phoneNumbers);

        System.out.println("kisiBilgisi : " + kisiBilgisi);

        System.out.println("İsim : " + kisiBilgisi.get("firstName")); // john
        System.out.println("soyİsim : " + kisiBilgisi.get("lastName")); // doe
        System.out.println("Yaş : " + kisiBilgisi.get("age")); // 26
        System.out.println("Sokak Adı : " + kisiBilgisi.getJSONObject("address").get("streetAddress")); // naist street
        System.out.println("Şehir Adı : " + kisiBilgisi.getJSONObject("address").get("city")); // Nara
        System.out.println("Posta kodu : " + kisiBilgisi.getJSONObject("address").get("postalCode")); // 630-0192

        System.out.println(" ev Telefon numarası : " + kisiBilgisi
                                              .getJSONArray("phoneNumbers")
                                              .getJSONObject(1)
                                              .get("number")); // 0123-4567-8910
        System.out.println(" Ev Telefon türü : " + kisiBilgisi
                .getJSONArray("phoneNumbers")
                .getJSONObject(1)
                .get("type")); // home

        System.out.println(" Cep Telefon türü : " + kisiBilgisi
                .getJSONArray("phoneNumbers")
                .getJSONObject(0)
                .get("type")); // iPhone

        System.out.println(" Cep Telefon numarası : " + kisiBilgisi
                .getJSONArray("phoneNumbers")
                .getJSONObject(0)
                .get("number")); // 0123-4567-8888





    }

}
