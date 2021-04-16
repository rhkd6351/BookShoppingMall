package org.zerock.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.zerock.domain.TokenVO;
import org.zerock.mapper.TokenMapper;

@Service
@Log4j
@AllArgsConstructor
public class TokenServiceImpl implements TokenService{

    TokenMapper mapper;

    @Override
    public TokenVO get(int oid) {
        log.info("getting Token...");
        return mapper.read(oid);
    }

    @Override
    public void insert(TokenVO vo) {
        log.info("inserting Token...");
        mapper.insert(vo);
    }

    @Override
    public int insertSelectKey(TokenVO vo) {
        log.info("inserting Token...");
        return mapper.insertSelectKey(vo);
    }

}
