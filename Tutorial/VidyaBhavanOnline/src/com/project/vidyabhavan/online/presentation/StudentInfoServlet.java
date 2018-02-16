package com.project.vidyabhavan.online.presentation;

import com.project.vb.common.BeanGetter;
import com.project.vb.model.Student;
import com.project.vb.presentation.StudentBD;
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


public class StudentInfoServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=EUC-KR";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        HttpSession s = request.getSession(false);
        String message = " ";
        String link = " ";
        String uri = "Teacher-Func-HTML/StudentInfo/studDataOutput.jsp";
        List<Student> list = new ArrayList<Student>();
        if (null != s.getAttribute(OnlineConstants.ROLE)) {
            int r = 0;
            String n = null;
            int c = 0;
            StudentBD studBdObj = BeanGetter.getBean("studentBD", StudentBD.class);

            switch (Integer.parseInt(request.getParameter("htmlName"))) {
            case 1:
                //roll no
                r = Integer.parseInt(request.getParameter("rollNo"));
                list = studBdObj.select(r, n, c);
                break;
            case 2:
                //nameclasss
                n = request.getParameter("name");
                c = Integer.parseInt(request.getParameter("class"));
                list = studBdObj.select(r, n, c);
                break;
            }
            if (list == null || list.isEmpty()) {
                message = "No such student in school. Please try again.";
                uri = "Error-HTML/errorPage.jsp";
            }
            link = "Teacher-Func-HTML/Menu/menuPage.jsp";
        }
        request.setAttribute("message", message);
        request.setAttribute("link", link);
        request.setAttribute("tabData", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
        dispatcher.forward(request, response);
    }
}
