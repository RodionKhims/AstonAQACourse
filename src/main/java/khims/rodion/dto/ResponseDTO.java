package khims.rodion.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ResponseDTO {
    private Map<String, Object> args;
    private String data;
    private Map<String, Object> files;
    private Map<String, Object> form;
    private Map<String, Object> headers;
    private Map<String, Object> json;
    private String url;
}
