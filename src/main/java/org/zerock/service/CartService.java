package org.zerock.service;

import org.zerock.domain.CartVO;
import org.zerock.dto.CartViewDTO;

import java.util.ArrayList;


public interface CartService {

    public ArrayList<CartViewDTO> getByUserEmail(String userEmail);

    public void insert(CartVO vo);

    public void delete(int cartOid, String userEmail);
}
