package reqres.io;

import static io.restassured.RestAssured.given;

public class ReqRestTest {

    public static void main(String[] args) {
       given()
                .baseUri("https://reqres.in")
                .basePath("/api/users")
                .queryParam("page",2)
                .log().all()
                .get().then().log().body(true);

    }
}
