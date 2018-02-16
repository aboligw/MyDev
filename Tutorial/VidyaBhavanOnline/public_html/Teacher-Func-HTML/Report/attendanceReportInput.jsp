<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
        <title>attendanceReportInput</title>
    </head>
    <body>
        <h4>Enter below details to generate attendance report.</h4>
         
        <form action="../../attendanceReport" method="POST">
            Class #
            <input type="number" name="classNo"/>
            <br/>
            <br/>
            Lecture #
            <input type="number" name="lecNo"/>
            <br/>
            <br/>
            <input type="submit" name="sub" value="SUBMIT"/>
            <input type="reset" name="sub" value="RESET"/>
            <br/>
            <br/>
            <br/>
            <a href="../Menu/menuPage.html">Teacher's Menu</a>
        </form>
    </body>
</html>