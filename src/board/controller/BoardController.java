package board.controller;

import java.io.File;
import java.net.Inet4Address;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import board.mybatis.BoardMapper;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO boardDAO;

	/*public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}*/
	
	@RequestMapping(value="/context.brd")
	public String context(HttpServletRequest req, @RequestParam int num, int readcount, String filename) throws Exception{
		/*int num = Integer.parseInt(req.getParameter("num"));
		int readcount = Integer.parseInt(req.getParameter("readcount"));
		String filename = req.getParameter("filename");*/
		BoardDTO dto_test = new BoardDTO();
		dto_test.setNum(num);
		dto_test.setReadcount(readcount);
		BoardMapper.plusReadcount(dto_test); /*int res = boardDAO.updatetBoard_readcount(num, readcount);*/
		BoardDTO dto = BoardMapper.getBoard(num); /*boardDAO.listBoard_View(num);*/
		String upPath = "C:\\study3\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\springProject\\WEB-INF\\board\\images";
		if (dto != null || !(dto.equals(""))) {			
			req.setAttribute("filename", filename);
			req.setAttribute("upPath", upPath);
			req.setAttribute("dto", dto);
			return "WEB-INF/board/context.jsp";
		}
		return null;
	}
	
	@RequestMapping(value="/deleteForm.brd"/*method=RequestMethod.GET*/)
	public String deleteForm(HttpServletRequest req) throws Exception{
		int num = Integer.parseInt(req.getParameter("num"));
		String filename = req.getParameter("filename");		
		req.setAttribute("num", num);
		req.setAttribute("filename", filename);
		return "WEB-INF/board/deleteForm.jsp";
	}
	
	@RequestMapping(value="/deletePro.brd"/*method=RequestMethod.POST*/)
	public String deletePro(HttpServletRequest req, @RequestParam int num, String filename, String passwd) throws Exception{
		/*int num = Integer.parseInt(req.getParameter("num"));
		String filename = req.getParameter("filename");		
		String passwd = req.getParameter("passwd");*/
		List<BoardDTO> dto = BoardMapper.listBoard_View(num); 
				/*boardDAO.listBoard_View(num);*/
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
			int res = BoardMapper.deleteBoard(num);
			/*int res = boardDAO.deleteBoard(num);*/
			if(res>0) {				
				req.setAttribute("delete", "success");
				return "WEB-INF/board/deletePro.jsp";
			}else {				
				req.setAttribute("delete", null);
				return "WEB-INF/board/deletePro.jsp";
			}
		}else {
			req.setAttribute("check", "error");
			return "WEB-INF/board/deletePro.jsp";
		}
	}
	
	@RequestMapping(value="/list.brd")
	public String list(HttpServletRequest req) throws Exception {
		List<BoardDTO> dto = BoardMapper.listBoard();
				/*boardDAO.listBoard();; */
		req.setAttribute("list", dto);
		return "WEB-INF/board/list.jsp";
	}
	
	@RequestMapping(value="/updateForm.brd")
	public String updateForm(HttpServletRequest req, @RequestParam int num) throws Exception {
		/*int num = Integer.parseInt(req.getParameter("num"));*/
		List<BoardDTO> dto = BoardMapper.listBoard_View(num); 
				/*boardDAO.listBoard_View(num);*/
		if(dto != null || !(dto.equals(""))) {
			req.setAttribute("dto", dto.get(0));
			return "WEB-INF/board/updateForm.jsp";
		}
		return null;
	}
	
	@RequestMapping(value="/updatePro.brd")
	public String updatePro(HttpServletRequest req, @ModelAttribute BoardDTO dto /*@RequestParam String writer, String subject
			, String email, String content, String passwd, int num,*/) throws Exception {
		/*String writer = req.getParameter("writer");
		String subject = req.getParameter("subject");
		String email = req.getParameter("email");
		String content = req.getParameter("content");
		String passwd = req.getParameter("passwd");
		int num = Integer.parseInt(req.getParameter("num"));*/		 
		List<BoardDTO> dto_list = BoardMapper.listBoard_View(dto.getNum()); 
				/*boardDAO.listBoard_View(num);*/
		if(dto.getPasswd().equals(dto_list.get(0).getPasswd())) {
			int res = BoardMapper.updateBoard(dto); 
					/*boardDAO.updatetBoard(num, writer, subject, email, content);*/
			if(res>0) {
				req.setAttribute("update", "success");
				return "WEB-INF/board/updatePro.jsp";
			}else {
				req.setAttribute("update", null);
				return "WEB-INF/board/updatePro.jsp";
			}
		}else {
			req.setAttribute("check", "error");
			return "WEB-INF/board/updatePro.jsp";
		}
		
	}
	
	@RequestMapping(value="/writeForm.brd")
	public String writeForm(HttpServletRequest req) throws Exception {
		req.setCharacterEncoding("EUC-KR");
		String ip=Inet4Address.getLocalHost().getHostAddress();		
		/*return new ModelAndView("redirect:WEB-INF/board/writeForm.jsp");*/
		req.setAttribute("ip", ip);
		return "WEB-INF/board/writeForm.jsp";
	}
	
	@RequestMapping(value="/writePro.brd")
	public String writePro(HttpServletRequest req, @ModelAttribute BoardDTO dto, BindingResult result) throws Exception {
		 if (result.hasErrors()) {
	         dto.setFilename("");
	      }
		 dto.setEmail("");
		System.out.println(dto.getContent() + "/"+ dto.getEmail() + "/"+  dto.getFilename() + "/"+  dto.getFilesize() + "/"+  dto.getIp() + "/"+  dto.getNum() + "/"+  dto.getPasswd() + "/"+  dto.getReadcount() + "/"+  dto.getReg_date() + "/"+  dto.getSubject() + "/"+  dto.getWriter());
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
		MultipartFile mf = mr.getFile("filename");
		String filename = mf.getOriginalFilename();
		dto.setFilename(filename);
		if(filename == null || filename.trim().equals("")) {
			req.setAttribute("mrcheck", "error");
			return "WEB-INF/board/writePro.jsp";
		}
		HttpSession session = req.getSession();
		String upPath = session.getServletContext().getRealPath("/WEB-INF/board/images");
		File file = new File(upPath, filename);		
	      int filesize = (int) file.length();
	      dto.setFilesize(filesize);
	      System.out.println("filesize = " + dto.getFilesize());
		int res = BoardMapper.insertBoard(dto);
		/*int res = boardDAO.insertBoard(mr);*/
		if(res>0) {
			mf.transferTo(file);
			req.setAttribute("write", "success");
			return "WEB-INF/board/writePro.jsp";
		}else {
			req.setAttribute("write", null);
			return "WEB-INF/board/writePro.jsp";
		}		
		
	}
}
