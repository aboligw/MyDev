<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
        <title>studNameClassSearch</title>
    </head>
    <body>
        <form action="../../studentInfo" method="POST">
            Enter student Name
            <input type="text" name="name"/>
            <br/>
            <br/>
            Enter Class Number
            <input type="number" name="class"/>
            <br/>
            <br/>
            <input type="hidden" name="htmlName" value="2"/>
            <input type="submit" name="sub" value="SUBMIT"/>
            <input type="reset" name="sub" value="RESET"/>
            <br/>
            <br/>
            <a href="../Menu/menuPage.jsp">Teacher home</a>
        </form>
    </body>
</html>