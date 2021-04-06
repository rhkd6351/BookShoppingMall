package org.zerock.domain;

import lombok.Data;

@Data
public class ProductVO {
   private int oid; //PK
   private String name;
   private String description;
   private int price;
   private int delieveryFee;
   private String tag;
   private String regDate;
   private int pubOid; //FK
   private int categoryOid; //FK
}
