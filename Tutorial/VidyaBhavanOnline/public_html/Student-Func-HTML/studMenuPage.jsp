<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
        <%@ taglib uri="/webapp/taglib1" prefix="my"%>
        <title>studMenuPage</title>
    </head>
    <body>
        <h4>Student's Menu Page</h4>
         
        <jsp:useBean id="USER" type="com.project.vb.model.Student" scope="session"></jsp:useBean>
        <p>
            Welcome 
            <%=USER.getName()%>
        </p>
        <p>
            This is from taglib 
            <my:DisplayUser/>
        </p>
        <form action="studentAction" method="POST">
            <input type="radio" name="func" value="1"/>
            MY ATTENDANCE REPORT
            <br/>
            <br/>
            <input type="radio" name="func" value="2"/>
            MY PROGRESS REPORT
            <br/>
            <br/>
            <input type="radio" name="func" value="3"/>
            MY NOTICE'S
            <br/>
            <br/>
            <input type="submit" name="sub" value="SUBMIT"/>
            <input type="reset" name="sub" value="RESET"/>
            <a href="Common-HTML/login.jsp">Logout</a>
        </form>
    </body>
</html>