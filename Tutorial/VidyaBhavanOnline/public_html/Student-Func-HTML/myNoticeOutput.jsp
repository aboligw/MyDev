<!DOCTYPE html>
<%@ page contentType="text/html;charset=EUC-KR" import="java.util.List , com.project.vb.output.MyNotices"%>
<%@ taglib uri="/webapp/taglib1" prefix="my"%>
<html>
    <head>
        <style>
                table, th, td {
                    border: 1px solid black;
                    border-collapse: collapse;
                }
            </style>
        <title>MyNoticeOutput</title>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
    </head>
    <body>
        <%List<MyNotices> list = (List)request.getAttribute("list");%>
         
        <my:GenericDisplayTag list="${list}"/>
         
        <%String next = (String)request.getAttribute("link");%>
         
        <a href="&lt;%=next%>"> Menu</a>
    </body>
</html>