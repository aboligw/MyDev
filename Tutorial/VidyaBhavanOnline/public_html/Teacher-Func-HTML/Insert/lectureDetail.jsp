<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
        <title>lectureDetail</title>
    </head>
    <body>
        <h4>Please fill in below lecture details</h4>

        
        <form action="../../lectureInsert" method="POST">
            Date of Lecture
            <input type="text" value="dd-MM-yyyy" name="dateOfLec"/>
            <br/>
            <br/>
            Class number
            <input type="number" name="classNo"/>
            <br/>
            <br/>
            Duration
            <input type="number" name="duration"/>
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