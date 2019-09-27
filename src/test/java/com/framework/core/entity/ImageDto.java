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


    /* GET image response:
        {
        "data": {
            "id": "qE93Uyc",
            "title": null,
            "description": null,
            "datetime": 1565883186,
            "type": "image/jpeg",
            "animated": false,
            "width": 1080,
            "height": 1080,
            "size": 127264,
            "views": 2,
            "bandwidth": 254528,
            "vote": null,
            "favorite": false,
            "nsfw": false,
            "section": null,
            "account_url": null,
            "account_id": 111183523,
            "is_ad": false,
            "in_most_viral": false,
            "has_sound": false,
            "tags": [

            ],
            "ad_type": 0,
            "ad_url": "",
            "edited": "0",
            "in_gallery": false,
            "deletehash": "1EMqVXm9rpMH9eN",
            "name": null,
            "link": "https://i.imgur.com/qE93Uyc.jpg",
            "ad_config": {
                "safeFlags": [
                    "onsfw_mod_safe",
                    "share"
                ],
                "highRiskFlags": [
                    "not_in_gallery"
                ],
                "unsafeFlags": [

                ],
                "showsAds": true
            }
        },
        "success": true,
        "status": 200
    }

video response:

 {
        "data": {
            "id": "VnhgVV2",
            "title": null,
            "description": "sampl desc",
            "datetime": 1569146681,
            "type": "video/mp4",
            "animated": true,
            "width": 960,
            "height": 540,
            "size": 812071,
            "views": 419,
            "bandwidth": 340257749,
            "vote": null,
            "favorite": false,
            "nsfw": false,
            "section": null,
            "account_url": null,
            "account_id": 111183523,
            "is_ad": false,
            "in_most_viral": false,
            "has_sound": false,
            "tags": [

            ],
            "ad_type": 0,
            "ad_url": "",
            "edited": "0",
            "in_gallery": false,
            "deletehash": "UMBcQ9Q8l4grAfW",
            "name": null,
            "link": "https://i.imgur.com/VnhgVV2.mp4",
            "mp4_size": 812071,
            "mp4": "https://i.imgur.com/VnhgVV2.mp4",
            "gifv": "https://i.imgur.com/VnhgVV2.gifv",
            "hls": "https://i.imgur.com/VnhgVV2.m3u8",
            "processing": {
                "status": "completed"
            },
            "ad_config": {
                "safeFlags": [
                    "onsfw_mod_safe",
                    "share"
                ],
                "highRiskFlags": [
                    "not_in_gallery"
                ],
                "unsafeFlags": [

                ],
                "showsAds": true
            }
        },
        "success": true,
        "status": 200
    }





     */


    @Getter
    private String id;

    @Getter
    private String title;

    @Getter
    private String description;

    @Getter
    private String type;

    @Getter
    private String link;

    @Getter
    private int size;


    @SuppressWarnings("unchecked")
    @JsonProperty("data")
    private void unpackNested(Map<String,Object> data) {
        this.id = (String)data.get("id");
        this.title = (String) data.get("title");
        this.description = (String) data.get("description");
        this.type = (String) data.get("type");
        this.link = (String) data.get("link");
        this.size = (int) data.get("size");
     }

}
