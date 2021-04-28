package org.zerock.dto;

import lombok.Data;

@Data
public class ProductViewDTO {
   //product
   private int oid; //PK
   private String title;
   private String subTitle;
   private int price;
   private int deliveryFee;
   private String description;
   private String contents;

   //category
   private String categoryName;

   //author
   public String authorName;
   public String authorDesc;

   //img
   public String repUri;
   public String descUri;

   //pub
   public String pubName;
}
