package org.zerock.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class CartVO {
   private int oid; //PK
   private int quantity;
   private String regDate;
   private int productOid; //FK
   private String userEmail; //FK

   @Builder
   public CartVO(int productOid, int quantity, String userEmail){
      this.productOid = productOid;
      this.quantity = quantity;
      this.userEmail = userEmail;
   }

   @Builder
   public CartVO(){

   }
}
