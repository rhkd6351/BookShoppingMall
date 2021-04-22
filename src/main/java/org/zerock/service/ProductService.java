package org.zerock.service;

import org.zerock.domain.ProductVO;


public interface ProductService {

    public ProductVO get(int oid);

    public void insert(ProductVO vo);
}
