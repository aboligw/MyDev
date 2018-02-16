
package com.project.vidyabhavan.online.presentation.Common;

import com.project.vb.common.BeanGetter;
import com.project.vb.common.JavaConstants;
import com.project.vb.model.Student;
import com.project.vb.model.Teacher;
import com.project.vb.presentation.LoginBD;
import com.project.vb.presentation.StudentBD;
import com.project.vb.presentation.TeacherBD;
import com.project.vidyabhavan.online.presentation.Common.JavaClasses.OnlineConstants;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=EUC-KR";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);

        LoginBD bdObj = BeanGetter.getBean("loginBD", LoginBD.class);
        String role = request.getParameter("roleSelect");
        String userName = request.getParameter("uName");

        boolean x = bdObj.select(userName, request.getParameter("password"), role);
        String destUrl = "Common-HTML/login.jsp";
        String message = " Login failed!!!";
        if (x) {
            HttpSession s = request.getSession(true);
            s.setAttribute(OnlineConstants.ROLE, role);

            if (JavaConstants.STUDENT.equals(role)) {
                StudentBD studentBdObj = BeanGetter.getBean("studentBD", StudentBD.class);
                Student stud = studentBdObj.selectStudentRollNo(userName);
                s.setAttribute(OnlineConstants.USER, stud);
                destUrl = "Student-Func-HTML/studMenuPage.jsp";
            } else if (JavaConstants.TEACHER.equals(role)) {
                TeacherBD teacherBdObj = BeanGetter.getBean("teacherBD", TeacherBD.class);
                Teacher t = teacherBdObj.select(userName, 0, null);
                s.setAttribute(OnlineConstants.USER, t);
                destUrl = "Teacher-Func-HTML/Menu/menuPage.jsp";
            }
            message = " Login successful!!!";
        }
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher(destUrl);
        dispatcher.forward(request, response);
    }
}
