package board.dao;

import java.sql.ResultSet;
import java.util.List;

import com.oreilly.servlet.MultipartRequest;

import board.dto.BoardDTO;

public interface BoardDAO {
	public int insertBoard(MultipartRequest mr);
	public int updatetBoard(int num, String writer, String subject, String email, String content);
	public int updatetBoard_readcount(int num, int readcount);
	public List<BoardDTO> listBoard();
	public List<BoardDTO> listBoard_View(int num_select);
	
	public int deleteBoard(int num);
}
