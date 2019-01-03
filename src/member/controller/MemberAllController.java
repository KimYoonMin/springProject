package member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberAllController implements Controller {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		String mode = req.getParameter("mode");
		if(mode==null){
			mode = "all";
		}
		List<MemberDTO> dto = memberDAO.listMember();
		
		if(mode.equals("all")){
			ModelAndView mav = new ModelAndView();
			mav.addObject("mode", "all");
			mav.addObject("list", dto);
			mav.setViewName("WEB-INF/member/memberAll.jsp");
			return mav;
		}else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("mode", null);
			mav.addObject("list", dto);
			mav.setViewName("WEB-INF/member/memberAll.jsp");
			return mav;
		}
		
		 
		
	}

}
