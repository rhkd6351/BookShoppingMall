package org.zerock.domain;

import lombok.Data;

@Data
public class OrderVO {
   private int oid; //PK
   private int price;
   private String address;
   private int quantity;
   private String invoice;
   private String delieveryState;
   private String orderDate;
   private int paymentOid; //FK
   private int productOid; //FK
   private String userEmail; //FK
}
