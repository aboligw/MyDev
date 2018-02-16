package com.project.vidyabhavan.online.presentation;

import com.project.vb.common.BeanGetter;
import com.project.vb.model.Teacher;
import com.project.vb.presentation.NoticeBD;
import com.project.vb.presentation.StudentBD;
import com.project.vb.presentation.TeaSubBD;
import com.project.vidyabhavan.online.presentation.Common.JavaClasses.CommonUtils;
import com.project.vidyabhavan.online.presentation.Common.JavaClasses.OnlineConstants;

import java.io.IOException;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FillNoticeServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=EUC-KR";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        HttpSession s = request.getSession(false);
        String uri = "Teacher-Func-HTML/Notice/insNotice.jsp";
        String message = " ";
        String link = " ";
        if (null != s.getAttribute(OnlineConstants.USER)) {
            Teacher t = (Teacher) s.getAttribute(OnlineConstants.USER);
            int teacherId = t.getId();
            TeaSubBD tsBdObj = BeanGetter.getBean("teaSubBD", TeaSubBD.class);
            int subjectId = tsBdObj.select(teacherId);
            String dateStr = request.getParameter("date");
            Date date = CommonUtils.formatDate(dateStr);
            int criteria = Integer.parseInt(request.getParameter("criteria"));
            String text = request.getParameter("text");
            List<Integer> list = getEligibleRollnoList(request, criteria);

            NoticeBD bdObj = BeanGetter.getBean("noticeBD", NoticeBD.class);
            boolean result = bdObj.insert(subjectId, text, date, list);

            if (result) {
                message = "This notice sent successfully";
            } else {
                message = "This notice was NOT sent successfully.";
                uri = "Error-HTML/errorPage.jsp";
            }
            link = "Teacher-Func-HTML/Menu/menuPage.jsp";

        }
        request.setAttribute("message", message);
        request.setAttribute("link", link);
        RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
        dispatcher.forward(request, response);
    }

    private List<Integer> getEligibleRollnoList(HttpServletRequest request, int criteria) {
        int classNo = 0;
        StudentBD studentBdObj = BeanGetter.getBean("studentBD", StudentBD.class);
        List<Integer> list = new ArrayList<Integer>();
        switch (criteria) {
        case 1:
            //student
            list.add(Integer.parseInt(request.getParameter("rollNo")));
            break;
        case 2:
            //class
            classNo = Integer.parseInt(request.getParameter("classNo"));
            list = studentBdObj.getStudFromSchool(classNo);
            break;
        case 3:
            //school
            list = studentBdObj.getStudFromSchool(classNo);
            break;
        }
        return list;
    }
}
