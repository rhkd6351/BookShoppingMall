package org.zerock.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class PubVO {
   private int oid; //PK
   private String name;
   private String description;
   private String userEmail; //FK

   @Builder
   public PubVO(){
   }

   @Builder
   public PubVO(String name, String description, String userEmail){
      this.name = name;
      this.description = description;
      this.userEmail = userEmail;
   }
}
