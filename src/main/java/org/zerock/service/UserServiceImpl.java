package org.zerock.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.zerock.domain.UserVO;
import org.zerock.mapper.UserMapper;

@Service
@Log4j
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    UserMapper mapper;

    @Override
    public UserVO get(String id) {
        log.info("getting User...");
        return mapper.read(id);
    }

    @Override
    public void insert(UserVO vo) {
        log.info("inserting User...");
        mapper.insert(vo);
    }

}
