package org.zerock.domain;

import lombok.Data;

@Data
public class CouponListVO {
   private int oid; //PK
   private String name;
   private String description;
   private int discountPrice;
   private String validDate;
}
