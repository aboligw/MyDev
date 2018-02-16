<!DOCTYPE html>
<%@ page contentType="text/html;charset=EUC-KR" isErrorPage="true"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
    </head>
    <body>
        <form>
            <%String message = (String)request.getAttribute("message");%>
            This is error!
            <%=message%>
            <%String next = (String)request.getAttribute("link");%>
            <a href="&lt;%=next%>"> Menu</a>
        </form>
    </body>
</html>