<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
        <title>student</title>
    </head>
    <body>
        <h4>Sending Notice to student!</h4>
         
        <form action="../../notice" method="POST">
            Enter roll number of the student
            <input type="number" name="rollNo"/>
            <input type="hidden" name="criteria" value="1"/>
            <br/>
            <br/>
            Date
            <input type="text" name="date"/>
            <br/>
            <br/>
            Notice text
            <textarea name="text" cols="40" rows="5"></textarea>
            <br/>
            <br/>
            <input type="submit" name="sub" value="SUBMIT"/>
            <input type="reset" name="sub" value="RESET"/>
            <br/>
            <br/>
            <a href="../Menu/menuPage.jsp">Teacher home</a>
        </form>
    </body>
</html>