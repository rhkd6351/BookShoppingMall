package org.zerock.service;

import org.zerock.domain.UserVO;

import java.util.List;


public interface UserService {

    public UserVO get(String id);

    public void insert(UserVO vo);
}
