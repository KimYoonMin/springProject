package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MemberViewController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		String name = req.getParameter("name");
		String ssn1 = req.getParameter("ssn1");
		String ssn2 = req.getParameter("ssn2");
		if(name == null || name.trim().equals("")||ssn1 == null || ssn1.trim().equals("")||
				ssn2 == null || ssn2.trim().equals("")){
			return new ModelAndView("WEB-INf/member/memberSsn.mem");
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.addObject("ssn1", ssn1);
		mav.addObject("ssn2", ssn2);
		mav.setViewName("WEB-INF/member/member.jsp");
		return mav;
	}

}
