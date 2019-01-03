package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;

public class CheckMember_exampleController implements Controller {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		String name = req.getParameter("name");
		String ssn1 = req.getParameter("ssn1");
		String ssn2 = req.getParameter("ssn2");
		if(name == null || name.trim().equals("")||ssn1 == null || ssn1.trim().equals("")||
				ssn2 == null || ssn2.trim().equals("")){
			return new ModelAndView("WEB-INF/member/memberSsn.jsp");
		}
		
		boolean isMember = memberDAO.checkMember(name,ssn1,ssn2);
		if(isMember) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("isMember", "true");
			mav.setViewName("WEB-INF/member/checkMember_example.jsp");
			return mav;
		}else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("isMember", null);
			mav.addObject("name", name);
			mav.addObject("ssn1", ssn1);
			mav.addObject("ssn2", ssn2);
			mav.setViewName("WEB-INF/member/checkMember_example.jsp");
			return mav;
		}
	}

}
