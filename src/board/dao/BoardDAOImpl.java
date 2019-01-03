package board.dao;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.oreilly.servlet.MultipartRequest;

import board.dto.BoardDTO;
import student.dto.StudentDTO;


public class BoardDAOImpl implements BoardDAO {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertBoard(MultipartRequest mr) {
		String sql = "insert into board values(board_seq.nextval,?,?,?,?,SYSDATE,?,?,?,?,?)";
		File file = mr.getFile("filename");
		int filesize = 0;
		if(file != null) {filesize = (int)file.length();}
		return jdbcTemplate.update(sql, mr.getParameter("writer"), mr.getParameter("email"), mr.getParameter("subject"),
				mr.getParameter("passwd"), 0, mr.getParameter("content"), mr.getParameter("ip"), mr.getFilesystemName("filename"),
				filesize);
	}

	@Override
	public int updatetBoard(int num, String writer, String subject, String email, String content) {
		String sql = "update board set writer=?, subject=?,"
				+ "email=?, content=? where num=?";
		return jdbcTemplate.update(sql, writer, subject, email, content, num);
	}

	@Override
	public int updatetBoard_readcount(int num, int readcount) {
		String sql = "update board set readcount=? where num=?";
		return jdbcTemplate.update(sql, readcount+1, num);
	}	
	
	class MyRowMapper implements RowMapper<BoardDTO>{
		@Override
		public BoardDTO mapRow(ResultSet rs, int cnt) throws SQLException {
			BoardDTO dto = new BoardDTO();
			dto.setNum(rs.getInt("num"));
			dto.setWriter(rs.getString("writer"));
			dto.setEmail(rs.getString("email"));
			dto.setSubject(rs.getString("subject"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setReg_date(rs.getString("reg_date"));
			dto.setReadcount(rs.getInt("readcount"));
			dto.setContent(rs.getString("content"));
			dto.setIp(rs.getString("ip"));
			dto.setFilename(rs.getString("filename"));
			dto.setFilesize(rs.getInt("filesize"));			
			return dto;
		}		
	}
	
	@Override
	public List<BoardDTO> listBoard() {
		String sql = "select * from board"; 
		MyRowMapper rowMapper = new MyRowMapper();
		List<BoardDTO> dto = jdbcTemplate.query(sql, rowMapper);
		return dto;
	}

	@Override
	public List<BoardDTO> listBoard_View(int num_select) {
		String sql = "select * from board where num=?";
		MyRowMapper rowMapper = new MyRowMapper();
		List<BoardDTO> dto = jdbcTemplate.query(sql, rowMapper, num_select);
		return dto;
	}

	

	@Override
	public int deleteBoard(int num) {
		String sql = "delete from board where num=?";		
		return jdbcTemplate.update(sql,num);
	}

}
