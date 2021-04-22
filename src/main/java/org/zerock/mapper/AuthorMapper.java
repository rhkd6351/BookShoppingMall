package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.AuthorVO;
import org.zerock.domain.PubVO;

import java.util.ArrayList;


public interface AuthorMapper {

    public AuthorVO read(int oid);

    public ArrayList<AuthorVO> readAll();

    public void insert(AuthorVO vo);
}
