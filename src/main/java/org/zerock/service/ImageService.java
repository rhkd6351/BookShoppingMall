package org.zerock.service;

import org.zerock.domain.ImageProductVO;
import org.zerock.domain.ImagePubVO;

public interface ImageService {

    public void insertPubImage(ImagePubVO vo);

    public ImagePubVO getPubImage(int pubOid);

    public void insertProductImage(ImageProductVO vo);

}
