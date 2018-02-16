package com.project.vidyabhavan.online.presentation;

import com.project.vb.common.BeanGetter;
import com.project.vb.model.Student;
import com.project.vb.output.MyAttendance;
import com.project.vb.presentation.AttendanceBD;
import com.project.vidyabhavan.online.presentation.Common.JavaClasses.OnlineConstants;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(name = "MyAttendanceServlet", urlPatterns = { "/myattendance" })
public class MyAttendanceServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=EUC-KR";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        String uri = "Student-Func-HTML/myAttendanceOutput.jsp";
        String message = " ";
        String link = " ";
        List<MyAttendance> outList = new ArrayList<MyAttendance>();
        HttpSession s = request.getSession(false);
        if (null != s.getAttribute(OnlineConstants.USER)) {
            Student stud = (Student) s.getAttribute(OnlineConstants.USER);
            int rollNo = stud.getId();
            AttendanceBD bdObj = BeanGetter.getBean("attendanceBD", AttendanceBD.class);
            outList = bdObj.selectStudAttendance(rollNo);
            link = "Student-Func-HTML/studMenuPage.jsp";
            if (outList == null || outList.isEmpty()) {
                message = "No Lectures attended YET!";
                uri = "Error-HTML/errorPage.jsp";
            }
        }
        request.setAttribute("link", link);
        request.setAttribute("message", message);
        request.setAttribute("list", outList);
        RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
        dispatcher.forward(request, response);
    }
}
