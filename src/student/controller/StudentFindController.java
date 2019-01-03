package student.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import student.dao.StudentDAO;
import student.dto.StudentDTO;

public class StudentFindController implements Controller {
	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		String name = req.getParameter("name");
		List<StudentDTO>findStudent =  studentDAO.findStudent(name);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", findStudent);
		mav.setViewName("list");
		return mav;
	}

}
