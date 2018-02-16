<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
        <title>marksSource</title>
    </head>
    <body>
        <h4>Upload test marks for a Class</h4>
         
        <form action="../../uploadMarks" method="POST" enctype="multipart/form-data">
            Class #
            <input type="number" name="classNo"/>
            <br/>
            <br/>
            Test #
            <input type="number" name="testNo"/>
            <br/>
            <br/>
            Choose Marks File(.txt)
            <input name="srcFile" id="srcFile" type="file"/>
            <br/>
            <br/>
            <input type="submit" name="sub" value="SUBMIT"/>
            <input type="reset" name="sub" value="RESET"/>
            <br/>
            <br/>
            <br/>
            <a href="../Menu/menuPage.html">Teacher home</a>
        </form>
    </body>
</html>