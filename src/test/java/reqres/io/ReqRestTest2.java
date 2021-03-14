package reqres.io;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class ReqRestTest2 {

    @Test
    public void getRequestTest() {

        Response response = given()
                .baseUri("https://reqres.in/")
                .basePath("/api/users")
                .queryParam("page",2)
                .contentType(ContentType.JSON)
                .get();

        response.prettyPrint();

        response.then().assertThat().statusCode(200);
    }

    @Test
    public void putRequest() {

        String newUser = "{\n" +
                "    \"name\": \"yunus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

        Response response = given()
                           .baseUri("https://reqres.in/")
                           .basePath("/api/users/2")
                            .body(newUser)
                            .put();

                response.then().statusCode(200);



    }

}
