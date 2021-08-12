package com.hk.service;

import java.util.List;
import com.hk.vo.MovieVO;
 

// 비즈니스 로직 작성. DB 처리 시 많이 이용. 
public interface MovieService {
    public List<MovieVO> selectMovie() throws Exception;
}