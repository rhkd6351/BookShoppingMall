package org.zerock.domain;

import lombok.Data;

@Data
public class CouponLogVO {
   private int oid; //PK
   private String issuedDate;
   private String endDate;
   private String usedDate;
   private String userEmail; //FK
   private int couponOid; //FK
}
