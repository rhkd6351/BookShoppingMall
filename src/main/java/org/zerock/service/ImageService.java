package org.zerock.service;

import org.zerock.domain.ImageProductVO;
import org.zerock.domain.ImagePubVO;

public interface ImageService {

    public void insertPubImage(ImagePubVO vo);

    public void insertProductImage(ImageProductVO vo);

}
