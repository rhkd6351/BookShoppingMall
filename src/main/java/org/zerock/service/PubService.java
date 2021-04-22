package org.zerock.service;

import org.zerock.domain.PubVO;


public interface PubService {

    public PubVO get(int oid);

    public void insert(PubVO vo);

    public PubVO get(String userEmail);
}
