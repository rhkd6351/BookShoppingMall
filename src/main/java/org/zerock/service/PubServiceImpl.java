package org.zerock.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.zerock.domain.PubVO;
import org.zerock.mapper.PubMapper;

@Service
@Log4j
@AllArgsConstructor
public class PubServiceImpl implements PubService{

    PubMapper mapper;

    @Override
    public PubVO get(int oid) {
        log.info("getting Pub...");
        return mapper.read(oid);
    }

    @Override
    public void insert(PubVO vo) {
        log.info("inserting Pub...");
        mapper.insert(vo);
    }

    @Override
    public PubVO get(String userEmail) {
        log.info("getting Pub according to userEmail...");
        return mapper.readAccordingToUserEmail(userEmail);
    }
}
