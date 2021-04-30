package org.zerock.dto;

import lombok.Data;

@Data
public class CartViewDTO {
   //cart
   private int oid; //PK
   private int quantity;

   //product
   private int productOid;
   private String productTitle;
   private int price;

   //pub
   private String pubName;

   //img
   private String repUri;

   //author
   private String authorName;
}
