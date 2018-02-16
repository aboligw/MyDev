package com.project.vidyabhavan.online.presentation;

import com.project.vidyabhavan.online.presentation.Common.JavaClasses.OnlineConstants;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(name = "StudentActionServlet", urlPatterns = { "/studentaction" })
public class StudentActionServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=EUC-KR";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);

        HttpSession s = request.getSession(false);
        String destUrl = "Student-Func-HTML/studMenuPage.jsp";
        if (null != s.getAttribute(OnlineConstants.USER)) {

            int criteria = Integer.parseInt(request.getParameter("func"));
            switch (criteria) {
            case 1:
                //attendance rep
                destUrl = "/myAttendance";
                break;
            case 2:
                //progress rep
                destUrl = "/myProgress";
                break;
            case 3:
                // notice
                destUrl = "/myNotice";
                break;
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(destUrl);
            dispatcher.forward(request, response);

        } /*else {
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>StudentActionServlet</title></head>");
            out.println("<body>");
            out.println("<p>Login first!!!.</p>");
            out.println("<p><a  href='" + "login.jsp" + "'>Login</a>");
            out.println("</body></html>");
            out.close();
        }*/
    }
}
