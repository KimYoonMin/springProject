package student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import student.dao.StudentDAO;
import student.dto.StudentDTO;

public class StudentInsertController implements Controller{
	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("EUC-KR");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String cname = req.getParameter("cname");
		if(id == null || id.trim().equals("")||name == null || name.trim().equals("")||cname == null || cname.trim().equals("")) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("check", "check");
			mav.setViewName("insert");
			/*mav.setViewName("WEB-INF/student/insert.jsp");*/
			return mav;			
		}
		
		StudentDTO dto = new StudentDTO(id, name, cname);
		int res = studentDAO.insertStudent(dto);
		if(res>0) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("insert", "success");
			mav.setViewName("insert");
			/*mav.setViewName("WEB-INF/student/insert.jsp");*/
			return mav;
		}else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("insert", null);
			mav.setViewName("insert");
			/*mav.setViewName("WEB-INF/student/insert.jsp");*/
			return mav;
		}
		
		
	}
}
