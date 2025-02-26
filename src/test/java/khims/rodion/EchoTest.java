package khims.rodion;

import io.restassured.RestAssured;
import khims.rodion.dto.ResponseDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class EchoTest extends BaseTest {
    @Test
    public void testGetRequest() {
        ResponseDTO responseDTO = RestAssured
                .given()
                    .baseUri("https://postman-echo.com/")
                    .param("key1", "value1")
                    .param("key2", "value2")
                .when()
                    .get("get")
                .then()
                    .statusCode(200)
                    .extract().body().as(ResponseDTO.class);

        Assertions.assertThat(responseDTO.getArgs().get("key1")).isEqualTo("value1");
        Assertions.assertThat(responseDTO.getArgs().get("key2")).isEqualTo("value2");
        assertHeaders(responseDTO.getHeaders(), 0);
        Assertions.assertThat(responseDTO.getUrl()).isEqualTo("https://postman-echo.com/get?key1=value1&key2=value2");
    }

    @Test
    public void testPostRawText() {
        String data = "Test data";

        ResponseDTO responseDTO = RestAssured
                .given()
                    .baseUri("https://postman-echo.com/")
                    .body(data)
                .when()
                    .post("post")
                .then()
                    .statusCode(200)
                    .extract().body().as(ResponseDTO.class);

        Assertions.assertThat(responseDTO.getData()).isEqualTo(data);
        assertHeaders(responseDTO.getHeaders(), data.length());
        Assertions.assertThat(responseDTO.getUrl()).isEqualTo("https://postman-echo.com/post");
    }

    @Test
    public void testPostFormData() {
        ResponseDTO responseDTO = RestAssured
                .given()
                    .baseUri("https://postman-echo.com/")
                    .contentType("application/x-www-form-urlencoded; charset=utf-8")
                    .param("key1", "value1")
                    .param("key2", "value2")
                .when()
                    .post("post")
                .then()
                    .statusCode(200)
                    .extract().body().as(ResponseDTO.class);

        Assertions.assertThat(responseDTO.getForm().get("key1")).isEqualTo("value1");
        Assertions.assertThat(responseDTO.getForm().get("key2")).isEqualTo("value2");
        Assertions.assertThat(responseDTO.getJson().get("key1")).isEqualTo("value1");
        Assertions.assertThat(responseDTO.getJson().get("key2")).isEqualTo("value2");
        assertHeaders(responseDTO.getHeaders(), 23);
        Assertions.assertThat(responseDTO.getUrl()).isEqualTo("https://postman-echo.com/post");
    }

    @Test
    public void testPutRequest() {
        String data = "Test data";

        ResponseDTO responseDTO = RestAssured
                .given()
                    .baseUri("https://postman-echo.com/")
                    .body(data)
                .when()
                    .put("put")
                .then()
                    .statusCode(200)
                    .extract().body().as(ResponseDTO.class);

        Assertions.assertThat(responseDTO.getData()).isEqualTo(data);
        assertHeaders(responseDTO.getHeaders(), data.length());
        Assertions.assertThat(responseDTO.getUrl()).isEqualTo("https://postman-echo.com/put");
    }

    @Test
    public void testPatchRequest() {
        String data = "Test data";

        ResponseDTO responseDTO = RestAssured
                .given()
                    .baseUri("https://postman-echo.com/")
                    .body(data)
                .when()
                    .patch("patch")
                .then()
                    .statusCode(200)
                    .extract().body().as(ResponseDTO.class);

        Assertions.assertThat(responseDTO.getData()).isEqualTo(data);
        assertHeaders(responseDTO.getHeaders(), data.length());
        Assertions.assertThat(responseDTO.getUrl()).isEqualTo("https://postman-echo.com/patch");
    }

    @Test
    public void testDeleteRequest() {
        String data = "Test data";

        ResponseDTO responseDTO = RestAssured
                .given()
                    .baseUri("https://postman-echo.com/")
                    .body(data)
                .when()
                    .delete("delete")
                .then()
                    .statusCode(200)
                    .extract().body().as(ResponseDTO.class);

        Assertions.assertThat(responseDTO.getData()).isEqualTo(data);
        assertHeaders(responseDTO.getHeaders(), data.length());
        Assertions.assertThat(responseDTO.getUrl()).isEqualTo("https://postman-echo.com/delete");
    }

    private static void assertHeaders(Map<String, Object> headers, int contentLength) {
        Assertions.assertThat(headers.get("host")).isEqualTo("postman-echo.com");
        Assertions.assertThat(headers.get("connection")).isEqualTo("close");
        Assertions.assertThat(headers.get("x-forwarded-proto")).isEqualTo("https");
        Assertions.assertThat(headers.get("x-forwarded-port")).isEqualTo("443");
        if (contentLength > 0) {
            Assertions.assertThat(headers.get("content-length")).isEqualTo(String.valueOf(contentLength));
        }
    }
}
