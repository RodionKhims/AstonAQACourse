package khims.rodion.utils;

import io.restassured.specification.RequestSpecification;

import java.util.Map;
import java.util.Objects;

public class RequestSpecificationUtils {
    public static RequestSpecification buildContentType(RequestSpecification requestSpecification, String contentType) {
        if (Objects.nonNull(contentType)) {
            return requestSpecification.contentType(contentType);
        }
        return requestSpecification;
    }

    public static RequestSpecification buildBody(RequestSpecification requestSpecification, Object body) {
        if (Objects.nonNull(body)) {
            return requestSpecification.body(body);
        }
        return requestSpecification;
    }

    public static RequestSpecification buildParams(RequestSpecification requestSpecification, Map<String, Object> params) {
        if (Objects.nonNull(params)) {
            return params.entrySet().stream()
                    .map(entry -> requestSpecification.param(entry.getKey(), entry.getValue()))
                    .reduce(requestSpecification, RequestSpecification::spec);
        }
        return requestSpecification;
    }
}
