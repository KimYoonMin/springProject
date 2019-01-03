package board.mybatis;


import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.oreilly.servlet.MultipartRequest;

import board.dto.BoardDTO;

public class BoardMapper {
	private static SqlSessionFactory sqlSession;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSession = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (IOException e) {
			throw new RuntimeException("Something bad happened while building"
					+"the SqlMapClient instance." +e, e);
		}
	}
	
	public static List listBoard() {
		SqlSession session = sqlSession.openSession();
		List list = null;		
		try {			
			list = session.selectList("listBoard");
		}finally {
			session.close();
		}		
		return list;
	}
	
	public static List listBoard_View(int num) {
		SqlSession session = sqlSession.openSession();
		List list = null;		
		try {			
			list = session.selectList("listBoard_View", num);
		}finally {
			session.close();
		}		
		return list;
	}
	
	public static void plusReadcount(BoardDTO dto) {
		SqlSession session = sqlSession.openSession();
				
		try {			
			session.selectList("plusReadcount", dto);
			session.commit();
		}finally {
			session.close();
		}		
		
	}
	
	public static BoardDTO getBoard(int num) {
		SqlSession session = sqlSession.openSession();
		BoardDTO dto = null;
		try {			
			dto = (BoardDTO)session.selectOne("getBoard", num);			
		}finally {
			session.close();
		}
		return dto;
	}
	
	public static int insertBoard(BoardDTO dto) {
		SqlSession session = sqlSession.openSession();
		int res = 0;
		try {			
			res = session.insert("insertBoard", dto);
			session.commit();
		}finally {
			session.close();
		}
		return res;
	}
	
	public static int deleteBoard(int num) {
		SqlSession session = sqlSession.openSession();
		int res = 0;
		try {			
			res = session.delete("deleteBoard", num);
			session.commit();
		}finally {
			session.close();
		}
		return res;
	}
	
	public static int updateBoard(BoardDTO dto) {
		SqlSession session = sqlSession.openSession();
		int res = 0;
		try {			
			res = session.update("updateBoard", dto);
			session.commit();
		}finally {
			session.close();
		}
		return res;
	}
	
}
