package org.zerock.domain;

import lombok.Data;

@Data
public class PubVO {
   private int oid; //PK
   private String name;
   private String description;
   private String userEmail; //FK
}
