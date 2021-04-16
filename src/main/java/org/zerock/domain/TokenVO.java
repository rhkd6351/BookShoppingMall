package org.zerock.domain;

import lombok.Data;

@Data
public class TokenVO {
    private int oid;
    private String refreshToken;
    private String refreshDuration;
    private String regDate;
}
