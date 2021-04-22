package org.zerock.domain;

import lombok.Data;

@Data
public class AuthorVO {
   private int oid; //PK

   private String name;

   private String description;
}
