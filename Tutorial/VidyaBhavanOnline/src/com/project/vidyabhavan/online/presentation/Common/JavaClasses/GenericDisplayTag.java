package com.project.vidyabhavan.online.presentation.Common.JavaClasses;

import java.io.IOException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class GenericDisplayTag extends TagSupport {
    private List list;


    public void setList(List list) {
        this.list = list;
    }

    public List getList() {
        return list;
    }

    public int doStartTag() {
        JspWriter out = pageContext.getOut();
        try {
            out.println("Your result table is loading");
        } catch (IOException e) {
        }
        return (SKIP_BODY);
    }

    public int doEndTag() {
        JspWriter out = pageContext.getOut();
        try {
            Object obj = list.get(0);
            Field[] fields = obj.getClass().getDeclaredFields();
            Method[] methods = obj.getClass().getDeclaredMethods();
            out.println("<table>");
            out.println("<tr>");
            for (int i = 0; i < fields.length; i++) {
                out.print("<th>");
                out.print(fields[i].getName());
                out.println("</th>");
            }
            out.println("</tr>");

            for (Object o : list) {
                out.println("<tr>");
                for (int i = 0; i < fields.length; i++) {
                    String fieldName = fields[i].getName();
                    for (Method m : methods) {
                        String name = m.getName();
                        if (name.compareToIgnoreCase("get" + fieldName) == 0) {
                            out.println("<td>");
                            try {
                                out.println(m.invoke(o).toString());
                            } catch (IllegalAccessException e) {
                                e.getMessage();
                            }catch (InvocationTargetException e) {
                                e.getMessage();
                            }
                        }
                    }
                    out.println("</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (IOException e) {
            e.getMessage();
        }
        return EVAL_PAGE;
    }


}
