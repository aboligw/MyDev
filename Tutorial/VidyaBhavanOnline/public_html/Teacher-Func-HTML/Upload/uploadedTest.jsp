<!DOCTYPE html>
<%@ page contentType="text/html;charset=EUC-KR"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
    </head>
    <body>
        <form>
            <% String message = (String)request.getAttribute("message");
    String link = (String)request.getAttribute("link");
    %>
            <%=message%>
            <a href="&lt;%=link%>"> Menu</a>
        </form>
    </body>
</html>