package com.project.vidyabhavan.online.presentation;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter(filterName = "AuthenticationFilter", urlPatterns = { "/*" })
public class AuthenticationFilter implements Filter {
    private FilterConfig _filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        _filterConfig = filterConfig;
    }

    public void destroy() {
        _filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
                                                                                                     ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession s = req.getSession(false);
        String uri = "Error-HTML/errorPage.jsp";
        String message = " ";

        /*if ((s != null) &&
            (req.getRequestURL().equals("localhost:7000/VidyaBhavan") ||
             null != s.getAttribute(OnlineConstants.USER))) {
            chain.doFilter(request, response);
        } else {
            message = "Login first";
            RequestDispatcher dis = request.getRequestDispatcher(uri);
            dis.forward(req, resp);
        }*/

        chain.doFilter(request, response);
    }
}
