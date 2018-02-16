package com.project.vidyabhavan.online.presentation;

import com.project.vb.common.BeanGetter;
import com.project.vb.model.Teacher;
import com.project.vb.presentation.ExamBD;
import com.project.vb.presentation.MarksBD;
import com.project.vb.presentation.TeaSubBD;
import com.project.vidyabhavan.online.presentation.Common.JavaClasses.OnlineConstants;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//@MultipartConfig
public class UploadMarksServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=EUC-KR";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        /*PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>UploadMarksServlet</title></head>");
        out.println("<body>");
*/
        String message = " ";
        String link = " ";
        HttpSession s = request.getSession(false);
        Teacher t = (Teacher) s.getAttribute(OnlineConstants.USER);
        if (t != null) {
            int teacherId = t.getId();

            List<FileItem> items = getFileItemsList(request);
            BufferedReader br = null;
            List<String> list = new ArrayList<String>();

            Iterator<FileItem> iter = items.iterator();
            int classNo = 0;
            int testNo = 0;
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (item.isFormField()) {
                    if ("classNo".equals(item.getFieldName())) {
                        classNo = Integer.parseInt(item.getString());
                    } else if ("testNo".equals(item.getFieldName())) {
                        testNo = Integer.parseInt(item.getString());
                    }
                } else if (!item.isFormField()) {
                    InputStream uploadedStream = item.getInputStream();
                    br = new BufferedReader(new InputStreamReader(uploadedStream));
                    String line = br.readLine();
                    while (line != null) {
                        if (line == null) {
                            break;
                        }
                        list.add(line);
                        line = br.readLine();
                    }
                }
            }
            TeaSubBD tsBdObj = BeanGetter.getBean("teaSubBD", TeaSubBD.class);
            int subjectId = tsBdObj.select(teacherId);

            ExamBD examBdObj = BeanGetter.getBean("examBD", ExamBD.class);
            int internalTestId = examBdObj.select(subjectId, classNo, testNo);

            MarksBD marksBdObj = BeanGetter.getBean("marksBD", MarksBD.class);
            marksBdObj.bulkInsert(list, internalTestId);
            message = "File uploaded to database!";
            link = "Teacher-Func-HTML/Menu/menuPage.jsp";
        }
        /*   out.println("<p> </p><br/><br/>");
            out.println("<p><a  href='" + "Teacher-Func-HTML/Menu/menuPage.jsp" + "'>Teacher Menu</a>");
        } else {
            out.println("<p>Login first!!!.</p>");
            out.println("<p><a  href='" + "Common-HTML/login.jsp" + "'>Login</a>");
        }
        out.println("</body></html>");
        out.close();*/
        request.setAttribute("message", message);
        request.setAttribute("link", link);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Teacher-Func-HTML/Upload/uploadedTest.jsp");
        dispatcher.forward(request, response);

    }

    public List<FileItem> getFileItemsList(HttpServletRequest request) {
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Parse the request
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.getMessage();
        }
        return items;
    }

}
