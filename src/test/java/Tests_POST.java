import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.*;// to use RestAssured functions directly without saying REstAssured.functionname()
import static org.hamcrest.Matchers.*;


public class Tests_POST {

    //Post Request to add new user
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
        .when()
                .post("https://reqres.in/api/users")
        .then()
                .statusCode(201)
                .log().all();
    }

    //PUT Request to update user
    @Test
    public void updateUser_PUT(){

        JSONObject body = new JSONObject();
        body.put("name", "Amr Mohamed");
        body.put("job", "Backend Developer");

        given()
                .header("Content-Type", "application/json")
                .body(body.toJSONString())
        .when()
                .put("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .log().all();
    }


    //Patch Request to update user
    @Test
    public void updateUser_PATCH(){

        JSONObject body = new JSONObject();
        body.put("name", "Amr Mohamed");
        body.put("job", "Backend Developer");

        given()
                .header("Content-Type", "application/json")
                .body(body.toJSONString())
        .when()
                .patch("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .log().all();
    }
}
