package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;

public class Member_deleteController implements Controller {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		String no_imsi = req.getParameter("no");
		if(no_imsi == null || no_imsi.trim().equals("")){
			ModelAndView mav = new ModelAndView();
			mav.addObject("check", "error");
			mav.setViewName("WEB-INF/member/member_delete.jsp");
			return mav;
		}
		int no = Integer.parseInt(no_imsi);	
		int res = memberDAO.deleteMember(no);
		if(res>0) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("delete", "success");
			mav.setViewName("WEB-INF/member/member_delete.jsp");
			return mav;
		}else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("delete", null);
			mav.setViewName("WEB-INF/member/member_delete.jsp");
			return mav;
		}
		
	}

}
