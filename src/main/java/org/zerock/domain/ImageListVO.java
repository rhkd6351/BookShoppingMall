package org.zerock.domain;

import lombok.Data;

@Data
public class ImageListVO {
   private int oid; //PK
   private String name;
   private int width;
   private int height;
}
