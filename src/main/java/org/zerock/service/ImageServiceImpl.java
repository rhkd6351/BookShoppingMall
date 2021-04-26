package org.zerock.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.zerock.domain.ImageProductVO;
import org.zerock.domain.ImagePubVO;
import org.zerock.domain.PubVO;
import org.zerock.mapper.ImageMapper;
import org.zerock.mapper.PubMapper;

@Service
@Log4j
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {

    ImageMapper mapper;


    @Override
    public void insertPubImage(ImagePubVO vo) {
        log.info("inserting PubImage...");
        mapper.insertPubImage(vo);
    }

    @Override
    public ImagePubVO getPubImage(int pubOid) {
        log.info("getting PubImage...");
        return mapper.readPubImage(pubOid);
    }

    @Override
    public void insertProductImage(ImageProductVO vo) {
        log.info("inserting ProductImage...");
        mapper.insertProductImage(vo);
    }
}
