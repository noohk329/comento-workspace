package com.hk.dao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
 
import com.hk.vo.MovieVO;

@Repository
public class MovieDAOImpl implements MovieDAO {
	@Inject
    private SqlSession sqlSession;
    private static final String Namespace = "com.hk.mybatis.sql.test";
    
    @Override
    public List<MovieVO> selectMovie() throws Exception {
 
        return sqlSession.selectList(Namespace+".selectMovie");
    }

}
