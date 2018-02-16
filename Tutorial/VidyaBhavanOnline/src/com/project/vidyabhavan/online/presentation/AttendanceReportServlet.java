package com.project.vidyabhavan.online.presentation;

import com.project.vb.common.BeanGetter;
import com.project.vb.model.Teacher;
import com.project.vb.output.AttendanceReport;
import com.project.vb.presentation.AttendanceBD;
import com.project.vidyabhavan.online.presentation.Common.JavaClasses.OnlineConstants;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(name = "AttendanceReportServlet", urlPatterns = { "/attendancereport" })
public class AttendanceReportServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=EUC-KR";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        HttpSession s = request.getSession(false);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>AttendanceReportServlet</title></head>");
        out.println("<body>");
        out.println("<style>");
        out.println("table, th, td {");
        out.println("    border: 1px solid black;");
        out.println("    border-collapse: collapse;");
        out.println("}");
        out.println("</style>");
        Teacher t = (Teacher) s.getAttribute(OnlineConstants.USER);
        if (null != t) {
            int teacherId = t.getId();
            int classId = Integer.parseInt(request.getParameter("classNo"));
            int lecId = Integer.parseInt(request.getParameter("lecNo"));
            AttendanceBD bdObj = BeanGetter.getBean("attendanceBD", AttendanceBD.class);
            List<AttendanceReport> list = new ArrayList<AttendanceReport>();
            list = bdObj.select(classId, lecId, teacherId);
            out.println("<p><table>");
            out.println("<th>RollNo</th>");
            out.println("<th>Name</th>");
            out.println("<th>Status</th>");
            for (AttendanceReport x : list) {
                out.println("<tr>");

                out.println("<td>");
                out.println(x.getRollNo());
                out.println("</td>");

                out.println("<td>");
                out.println(x.getName());
                out.println("</td>");

                out.println("<td>");
                out.println(x.getStatus());
                out.println("</td>");
            }
            out.println("</table></p><br/><br/>");
            out.println("<p><a  href='" + "Teacher-Func-HTML/Menu/menuPage.jsp" + "'>Teacher Menu</a>");
        } else {
            out.println("<p>Please login first.</p>");
            out.println("<p><a  href='" + "Common-HTML/login.jsp" + "'>Login </a>");
        }
        out.println("</body></html>");
        out.close();
    }
}
