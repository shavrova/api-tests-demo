package com.framework.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.net.URL;

@ToString
@Data
@Builder
@AllArgsConstructor
public class AccountDto {
    private int id;
    private String url;
    private String bio;
    private URL avatar;
    private String avatar_name;
    private URL cover;
    private String CoverName;
    private String reputation;
    private String Created;


}
