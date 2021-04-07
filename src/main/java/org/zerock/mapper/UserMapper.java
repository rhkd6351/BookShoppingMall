package org.zerock.mapper;

import org.zerock.domain.UserVO;

import java.util.List;

public interface UserMapper {

    public UserVO read(String id);

    public void insert(UserVO vo);
}
