package org.zerock.mapper;

import org.zerock.domain.TokenVO;
import org.zerock.domain.UserVO;


public interface TokenMapper {

    public TokenVO read(int oid);

    public void insert(TokenVO vo);

    public int insertSelectKey(TokenVO vo);
}
