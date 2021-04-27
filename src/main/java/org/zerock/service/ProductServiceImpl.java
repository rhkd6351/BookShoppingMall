package org.zerock.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.zerock.domain.ProductVO;
import org.zerock.mapper.ProductMapper;

import java.util.ArrayList;

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
    public ArrayList<ProductVO> getAccordingToPubOid(int oid) {
        log.info("getting Product according to Pub oid...");
        return mapper.readAccordingToPubOid(oid);
    }

    @Override
    public ArrayList<ProductVO> getNewBookLayer(int num) {
        log.info("getting New Book Layer Products num = " + num);
        return mapper.newBookLayer(num);
    }

    @Override
    public void insert(ProductVO vo) {
        log.info("inserting Product...");
        mapper.insert(vo);
    }

    @Override
    public void update(ProductVO vo){
        log.info("updating Product");
        mapper.update(vo);
    }

    @Override
    public ProductVO init(String title, String subTitle, int pub, int price, String contents, int deliveryFee,
                          String description, int author, int category) {
        ProductVO productVO = new ProductVO();
        productVO.setTitle(title); productVO.setSubTitle(subTitle);
        productVO.setPubOid(pub); productVO.setPrice(price);
        productVO.setContents(contents); productVO.setDeliveryFee(deliveryFee);
        productVO.setDescription(description); productVO.setAuthorOid(author);
        productVO.setCategoryOid(category);

        return productVO;
    }
}
