package get_http_request_method;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
public class Get05 extends HerokuappBaseUrl {
    /*
          Given
              https://restful-booker.herokuapp.com/booking
          When
              User send a request to the URL
          Then
              Status code is 200
          And
             Among the data there should be someone whose firstname is "Mary" and last name is "Wilson"
*/
    @Test
    public void get05(){
        //Set the url
        spec.pathParam("first" , "booking").queryParams("firstname","Eric",
                "lastname", "Ericsson");
        //Set the expected data
        //Send the request and Get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
    }
}
