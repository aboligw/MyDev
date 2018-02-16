package com.project.vidyabhavan.online.presentation;

import com.project.vb.common.BeanGetter;
import com.project.vb.model.Teacher;
import com.project.vb.presentation.ExamBD;
import com.project.vb.presentation.TeaSubBD;
import com.project.vidyabhavan.online.presentation.Common.JavaClasses.OnlineConstants;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(name = "FillTestServlet", urlPatterns = { "testDetails" })
public class FillTestServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=EUC-KR";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        //NO ERROR POSSIBLE COZ BD METHOD IS RETURNING VOID :-(
        HttpSession s = request.getSession(false);
        String uri = "Teacher-Func-HTML/Notice/insTest.jsp";
        String message = " ";
        String link = " ";
        if (null != s.getAttribute(OnlineConstants.USER)) {
            Teacher t = (Teacher) s.getAttribute(OnlineConstants.USER);
            TeaSubBD tsBdObj = BeanGetter.getBean("teaSubBD", TeaSubBD.class);
            int teacherId = t.getId();
            int subId = tsBdObj.select(teacherId);
            int classId = Integer.parseInt(request.getParameter("class"));
            int totMks = Integer.parseInt(request.getParameter("totMks"));

            ExamBD examBdObj = BeanGetter.getBean("examBD", ExamBD.class);
            examBdObj.insert(subId, totMks, classId);
            message = "Saved this test.";
            link = "Teacher-Func-HTML/Menu/menuPage.jsp";
        }
        request.setAttribute("message", message);
        request.setAttribute("link", link);
        RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
        dispatcher.forward(request, response);
    }
}
