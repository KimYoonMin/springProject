package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class BoardUpdateFormController implements Controller {
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		int num = Integer.parseInt(req.getParameter("num"));
		List<BoardDTO> dto = boardDAO.listBoard_View(num);
		if(dto != null || !(dto.equals(""))) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("dto", dto.get(0));
			mav.setViewName("WEB-INF/board/updateForm.jsp");
			return mav;
		}
		return null;
	}

}
