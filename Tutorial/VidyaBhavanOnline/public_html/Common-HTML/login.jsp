<!DOCTYPE html>
<%@ page session="true"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
        <title>Login</title>
    </head>
    <body>
        <h1>Vidya Bhavan School</h1>
         
        <form action="login" method="POST">
            <% String mess = (String)request.getAttribute("message");
            if(mess!=null){%>
            <p>
                <%=mess%>
            </p>
            <%}%>
            Username
            <input type="text" name="uName"/>
            <br/>
            <br/>
            Password
            <input type="password" name="password"/>
            <br/>
            <br/>
            Role
            <select id="roleSelect" name="roleSelect">
                <option value="TEACHER">TEACHER</option>
                <option value="STUDENT">STUDENT</option>
            </select>
            <br/>
            <br/>
            <input type="submit" name="sub" value="SUBMIT"/>
            <input type="reset" name="sub" value="RESET"/>
        </form>
         
        <% session.invalidate();%>
    </body>
</html>