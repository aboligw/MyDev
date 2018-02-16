package com.project.tutorial.webproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
    @SuppressWarnings("compatibility:-7906248755929692408")
    private static final long serialVersionUID = 88668685385810366L;
    private static final String CONTENT_TYPE = "text/html; charset=EUC-KR";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        ServletConfig c = getServletConfig();
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>HelloWorld</title></head>");
        out.println("<body>");
        out.println("<p>The servlet has received a GET. This is the reply.</p>");
        out.println(c.getInitParameter("MyText") + "<br>");
        out.println(request.getParameter("sName") + "<br>");
        out.println(request.getParameter("rollNo") + "<br>");
        out.println(request.getParameter("selectDt") + "<br>");
        out.println(request.getParameter("selectMnth") + "<br>");
        out.println(request.getParameter("selectYear") + "<br>");
        out.println(request.getParameter("nationality") + "<br>");
        out.println(request.getParameter("mName") + "<br>");
        out.println(request.getParameter("mCont") + "<br>");
        out.println(request.getParameter("fName") + "<br>");
        out.println(request.getParameter("fCont"));
        out.println("</body></html>");
        out.close();
    }
}
