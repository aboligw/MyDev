<!DOCTYPE html>
<%@ page contentType="text/html;charset=EUC-KR"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
    </head>
    <body>
        <form>
            <% String outputNumber = (String)request.getAttribute("outputNumber");
    String link = (String)request.getAttribute("link");
    %>
            Lecture details saved successfully. Lecture Number is
            <%=outputNumber%>
            <a href="&lt;%=link%>"> Menu</a>
        </form>
    </body>
</html>