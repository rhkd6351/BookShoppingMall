package org.zerock.service;

import org.zerock.domain.UserVO;

import java.util.List;


public interface UserService {

    public UserVO get(String email);

    public void insert(UserVO vo);

    public void kakaoInsert(UserVO vo);
}
