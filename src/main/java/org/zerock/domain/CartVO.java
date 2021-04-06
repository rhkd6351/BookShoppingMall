package org.zerock.domain;

import lombok.Data;

@Data
public class CartVO {
   private int oid; //PK
   private int quantity;
   private String regDate;
   private int productOid; //FK
   private String userEmail; //FK
}
