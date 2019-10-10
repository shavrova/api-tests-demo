package com.framework.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@NoArgsConstructor
public class ImageDto {
    private String id;
    private String title;
    private String description;
    private String name;
    private String type;
    private String link;
    private int size;
    private String deleteHash;

    private HttpClientErrorException exception;

    public ImageDto(HttpClientErrorException exception) {
        this.exception = exception;
    }

    @SuppressWarnings("unchecked")
    @JsonProperty(value = "data")
    private void unpackNested(Map<String, Object> data) {
        this.id = (String) data.get("id");
        this.title = (String) data.get("title");
        this.description = (String) data.get("description");
        this.name = (String) data.get("name");
        this.type = (String) data.get("type");
        this.link = (String) data.get("link");
        this.size = (int) data.get("size");
        this.deleteHash = (String) data.get("deletehash");
    }

}
