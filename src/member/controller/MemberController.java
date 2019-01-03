package member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

@Controller
public class MemberController {
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping(value="/checkMember_example.mem")
	public String check(HttpServletRequest req, @RequestParam String name, String ssn1, String ssn2) throws Exception {		
		if(name == null || name.trim().equals("")||ssn1 == null || ssn1.trim().equals("")||
				ssn2 == null || ssn2.trim().equals("")){			
			return "WEB-INF/member/memberSsn.jsp";
		}
		
		boolean isMember = memberDAO.checkMember(name,ssn1,ssn2);
		if(isMember) {			
			req.setAttribute("isMember", "true");
			return "WEB-INF/member/checkMember_example.jsp";
		}else {			
			req.setAttribute("isMember", null);
			return	"WEB-INF/member/checkMember_example.jsp";
		}
	}
	
	@RequestMapping(value="/member_delete.mem")
	public String delete(HttpServletRequest req) throws Exception {
		String no_imsi = req.getParameter("no");
		if(no_imsi == null || no_imsi.trim().equals("")){
			req.setAttribute("check", "error");
			return "WEB-INF/member/member_delete.jsp";
		}
		int no = Integer.parseInt(no_imsi);	
		int res = memberDAO.deleteMember(no);
		if(res>0) {
			req.setAttribute("delete", "success");
			return "WEB-INF/member/member_delete.jsp";
		}else {
			req.setAttribute("delete", null);
			return "WEB-INF/member/member_delete.jsp";
		}
	}
	
	@RequestMapping(value="/member_edit_function.mem")
	public String edit_function(HttpServletRequest req, @RequestParam int no, String name, String id, String email,
			String hp1, String hp2, String hp3, String joindate) throws Exception {
		/*int no = Integer.parseInt(req.getParameter("no"));
		String name= req.getParameter("name");
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String hp1 = req.getParameter("hp1");
		String hp2 = req.getParameter("hp2");
		String hp3 = req.getParameter("hp3");
		String joindate = req.getParameter("joindate");*/
		
		int res = memberDAO.editMember(email, hp1, hp2, hp3, no);
		if(res>0) {
			req.setAttribute("edit", "success");
			return "WEB-INF/member/member_edit_function.jsp";
		}else {
			req.setAttribute("edit", null);
			return "WEB-INF/member/member_edit_function.jsp";
		}
	}
	
	@RequestMapping(value="/member_edit.mem")
	public String edit(HttpServletRequest req, @RequestParam int no, String name, String id, String email,
			String hp1, String hp2, String hp3, String joindate) throws Exception {
		/*int no = Integer.parseInt(req.getParameter("no"));
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String hp1 = req.getParameter("hp1");
		String hp2 = req.getParameter("hp2");
		String hp3 = req.getParameter("hp3");
		String joindate = req.getParameter("joindate");*/
		MemberDTO dto = new MemberDTO(no, name, id, null, null, null, email, hp1, hp2, hp3, joindate);
		req.setAttribute("dto", dto);
		return "WEB-INF/member/member_edit.jsp";
	}
	
	@RequestMapping(value="/member_input.mem")
	public String input(HttpServletRequest req, @RequestParam int no, String name, String id, String email,
			String hp1, String hp2, String hp3, String joindate, String passwd, String ssn1, String ssn2) throws Exception {
		/*String name = req.getParameter("name");
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String ssn1 = req.getParameter("ssn1");
		String ssn2 = req.getParameter("ssn2");
		String email = req.getParameter("email");
		String hp1 = req.getParameter("hp1");
		String hp2 = req.getParameter("hp2");
		String hp3 = req.getParameter("hp3");
		String joindate = req.getParameter("joindate");*/
		
		int res = memberDAO.insertMember(name, id, passwd, ssn1, ssn2, email, hp1, hp2, hp3, joindate);
		if(res>0) {
			req.setAttribute("insert", "success");
			return "WEB-INF/member/member_input.jsp";
		}else {
			req.setAttribute("insert", null);
			return "WEB-INF/member/member_input.jsp";
		}
	}
	
	@RequestMapping(value="/memberAll.mem")
	public String memberAll(HttpServletRequest req, @RequestParam String mode) throws Exception {
		/*String mode = req.getParameter("mode");*/
		if(mode==null){
			mode = "all";
		}
		List<MemberDTO> dto = memberDAO.listMember();
		
		if(mode.equals("all")){
			req.setAttribute("mode", "all");
			req.setAttribute("list", dto);
			return "WEB-INF/member/memberAll.jsp";
		}else {
			req.setAttribute("mode", null);
			req.setAttribute("list", dto);
			return "WEB-INF/member/memberAll.jsp";
		}
	}
	
	@RequestMapping(value="/memberSsn.mem")
	public String memberSsn(HttpServletRequest req) throws Exception {
		return "WEB-INF/member/memberSsn.jsp";
	}
	
	@RequestMapping(value="/member.mem")
	public String member(HttpServletRequest req) throws Exception {
		String name = req.getParameter("name");
		String ssn1 = req.getParameter("ssn1");
		String ssn2 = req.getParameter("ssn2");
		if(name == null || name.trim().equals("")||ssn1 == null || ssn1.trim().equals("")||
				ssn2 == null || ssn2.trim().equals("")){
			return "WEB-INF/member/memberSsn.jsp";
		}
		req.setAttribute("name", name);
		req.setAttribute("ssn1", ssn1);
		req.setAttribute("ssn2", ssn2);
		return "WEB-INF/member/member.jsp";
	}
}
