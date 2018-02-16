<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
        <title>school</title>
    </head>
    <body>
        <h4>Sending Notice to entire School!</h4>
         
        <form action="../../notice" method="POST">
            <input type="hidden" name="criteria" value="3"/>
            <br/>
            <input type="submit" name="sub" value="CONFIRM"/>
            <input type="reset" name="sub" value="RESET"/>
            <br/>
            <br/>
            <input type="text" name="date"/>
            <br/>
            <br/>
            Notice text
            <textarea name="text" cols="40" rows="5"></textarea>
            <br/>
            <br/>
            <a href="../Menu/menuPage.jsp">Teacher home</a>
        </form>
    </body>
</html>