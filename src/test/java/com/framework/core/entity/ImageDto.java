package com.framework.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Map;

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class ImageDto {



    @Getter
    private String id;

    @Getter
    private String title;

    @Getter
    private String description;


    @SuppressWarnings("unchecked")
    @JsonProperty("data")
    private void unpackNested(Map<String,Object> data) {
        this.id = (String)data.get("id");
        this.title = (String) data.get("title");
        this.description = (String) data.get("description");
    }

}
