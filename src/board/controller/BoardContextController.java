package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class BoardContextController implements Controller {
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		int num = Integer.parseInt(req.getParameter("num"));
		int readcount = Integer.parseInt(req.getParameter("readcount"));
		String filename = req.getParameter("filename");
		int res = boardDAO.updatetBoard_readcount(num, readcount);
		List<BoardDTO> dto = boardDAO.listBoard_View(num);
		String upPath = "C:\\study3\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\springProject\\WEB-INF\\board\\images";
		if (dto != null || !(dto.equals(""))) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("filename", filename);
			mav.addObject("upPath", upPath);
			mav.addObject("dto", dto.get(0));
			mav.setViewName("WEB-INF/board/context.jsp");
			return mav;
		}
		
		return null;
	}

}
