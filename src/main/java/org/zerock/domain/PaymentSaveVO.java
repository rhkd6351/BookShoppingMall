package org.zerock.domain;

import lombok.Data;

@Data
public class PaymentSaveVO {
   private int oid; //PK
   private String name;
   private String description;
   private String userEmail; //FK
}
