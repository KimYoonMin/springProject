package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class BoardUpdateProController implements Controller{
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		String writer = req.getParameter("writer");
		String subject = req.getParameter("subject");
		String email = req.getParameter("email");
		String content = req.getParameter("content");
		String passwd = req.getParameter("passwd");
		int num = Integer.parseInt(req.getParameter("num"));		 
		List<BoardDTO> dto = boardDAO.listBoard_View(num);
		if(passwd.equals(dto.get(0).getPasswd())) {
			int res = boardDAO.updatetBoard(num, writer, subject, email, content);
			if(res>0) {
				ModelAndView mav = new ModelAndView();
				mav.addObject("update", "success");
				mav.setViewName("WEB-INF/board/updatePro.jsp");
				return mav;
			}else {
				ModelAndView mav = new ModelAndView();
				mav.addObject("update", null);
				mav.setViewName("WEB-INF/board/updatePro.jsp");
				return mav;
			}
		}else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("check", "error");
			mav.setViewName("WEB-INF/board/updatePro.jsp");
			return mav;
		}
		
	}

}
