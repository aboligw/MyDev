package com.project.vidyabhavan.online.presentation;

import com.project.vb.common.BeanGetter;
import com.project.vb.model.Teacher;
import com.project.vb.output.ProgressReport;
import com.project.vb.presentation.MarksBD;
import com.project.vb.presentation.TeaSubBD;
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

//@WebServlet(name = "ProgressReportServlet", urlPatterns = { "/progressreport" })
public class ProgressReportServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=EUC-KR";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>ProgressReportServlet</title></head>");
        out.println("<body>");
        out.println("<style>");
        out.println("table, th, td {");
        out.println("    border: 1px solid black;");
        out.println("    border-collapse: collapse;");
        out.println("}");
        out.println("</style>");
        HttpSession s = request.getSession(false);
        Teacher t = (Teacher) s.getAttribute(OnlineConstants.USER);
        if (t != null) {
            int teacherId = t.getId();
            TeaSubBD teaSubBdObj = BeanGetter.getBean("teaSubBD", TeaSubBD.class);
            int subId = teaSubBdObj.select(teacherId);
            int rollNo = Integer.parseInt(request.getParameter("rollNo"));

            MarksBD bdObj = BeanGetter.getBean("marksBD", MarksBD.class);
            List<ProgressReport> list = new ArrayList<ProgressReport>();
            list = bdObj.select(rollNo, subId);

            out.println("<p><table>");
            out.println("<th>RollNo</th>");
            out.println("<th>Name</th>");
            out.println("<th>Subject</th>");
            out.println("<th>Class#</th>");
            out.println("<th>Test#</th>");
            out.println("<th>Total Marks</th>");
            out.println("<th>Obtained Marks</th>");
            for (ProgressReport x : list) {
                out.println("<tr>");

                out.println("<td>");
                out.println(x.getRoll());
                out.println("</td>");

                out.println("<td>");
                out.println(x.getName());
                out.println("</td>");

                out.println("<td>");
                out.println(x.getSubject());
                out.println("</td>");

                out.println("<td>");
                out.println(x.getCls());
                out.println("</td>");

                out.println("<td>");
                out.println(x.getTestNo());
                out.println("</td>");

                out.println("<td>");
                out.println(x.getTotMks());
                out.println("</td>");

                out.println("<td>");
                out.println(x.getObtMks());
                out.println("</td>");

                out.println("</tr>");
            }
            out.println("</table></p><br/><br/>");
            out.println("<p><a  href='" + "Teacher-Func-HTML/Menu/menuPage.jsp" + "'>Teacher Menu</a>");
        } else {
            out.println("<p>Login first!!!.</p>");
            out.println("<p><a  href='" + "Common-HTML/login.jsp" + "'>Login</a>");
        }
        out.println("</body></html>");
        out.close();
    }
}
