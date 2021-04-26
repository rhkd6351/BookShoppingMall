package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.ImageProductVO;
import org.zerock.domain.ImagePubVO;
import org.zerock.domain.PubVO;


public interface ImageMapper {

    public void insertPubImage(ImagePubVO vo);

    public void insertProductImage(ImageProductVO vo);

    public ImagePubVO readPubImage(@Param("pubOid") int pubOid);

}
