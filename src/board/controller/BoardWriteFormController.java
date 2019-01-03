package board.controller;

import java.net.Inet4Address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class BoardWriteFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		req.setCharacterEncoding("EUC-KR");
		String ip=Inet4Address.getLocalHost().getHostAddress();		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ip", ip);
		mav.setViewName("WEB-INF/board/writeForm.jsp");
		return mav;
		/*return new ModelAndView("redirect:WEB-INF/board/writeForm.jsp");*/
	}

}
