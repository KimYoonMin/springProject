package student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import student.dao.StudentDAO;

public class StudentDeleteController implements Controller{
	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("EUC-KR");
		String id = req.getParameter("id");
		if(id == null || id.trim().equals("")) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("check", "check");
			mav.setViewName("delete");
			/*mav.setViewName("WEB-INF/student/delete.jsp");*/
			return mav;
		}
		int res = studentDAO.deleteStudent(id);
		if(res>0) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("delete", "delete");
			mav.setViewName("delete");
			/*mav.setViewName("WEB-INF/student/delete.jsp");*/
			return mav;
		}else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("delete", null);
			mav.setViewName("delete");
			/*mav.setViewName("WEB-INF/student/delete.jsp");*/
			return mav;
		}
		
	}

}
