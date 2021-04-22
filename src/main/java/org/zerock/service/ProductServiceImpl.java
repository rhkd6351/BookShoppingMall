package org.zerock.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.zerock.domain.ProductVO;
import org.zerock.mapper.ProductMapper;

@Service
@Log4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    ProductMapper mapper;

    @Override
    public ProductVO get(int oid) {
        log.info("getting Product...");
        return mapper.read(oid);
    }

    @Override
    public void insert(ProductVO vo) {
        log.info("inserting Product...");
        mapper.insert(vo);
    }
}
