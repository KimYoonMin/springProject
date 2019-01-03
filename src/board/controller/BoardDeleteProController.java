package board.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class BoardDeleteProController implements Controller{
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		int num = Integer.parseInt(req.getParameter("num"));
		String filename = req.getParameter("filename");		
		String passwd = req.getParameter("passwd");
		List<BoardDTO> dto = boardDAO.listBoard_View(num);
		if(dto.get(0).getPasswd().equals(passwd)){
			String upPath = "C:\\study3\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\springProject\\WEB-INF\\board\\images";
			File file = new File(upPath+"/"+dto.get(0).getFilename());     
		    if( file.exists() ){
		        if(file.delete()){
		            System.out.println("파일삭제 성공");
		        }else{
		            System.out.println("파일삭제 실패");
		        }
		    }else{
		        System.out.println("파일이 존재하지 않습니다.");
		    }
				
			int res = boardDAO.deleteBoard(num);
			if(res>0) {
				ModelAndView mav = new ModelAndView();
				mav.addObject("delete", "success");
				mav.setViewName("WEB-INF/board/deletePro.jsp");
				System.out.println("1");
				return mav;
			}else {
				ModelAndView mav = new ModelAndView();
				mav.addObject("delete", null);
				mav.setViewName("WEB-INF/board/deletePro.jsp");
				System.out.println("2");
				return mav;
			}
		}else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("check", "error");
			mav.setViewName("WEB-INF/board/deletePro.jsp");
			return mav;
		}
		
	}

}
