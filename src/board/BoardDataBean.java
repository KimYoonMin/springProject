package board;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;

import board.ConnectionPoolBean;


public class BoardDataBean {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	

	public BoardDataBean() {}
	
	/*private ConnectionPoolBean pool;
	
	public void setPool(ConnectionPoolBean pool) {
		this.pool = pool;
	}*/
	
	static DataSource ds;
	static {
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/oracle");			
		}catch(NamingException e) {
			System.out.println("lookup½ÇÆÐ : " + e.getMessage());
		}
	}
	
	public int insertBoard(MultipartRequest mr) throws SQLException{
		/*String writer, String email, String passwd ,String subject, String content, String ip*/
		try {
			con = ds.getConnection();
			String sql = "insert into board values(board_seq.nextval,?,?,?,?,SYSDATE,?,?,?,?,?)";
			ps = con.prepareStatement(sql);			
			ps.setString(1, mr.getParameter("writer"));			
			ps.setString(2, mr.getParameter("email"));			
			ps.setString(3, mr.getParameter("subject"));
			ps.setString(4, mr.getParameter("passwd"));
			ps.setInt(5, 0);
			ps.setString(6, mr.getParameter("content"));
			ps.setString(7, mr.getParameter("ip"));
			ps.setString(8, mr.getFilesystemName("filename"));
			File file = mr.getFile("filename");
			int filesize = 0;
			if(file != null) {filesize = (int)file.length();}
			ps.setInt(9, filesize);
			int res = ps.executeUpdate();
			return res;
		}finally{
			if(ps != null)ps.close();
			if(con != null)con.close();
		}
	}
	public int updatetBoard(int num, String writer, String subject, String email, String content) throws SQLException{
		try {
			con = ds.getConnection();
			String sql = "update board set writer=?, subject=?,"
					+ "email=?, content=? where num=?";
			ps = con.prepareStatement(sql);			
						
			ps.setString(1, writer);			
			ps.setString(2, subject);			
			ps.setString(3, email);
			ps.setString(4, content);			
			ps.setInt(5, num);
			int res = ps.executeUpdate();
			return res;
		}finally{
			if(ps != null)ps.close();
			if(con != null)con.close();
		}
	}
	
	public int updatetBoard_readcount(int num, int readcount) throws SQLException{
		try {
			con = ds.getConnection();
			String sql = "update board set readcount=? where num=?";
			ps = con.prepareStatement(sql);			
						
			ps.setInt(1, ++readcount);			
			ps.setInt(2, num);			
			int res = ps.executeUpdate();
			return res;
		}finally{
			if(ps != null)ps.close();
			if(con != null)con.close();
		}
	}
	
	public BoardDBBean[] listBoard() throws SQLException{
		try {
			con = ds.getConnection();
		String sql = "select * from board";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		BoardDBBean[] dto = makeArray(rs);
		return dto;
		}finally {
			if(rs != null)rs.close();
			if(ps != null)ps.close();
			if(con != null)con.close();
		}
	}
	
	public BoardDBBean listBoard_View(int num_select) throws SQLException{
		try {
			con = ds.getConnection();
		String sql = "select * from board where num=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, num_select);
		rs = ps.executeQuery();
		BoardDBBean dto = null;
		while(rs.next()) {
			int num = rs.getInt("num");
			String writer = rs.getString("writer");
			String email = rs.getString("email");			
			String subject = rs.getString("subject");
			String passwd = rs.getString("passwd");
			String reg_date = rs.getString("reg_date");
			int readcount = rs.getInt("readcount");
			String content = rs.getString("content");
			String ip = rs.getString("ip");
			String filename = rs.getString("filename");
			int filesize = rs.getInt("filesize");
		
			dto = new BoardDBBean(num, writer, email,subject,passwd,reg_date,readcount,
					content,ip,filename,filesize);
		}
		
		return dto;
		}finally {
			if(rs != null)rs.close();
			if(ps != null)ps.close();
			if(con != null)con.close();
		}
	}
	
	
	
	/*public ProductDTO[] listProduct_Category(int category) throws SQLException{
		try {
			con = pool.getConnection();
		String sql = "select * from product where pcategory_fk like ? || '%'";
		ps = con.prepareStatement(sql);
		ps.setInt(1, category);
		rs = ps.executeQuery();
		ProductDTO[] dto = makeArray(rs);		
		return dto;
		}finally {
			if(rs != null)rs.close();
			if(ps != null)ps.close();
			if(con != null)pool.returnConnection(con);
		}
	}*/

	protected BoardDBBean[] makeArray(ResultSet rs) throws SQLException{
		ArrayList<BoardDBBean>list = new ArrayList<>();
		while(rs.next()) {
			int num = rs.getInt("num");
			String writer = rs.getString("writer");
			String email = rs.getString("email");			
			String subject = rs.getString("subject");
			String passwd = rs.getString("passwd");
			String reg_date = rs.getString("reg_date");
			int readcount = rs.getInt("readcount");
			String content = rs.getString("content");
			String ip = rs.getString("ip");
			String filename = rs.getString("filename");
			int filesize = rs.getInt("filesize");
			
			BoardDBBean dto = new BoardDBBean(num, writer, email,subject,passwd,reg_date,readcount,
					content,ip,filename,filesize);
			list.add(dto);
		}
		BoardDBBean[] sdto = new BoardDBBean[list.size()];
		list.toArray(sdto);
		return sdto;
	}
	
	public int deleteBoard(int num)throws SQLException{
		try {
			con = ds.getConnection();
			String sql = "delete from board where num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			int res = ps.executeUpdate();
			return res;
		}finally {
			if(ps != null)ps.close();
			if(con != null)con.close();
		}
	}
}
