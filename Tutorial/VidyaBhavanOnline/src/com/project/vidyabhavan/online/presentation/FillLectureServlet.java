package com.project.vidyabhavan.online.presentation;

import com.project.vb.common.BeanGetter;
import com.project.vb.model.Teacher;
import com.project.vb.presentation.LectureBD;
import com.project.vb.presentation.TeaSubBD;
import com.project.vidyabhavan.online.presentation.Common.JavaClasses.CommonUtils;
import com.project.vidyabhavan.online.presentation.Common.JavaClasses.OnlineConstants;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(name = "FillLectureServlet", urlPatterns = { "lectureDetail" })
public class FillLectureServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=EUC-KR";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        HttpSession s = request.getSession(false);
        PrintWriter out = response.getWriter();
        String link = " ";
        int lecNo = 0;
        String uri = "Teacher-Func-HTML/Insert/lecDataInsOutput.jsp";
        String message = " ";
        if (null != s.getAttribute(OnlineConstants.USER)) {
            Teacher t = (Teacher) s.getAttribute(OnlineConstants.USER);
            TeaSubBD tsBdObj = BeanGetter.getBean("teaSubBD", TeaSubBD.class);
            int teacherId = t.getId();
            int subId = tsBdObj.select(teacherId);
            int classId = Integer.parseInt(request.getParameter("classNo"));
            int duration = Integer.parseInt(request.getParameter("duration"));
            String dateStr = request.getParameter("dateOfLec");
            Date dateOfLec = CommonUtils.formatDate(dateStr);

            LectureBD lectureBdObj = BeanGetter.getBean("lectureBD", LectureBD.class);
            lecNo = lectureBdObj.insert(subId, classId, teacherId, duration, dateOfLec, lecNo);
            link = "Teacher-Func-HTML/Menu/menuPage.jsp";
            if (lecNo == 0) {
                message = "This Lecture is NOT saved in Database.Try Again!";
                uri = "Error-HTML/errorPage.jsp";
            }
        }
        request.setAttribute("message", message);
        request.setAttribute("outputNumber", lecNo);
        request.setAttribute("link", link);
        RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
        dispatcher.forward(request, response);
    }

}
