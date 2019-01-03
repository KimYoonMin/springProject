package member.dao;

import java.util.List;

import member.dto.MemberDTO;

public interface MemberDAO {
	public boolean checkMember(String name, String ssn1, String ssn2);
	public int insertMember(String name, String id, String passwd, String ssn1,String ssn2, String email, String hp1, String hp2, String hp3, String joindate);
	public List<MemberDTO> listMember();	
	public int deleteMember(int no);
	public int editMember(String email, String hp1, String hp2, String hp3, int no);
	
}	
