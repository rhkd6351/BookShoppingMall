package org.zerock.dto;

import lombok.Data;

@Data
public class ProductListDTO {
   private int oid; //PK
   private String title;
   private int price;
   private String tag;
   private int categoryOid; //FK

   public String authorName;
   public String repUri;
   public String descUri;
}
