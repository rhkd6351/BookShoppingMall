package org.zerock.domain;

import lombok.Data;

@Data
public class ImageVO {
   private int oid; //PK
   private String name;
   private String path;
   private String type;
   private int fileSize;
   private int imageListOid; //FK
   private int productOid; //FK
}
