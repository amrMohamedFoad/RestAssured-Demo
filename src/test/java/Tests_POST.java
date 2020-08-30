import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.*;// to use RestAssured functions directly without saying REstAssured.functionname()
import static org.hamcrest.Matchers.*;


public class Tests_POST {

    @Test
    public void createUser(){

        JSONObject body = new JSONObject();
        body.put("name", "Amr Mohamed");
        body.put("job", "Software Developer");

        given()
                .header("Content-Type", "application/json")
               //.contentType(ContentType.JSON)
               //.accept(ContentType.JSON)
                .body(body.toJSONString())
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .log().all();
    }
}
