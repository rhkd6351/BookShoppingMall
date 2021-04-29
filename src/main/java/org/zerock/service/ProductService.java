package org.zerock.service;

import org.zerock.domain.ProductVO;
import org.zerock.dto.ProductRecentDTO;
import org.zerock.dto.ProductViewDTO;

import java.util.ArrayList;


public interface ProductService {

    public ProductVO get(int oid);

    public ArrayList<ProductVO> getAccordingToPubOid(int oid);

    public ArrayList<ProductVO> getNewBookLayer(int num);

    public ProductViewDTO getSpecProduct(int oid);

    public ProductRecentDTO getRecentProduct(int oid);

    public void insert(ProductVO vo);

    public void update(ProductVO vo);

    public ProductVO init(String title, String subTitle, int pub, int price, String contents, int deliveryFee,
                          String description, int author, int category);
}
