package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class BoardDeleteFormController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		int num = Integer.parseInt(req.getParameter("num"));
		String filename = req.getParameter("filename");
		ModelAndView mav = new ModelAndView();
		mav.addObject("num", num);
		mav.addObject("filename", filename);
		mav.setViewName("WEB-INF/board/deleteForm.jsp");
		return mav;
	}

}
