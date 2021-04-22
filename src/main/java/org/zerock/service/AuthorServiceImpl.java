package org.zerock.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.zerock.domain.AuthorVO;
import org.zerock.domain.PubVO;
import org.zerock.mapper.AuthorMapper;
import org.zerock.mapper.PubMapper;

import java.util.ArrayList;

@Service
@Log4j
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    AuthorMapper mapper;

    @Override
    public AuthorVO get(int oid) {
        log.info("getting Author...");
        return mapper.read(oid);
    }

    @Override
    public ArrayList<AuthorVO> getAll() {
        log.info("getting Author...");
        return mapper.readAll();
    }

    @Override
    public void insert(AuthorVO vo) {
        log.info("inserting Author...");
        mapper.insert(vo);
    }

}
