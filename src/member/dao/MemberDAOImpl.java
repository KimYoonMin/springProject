package member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import member.dto.MemberDTO;
import student.dto.StudentDTO;

public class MemberDAOImpl implements MemberDAO{
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public boolean checkMember(String name, String ssn1, String ssn2) {
		String sql = "select name from jsp_member where ssn1=? and ssn2=?";
		int res = jdbcTemplate.update(sql, name, ssn1, ssn2);
		if(res>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int insertMember(String name, String id, String passwd, String ssn1, String ssn2, String email, String hp1,
			String hp2, String hp3, String joindate) {
		String sql = "insert into jsp_member values(member_seq.nextval,?,?,?,?,?,?,?,?,?,SYSDATE)";
		return jdbcTemplate.update(sql, name, id, passwd, ssn1, ssn2, email, hp1, hp2, hp3, joindate);
	}

	class MyRowMapper implements RowMapper<MemberDTO>{
		@Override
		public MemberDTO mapRow(ResultSet rs, int cnt) throws SQLException {
			MemberDTO dto = new MemberDTO();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setId(rs.getString("id"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setSsn1(rs.getString("ssn1"));
			dto.setSsn2(rs.getString("ssn2"));
			dto.setEmail(rs.getString("email"));
			dto.setHp1(rs.getString("hp1"));
			dto.setHp2(rs.getString("hp2"));
			dto.setHp3(rs.getString("hp3"));
			dto.setJoindate(rs.getString("joindate"));			
			return dto;
		}		
	}
	
	@Override
	public List<MemberDTO> listMember() {
		String sql = "select * from jsp_member";
		MyRowMapper rowMapper = new MyRowMapper();
		List<MemberDTO> memberList = jdbcTemplate.query(sql, rowMapper);
		return memberList;
	}

	@Override
	public int deleteMember(int no) {
		String sql = "delete from jsp_member where no=?";
		return jdbcTemplate.update(sql, no);
	}

	@Override
	public int editMember(String email, String hp1, String hp2, String hp3, int no) {
		String sql = "update jsp_member set email=?, hp1=?, hp2=?, hp3=? where no=?";
		return jdbcTemplate.update(sql, email, hp1, hp2, hp3, no);
	}

}
