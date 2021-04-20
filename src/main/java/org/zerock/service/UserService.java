package org.zerock.service;

import org.zerock.domain.UserVO;

import java.util.List;


public interface UserService {

    public UserVO get(String email);

    public void insert(UserVO vo);

    public void kakaoInsert(UserVO vo);

    public void updatePw(String pw, String email);

    public void updatePhone(String phone, String email);

    public void updateGender(String gender, String email);

    public void updateBirth(String birth, String email);
}
