package com.project.vidyabhavan.online.presentation.Common.JavaClasses;

import com.project.vb.common.JavaConstants;
import com.project.vb.model.Student;
import com.project.vb.model.Teacher;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyCustomTag extends TagSupport {
    public int doStartTag() {
        HttpSession sess = pageContext.getSession();
        Teacher t = null;
        Student s = null;
        JspWriter out = pageContext.getOut();
        try {
            out.println("User is: ");
            if (JavaConstants.STUDENT.equals(sess.getAttribute(OnlineConstants.ROLE))) {
                s = (Student) sess.getAttribute(OnlineConstants.USER);
                out.println(s.getName());
            } else if (JavaConstants.TEACHER.equals(sess.getAttribute(OnlineConstants.ROLE))) {
                t = (Teacher) sess.getAttribute(OnlineConstants.USER);
                out.println(t.getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return (SKIP_BODY);
    }
}
