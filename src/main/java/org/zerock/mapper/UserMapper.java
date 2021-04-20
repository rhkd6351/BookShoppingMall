package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.UserVO;


public interface UserMapper {

    public UserVO read(String email);

    public void insert(UserVO vo);

    public void kakaoInsert(UserVO vo);

    public void updatePw(@Param("pw") String pw, @Param("email")String email);
    public void updateGender(@Param("gender") String gender, @Param("email")String email);
    public void updateBirth(@Param("birth") String birth, @Param("email")String email);
    public void updatePhone(@Param("phone") String phone, @Param("email")String email);
}
