package post_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import data.JsonPlaceHolderData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Post03 extends JsonPlaceHolderBaseUrl {
     /*
        When
	  		I send POST Request to the Url https://jsonplaceholder.typicode.com/todos
	  		with the request body {
								    "userId": 55,
								    "title": "Tidy your room",
								    "completed": false
								   }
		Then
			Status code is 201
			And response body is like {
									    "userId": 55,
									    "title": "Tidy your room",
									    "completed": false,
									    "id": 201
									  }
     */
    @Test
    public void post03(){
        spec.pathParam("first", "todos");

        //Set the expected data
        Map<String, Object> expectedData = JsonPlaceHolderData.expectedDataSetup();
        //Map<String, Object> expectedData = JsonPlaceHolderData.expectedDataSetup(44, "Clean up", true);

        //Send the post request and get the response
        Response response = given().spec(spec)
                .auth().basic("admin", "1234")
                .contentType(ContentType.JSON)
                .body(expectedData)
                .when()
                .post("/{first}");
        //Validate
        response.then()
                .assertThat()
                .statusCode(201)
                .body("userId", equalTo(55))
                .body("title", equalTo("Tidy your room"))
                .body("completed", equalTo(false))
                .log().all();

    }
}
