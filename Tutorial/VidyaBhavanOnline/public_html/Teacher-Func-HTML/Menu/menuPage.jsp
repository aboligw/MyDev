<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
        <%@ taglib uri="/webapp/taglib1" prefix="my"%>
        <title>Menu</title>
    </head>
    <body>
        <h1>TEACHERS MENU</h1>
        <p>
            <my:DisplayUser/>
        </p>
        <form>
            <!--a href="/VidyaBhavan/Teacher-Func-HTML/StudentInfo/studentSelectCriteria.jsp">STUDENT INFORMATION</a-->
            <jsp:forward page="/Teacher-Func-HTML/StudentInfo/studentSelectCriteria.jsp"/>
            <br/>
            <br/>
            <a href="/VidyaBhavan/Teacher-Func-HTML/Insert/lectureDetail.jsp"> FILL IN LECTURE DETAILS</a>
            <br/>
            <br/>
            <a href="/VidyaBhavan/Teacher-Func-HTML/Upload/attendanceSource.jsp">UPLOAD ATTENDANCE</a>
            <br/>
            <br/>
            <a href="/VidyaBhavan/Teacher-Func-HTML/Report/attendanceReportInput.jsp">GENERATE ATTENDANCE REPORT FOR
                                                                                      GIVEN LECTURE#</a>
            <br/>
            <br/>
            <a href="/VidyaBhavan/Teacher-Func-HTML/Insert/testDetail.jsp">FILL IN TEST DETAILS</a>
            <br/>
            <br/>
            <a href="/VidyaBhavan/Teacher-Func-HTML/Upload/marksSource.jsp">UPLOAD TEST MARKS FROM FILE</a>
            <br/>
            <br/>
            <a href="/VidyaBhavan/Teacher-Func-HTML/Report/subReportCard.jsp">GET STUDENT'S PROGRESS REPORT FOR YOUR
                                                                              SUBJECT</a>
            <br/>
            <br/>
            <a href="/VidyaBhavan/Teacher-Func-HTML/Notice/noticeMenu.jsp">SEND NOTICE</a>
            <br/>
            <br/>
        </form>
    </body>
</html>