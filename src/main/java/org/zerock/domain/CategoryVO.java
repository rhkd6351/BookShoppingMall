package org.zerock.domain;

import lombok.Data;

@Data
public class CategoryVO {
   private int oid; //PK
   private String name;
   private String description;
}
