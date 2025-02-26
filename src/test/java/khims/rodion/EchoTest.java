package khims.rodion;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import khims.rodion.dto.ResponseDTO;
import khims.rodion.utils.RequestSpecificationUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Objects;

public class EchoTest extends BaseTest {
    private final Map<String, Object> params = Map.of(
            "key1", "value1",
            "key2", "value2"
    );
    private final String data = "Test data";

    @Test
    @DisplayName("Test Get Request")
    public void testGetRequest() {
        ResponseDTO responseDTO = testEchoMethod(null, "get", params, null);
        params.forEach((key, value) ->
                Assertions.assertThat(responseDTO.getArgs().get(key)).isEqualTo(value));
        Assertions.assertThat(responseDTO.getUrl()).contains("https://postman-echo.com/get");
    }

    @Test
    @DisplayName("Test Post Raw Text")
    public void testPostRawText() {
        testEchoMethod(data, "post", null, null);
    }

    @Test
    @DisplayName("Test Post Form Data")
    public void testPostFormData() {
        ResponseDTO responseDTO = testEchoMethod(null, "post", params, "application/x-www-form-urlencoded; charset=utf-8");
        params.forEach((key, value) -> {
            Assertions.assertThat(responseDTO.getForm().get(key)).isEqualTo(value);
            Assertions.assertThat(responseDTO.getJson().get(key)).isEqualTo(value);
        });
    }

    @Test
    @DisplayName("Test Put Request")
    public void testPutRequest() {
        testEchoMethod(data, "put", null, null);
    }

    @Test
    @DisplayName("Test Patch Request")
    public void testPatchRequest() {
        testEchoMethod(data, "patch", null, null);
    }

    @Test
    @DisplayName("Test Delete Request")
    public void testDeleteRequest() {
        testEchoMethod(data, "delete", null, null);
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

    private static ResponseDTO testEchoMethod(String body, String method, Map<String, Object> params, String contentType) {
        RequestSpecification requestSpecification = RestAssured
                .given()
                .baseUri("https://postman-echo.com/");
        requestSpecification = RequestSpecificationUtils.buildContentType(requestSpecification, contentType);
        requestSpecification = RequestSpecificationUtils.buildBody(requestSpecification, body);
        requestSpecification = RequestSpecificationUtils.buildParams(requestSpecification, params);
        Response response = execRequest(requestSpecification, method);
        ResponseDTO responseDTO = response.then()
                .statusCode(200)
                .extract().body().as(ResponseDTO.class);

        if (Objects.nonNull(body)) {
            Assertions.assertThat(responseDTO.getData()).isEqualTo(body);
            assertHeaders(responseDTO.getHeaders(), body.length());
        }
        if (!"get".equals(method)) {
            Assertions.assertThat(responseDTO.getUrl()).isEqualTo("https://postman-echo.com/" + method);
        }
        return responseDTO;
    }

    private static Response execRequest(RequestSpecification requestSpecification, String method) {
        switch (method) {
            case "get":
                return requestSpecification.when().get(method);
            case "post":
                return requestSpecification.when().post(method);
            case "put":
                return requestSpecification.when().put(method);
            case "patch":
                return requestSpecification.when().patch(method);
            case "delete":
                return requestSpecification.when().delete(method);
            default:
                throw new IllegalArgumentException(method);
        }
    }
}
