package delete_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Delete01 extends JsonPlaceHolderBaseUrl {
    /* When
   I send DELETE Request to the Url https://jsonplaceholder.typicode.com/todos/198
   Then
   Status code is 200
   And Response body is {} */

    @Test
    public void delete01(){
        //set the url
        spec.pathParams("first", "todos", "second", 198);

        //set expected data
        Map<String, Object> expected = new HashMap<>();


        //send the Delete request get the response
        Response response = given().spec(spec)
                .delete("/{first}/{second}");
        response.then()
                .assertThat()
                .statusCode(200)
                .log().all();
        Map<String, Object> actual = response.as(HashMap.class);

        assertEquals(expected, actual);
    }
}
