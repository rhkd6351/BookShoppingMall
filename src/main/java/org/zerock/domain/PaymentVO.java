package org.zerock.domain;

import lombok.Data;

@Data
public class PaymentVO {
   private int oid; //PK
   private int price;
   private int isPaid;
   private int paymentSaveOid; //FK
   private String userEmail; //FK
}
