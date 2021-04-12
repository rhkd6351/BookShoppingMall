package org.zerock.mapper;

import org.zerock.domain.UserVO;


public interface UserMapper {

    public UserVO read(String email);

    public void insert(UserVO vo);
}
