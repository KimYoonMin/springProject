package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dto.MemberDTO;

public class Member_editController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		int no = Integer.parseInt(req.getParameter("no"));
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String hp1 = req.getParameter("hp1");
		String hp2 = req.getParameter("hp2");
		String hp3 = req.getParameter("hp3");
		String joindate = req.getParameter("joindate");
		MemberDTO dto = new MemberDTO(no, name, id, null, null, null, email, hp1, hp2, hp3, joindate);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.setViewName("WEB-INF/member/member_edit.jsp");
		return mav;
	}

}
