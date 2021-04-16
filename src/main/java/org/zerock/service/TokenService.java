package org.zerock.service;

import org.zerock.domain.TokenVO;
import org.zerock.domain.UserVO;


public interface TokenService {

    public TokenVO get(int oid);

    public void insert(TokenVO vo);

    public int insertSelectKey(TokenVO vo);
}
