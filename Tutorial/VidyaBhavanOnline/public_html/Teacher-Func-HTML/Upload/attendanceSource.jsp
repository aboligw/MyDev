<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
        <title>attendanceSource</title>
    </head>
    <body>
        <h4>Upload Class Attendance for below lecture.</h4>
         
        <form action="../../uploadAttendance" method="POST">
            Class #
            <input type="number" name="classNo"/>
            <br/>
            <br/>
            Lecture #
            <input type="number" name="lecNo"/>
            <br/>
            <br/>
            Lecture Date
            <input type="text" name="lecDate"/>
            <br/>
            <br/>
            Choose Attendance File(.txt)
            <input name="srcFile" type="file"/>
            <br/>
            <br/>
            <input type="submit" name="sub" value="SUBMIT"/>
            <input type="reset" name="sub" value="RESET"/>
            <br/>
            <br/>
            <br/>
            <a href="../Menu/menuPage.html">Teacher Menu</a>
        </form>
    </body>
</html>