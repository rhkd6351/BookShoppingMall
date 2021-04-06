package org.zerock.domain;

import lombok.Data;

@Data
public class UserVO {
    private String email; //PK
    private int pw;
    private int gender;
    private String birth;
    private String address;
    private int point;
    private String platform;
    private String regDate;
    private String delDate;
    private String type;
}
