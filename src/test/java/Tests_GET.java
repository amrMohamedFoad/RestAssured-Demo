import org.junit.Test;
import static io.restassured.RestAssured.*;// to use RestAssured functions directly without saying REstAssured.functionname()
import static org.hamcrest.Matchers.*;

public class Tests_GET {

    @Test
    public void listUsers(){
        given()
               // .header("Content-Type", "application/json")
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[1]", equalTo(8))
                .body("data.first_name", hasItems("Michael", "Lindsay"))
                .log().all();
    }
}
