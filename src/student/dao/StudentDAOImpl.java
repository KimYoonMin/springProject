package student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import javax.swing.tree.TreePath;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import student.dto.StudentDTO;

public class StudentDAOImpl implements StudentDAO{
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertStudent(StudentDTO dto) {		
		return jdbcTemplate.update("insert into student values(?,?,?)",dto.getId(),dto.getName(),dto.getCname());
	}

	@Override
	public int deleteStudent(String id) {
		return jdbcTemplate.update("delete from student where id=?", id);
	}
	
	
	class MyRowMapper implements RowMapper<StudentDTO>{
		@Override
		public StudentDTO mapRow(ResultSet rs, int cnt) throws SQLException {
			StudentDTO dto = new StudentDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setCname(rs.getString("cname"));
			return dto;
		}		
	}
	
	@Override
	public List<StudentDTO> findStudent(String name) {
		String sql = "select * from student where name=?";
		MyRowMapper rowMapper = new MyRowMapper();
		List<StudentDTO> studentList = jdbcTemplate.query(sql, rowMapper,name);
		return studentList;
	}

	@Override
	public List<StudentDTO> listStudent() {
		String sql = "select * from student";
		MyRowMapper rowMapper = new MyRowMapper();
		List<StudentDTO> studentList = jdbcTemplate.query(sql, rowMapper);
		return studentList;
		//jdbcTemplate.query(sql, rowMapper)
	}

}
