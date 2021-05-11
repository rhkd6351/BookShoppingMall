package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.CartVO;
import org.zerock.dto.CartViewDTO;

import java.util.ArrayList;


public interface CartMapper {

    public ArrayList<CartViewDTO> readByUserEmail(@Param("userEmail") String userEmail);

    public CartViewDTO readByOid(@Param("oid") int oid);

    public void insert(CartVO cart);

    public void delete(@Param("cartOid")int cartOid, @Param("userEmail")String userEmail);

    public void update(@Param("cartOid") int cartOid, @Param("quantity") int quantity);

}
