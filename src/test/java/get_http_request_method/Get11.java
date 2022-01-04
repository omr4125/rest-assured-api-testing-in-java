package get_http_request_method;

import base_urls.DummyApiBaseUrl;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.Employee;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class Get11 extends DummyApiBaseUrl {
     /*
      When
        I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employees
       Status code should be 200
       Use Gson and ObjectMapper
       make sure you have 24 records for data
  */
    @Test
    public void get11() throws IOException {
        //Set the url
        spec.pathParams("first", "api", "second", "v1", "third", "employees");
        //Send the request and get response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);

        ObjectMapper obj = new ObjectMapper();//This is a converter from Java to JSON

        Employee employees = obj.readValue(response.asString(), Employee.class);

        for (int i = 0; i < employees.getData().size() ; i++) {
            System.out.println(i + " .person is: " + employees.getData().get(i).getEmployee_name());
        }
    }
    @Test
    public void get11D(){
        //Set the url
        spec.pathParams("first", "api", "second", "v1", "third", "employees");
        //Send the request and get response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");

        Gson gson = new Gson();
        Employee employees = gson.fromJson(response.asString(), Employee.class);

        System.out.println("The employees data size: " + employees.getData().size());

        assertTrue(employees.getData().size() == 24, "The data does not match!");

    }
}
