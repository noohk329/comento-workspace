package com.hk.dao;
import java.util.List;
import com.hk.vo.MovieVO;

public interface MovieDAO {
	public List<MovieVO> selectMovie() throws Exception;
}
