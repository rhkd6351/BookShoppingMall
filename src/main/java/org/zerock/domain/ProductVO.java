package org.zerock.domain;

import lombok.Data;

@Data
public class ProductVO {
   private int oid; //PK
   private String title;
   private String subTitle;
   private String description;
   private int price;
   private int deliveryFee;
   private String tag;
   private String regDate;
   private String contents;
   private int authorOid;
   private int pubOid; //FK
   private int categoryOid; //FK

   public String authorName;
   public String repUri;
   public String descUri;
}
