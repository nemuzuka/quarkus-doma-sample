package net.jp.vss;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class GreetingResource_RequiredArgsConstructorTest {
  @Test
  public void testHelloEndpoint() {
    given()
        .when()
        .get("/hello-resteasy-required-args-constructor")
        .then()
        .statusCode(200)
        .body(is("Hello RESTEasy"));
  }
}
