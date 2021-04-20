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
    public UserVO get(String email) {
        log.info("getting User...");
        return mapper.read(email);
    }

    @Override
    public void insert(UserVO vo) {
        log.info("inserting User...");
        mapper.insert(vo);
    }

    @Override
    public void kakaoInsert(UserVO vo) {
        log.info("inserting kakao User...");
        mapper.kakaoInsert(vo);
    }

    @Override
    public void updatePw(String pw, String email) {
        log.info("updating pw...");
        mapper.updatePw(pw, email);
    }

    @Override
    public void updatePhone(String phone, String email) {
        log.info("updating phone...");
        mapper.updatePhone(phone, email);
    }

    @Override
    public void updateGender(String gender, String email) {
        log.info("updating gender...");
        mapper.updateGender(gender, email);
    }

    @Override
    public void updateBirth(String birth, String email) {
        log.info("updating birth...");
        mapper.updateBirth(birth, email);
    }

}
