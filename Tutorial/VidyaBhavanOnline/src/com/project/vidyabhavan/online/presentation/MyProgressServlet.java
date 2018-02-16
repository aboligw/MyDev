package com.project.vidyabhavan.online.presentation;

import com.project.vb.common.BeanGetter;
import com.project.vb.model.Student;
import com.project.vb.output.MyReport;
import com.project.vb.presentation.MarksBD;
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

//@WebServlet(name = "MyProgressServlet", urlPatterns = { "/myprogress" })
public class MyProgressServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=EUC-KR";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        String uri = "Student-Func-HTML/myProgressOutput.jsp";
        String message = " ";
        HttpSession s = request.getSession(false);
        List<MyReport> outList = new ArrayList<MyReport>();
        String link = " ";
        if (null != s.getAttribute(OnlineConstants.USER)) {
            Student stud = (Student) s.getAttribute(OnlineConstants.USER);
            int rollNo = stud.getId();

            MarksBD bdObj = BeanGetter.getBean("marksBD", MarksBD.class);
            outList = bdObj.studReportselect(rollNo);
            link = "Student-Func-HTML/studMenuPage.jsp";
            if (outList == null || outList.isEmpty()) {
                message = "No Test taken YET!";
                uri = "Error-HTML/errorPage.jsp";
            }
        }
        request.setAttribute("link", link);
        request.setAttribute("list", outList);
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
        dispatcher.forward(request, response);
    }
}
