<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
        <title>testDetail</title>
    </head>
    <body>
        <h4>Enter details of test you want to take.</h4>
         
        <form action="../../testInsert" method="POST">
            Class
            <input type="number" name="class"/>
            <br/>
            <br/>
            Total Marks
            <input type="number" name="totMks"/>
            <br/>
            <br/>
            <input type="submit" name="sub" value="SUBMIT"/>
            <input type="reset" name="sub" value="RESET"/>
            <br/>
            <br/>
            <a href="../Menu/menuPage.html">Teacher home</a>
        </form>
    </body>
</html>