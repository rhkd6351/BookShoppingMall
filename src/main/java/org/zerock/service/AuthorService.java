package org.zerock.service;

import org.zerock.domain.AuthorVO;

import java.util.ArrayList;


public interface AuthorService {

    public AuthorVO get(int oid);

    public ArrayList<AuthorVO> getAll();

    public void insert(AuthorVO vo);

}
