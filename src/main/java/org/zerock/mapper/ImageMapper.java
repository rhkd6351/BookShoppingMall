package org.zerock.mapper;

import org.zerock.domain.ImageProductVO;
import org.zerock.domain.ImagePubVO;
import org.zerock.domain.PubVO;


public interface ImageMapper {

    public void insertPubImage(ImagePubVO vo);

    public void insertProductImage(ImageProductVO vo);

}
