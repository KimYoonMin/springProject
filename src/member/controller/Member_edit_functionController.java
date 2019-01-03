package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;

public class Member_edit_functionController implements Controller {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		int no = Integer.parseInt(req.getParameter("no"));
		String name= req.getParameter("name");
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String hp1 = req.getParameter("hp1");
		String hp2 = req.getParameter("hp2");
		String hp3 = req.getParameter("hp3");
		String joindate = req.getParameter("joindate");
		
		int res = memberDAO.editMember(email, hp1, hp2, hp3, no);
		if(res>0) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("edit", "success");
			mav.setViewName("WEB-INF/member/member_edit_function.jsp");
			return mav;
		}else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("edit", null);
			mav.setViewName("WEB-INF/member/member_edit_function.jsp");
			return mav;
		}
		 
		
	}

}
