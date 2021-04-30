package org.zerock.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.zerock.domain.CartVO;
import org.zerock.dto.CartViewDTO;
import org.zerock.mapper.CartMapper;

import java.util.ArrayList;

@Service
@Log4j
@AllArgsConstructor
public class CartServiceImpl implements CartService{

    CartMapper mapper;

    @Override
    public ArrayList<CartViewDTO> getByUserEmail(String userEmail) {
        log.info("listing cart ...");
        return mapper.readByUserEmail(userEmail);
    }

    public void insert(CartVO vo){
        log.info("insert cart ...");
        mapper.insert(vo);
    }

    public void delete(int cartOid, String userEmail){
        log.info("deleting cart ...");
        mapper.delete(cartOid, userEmail);
    }

}
