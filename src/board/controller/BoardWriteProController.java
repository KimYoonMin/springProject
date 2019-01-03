package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.oreilly.servlet.MultipartRequest;

import board.dao.BoardDAO;

public class BoardWriteProController implements Controller{
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		MultipartRequest mr = null;
		String upPath ="C:\\study3\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\springProject\\WEB-INF\\board\\images";
		int len = 10*1024*1024;
		mr = new MultipartRequest(req,upPath,len,"EUC-KR");
		if(mr==null) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("mrcheck", "error");
			mav.setViewName("redirect:WEB-INF/board/writePro.jsp");
			return mav;
		}
		int res = boardDAO.insertBoard(mr);
		if(res>0) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("write", "success");
			mav.setViewName("WEB-INF/board/writePro.jsp");
			return mav;
		}else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("write", null);
			mav.setViewName("WEB-INF/board/writePro.jsp");
			return mav;
		}		
		
	}

}
