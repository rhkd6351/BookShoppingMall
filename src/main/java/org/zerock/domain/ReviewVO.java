package org.zerock.domain;

import lombok.Data;

@Data
public class ReviewVO {
   private int oid; //PK
   private String title;
   private String content;
   private int score;
   private String regDate;
   private int productOid; //FK
   private String userEmail; //FK
}
