package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.ProductVO;

import java.util.ArrayList;


public interface ProductMapper {

    public ProductVO read(int oid);

    public void insert(ProductVO vo);

    public ArrayList<ProductVO> readAccordingToPubOid(int pubOid);

    public void update(ProductVO vo);

    public ArrayList<ProductVO> newBookLayer(@Param("num") int num);
    
}