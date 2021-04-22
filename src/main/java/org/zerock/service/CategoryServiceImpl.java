package org.zerock.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.zerock.domain.CategoryVO;
import org.zerock.mapper.CategoryMapper;

import java.util.ArrayList;

@Service
@Log4j
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    CategoryMapper mapper;

    @Override
    public ArrayList<CategoryVO> getAll() {
        log.info("getting Category...");
        return mapper.readAll();
    }

}
