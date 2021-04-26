package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.PubVO;


public interface PubMapper {

    public PubVO read(int oid);

    public PubVO readAccordingToUserEmail(@Param("userEmail") String userEmail);

    public void insert(PubVO vo);

    public int delete(@Param("userEmail") String userEmail);

    public void update(PubVO vo);
}
