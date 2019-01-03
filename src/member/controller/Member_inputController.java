package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;

public class Member_inputController implements Controller {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}



	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String ssn1 = req.getParameter("ssn1");
		String ssn2 = req.getParameter("ssn2");
		String email = req.getParameter("email");
		String hp1 = req.getParameter("hp1");
		String hp2 = req.getParameter("hp2");
		String hp3 = req.getParameter("hp3");
		String joindate = req.getParameter("joindate");
		
		int res = memberDAO.insertMember(name, id, passwd, ssn1, ssn2, email, hp1, hp2, hp3, joindate);
		if(res>0) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("insert", "success");
			mav.setViewName("WEB-INF/member/member_input.mem");
			return mav;
		}else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("insert", null);
			mav.setViewName("WEB-INF/member/member_input.mem");
			return mav;
		}
		
	}

}
