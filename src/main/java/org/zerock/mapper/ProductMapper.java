package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.ProductVO;


public interface ProductMapper {

    public ProductVO read(int oid);

    public void insert(ProductVO vo);
    
}
