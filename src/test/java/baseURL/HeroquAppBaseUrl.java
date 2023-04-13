package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HeroquAppBaseUrl {

    // https://restful-booker.herokuapp.com

    protected RequestSpecification specHeroquApp;

    @Before
    public void setUp(){

        specHeroquApp = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

    }

}
