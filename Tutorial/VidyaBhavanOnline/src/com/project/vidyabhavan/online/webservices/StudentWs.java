package com.project.vidyabhavan.online.webservices;

import com.project.vb.common.BeanGetter;
import com.project.vb.model.Login;
import com.project.vb.model.Student;
import com.project.vb.output.MyAttendance;
import com.project.vb.output.MyNotices;
import com.project.vb.output.MyReport;
import com.project.vb.presentation.AttendanceBD;
import com.project.vb.presentation.MarksBD;
import com.project.vb.presentation.NoticeBD;
import com.project.vb.presentation.StudentBD;
import static com.project.vidyabhavan.online.presentation.Common.JavaClasses.CommonUtils.doLoginUser;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "StudentWs")
public class StudentWs {
    public StudentWs() {
        super();
    }

    @WebMethod
    public List<MyNotices> studentNoticeWS(@WebParam(name = "arg0") Login user) {
        List<MyNotices> outList = new ArrayList<MyNotices>();
        boolean loginStatus = doLoginUser(user);
        if (loginStatus) {
            Student stud = getStudent(user);

            NoticeBD noticeBdObj = BeanGetter.getBean("noticeBD", NoticeBD.class);
            outList = noticeBdObj.select(stud.getId());
        }
        return outList;
    }

    @WebMethod
    public List<MyReport> studentProgressWs(@WebParam(name = "arg0") Login user) {
        List<MyReport> outList = new ArrayList<MyReport>();
        boolean loginStatus = doLoginUser(user);
        if (loginStatus) {
            Student stud = getStudent(user);

            MarksBD marksBdObj = BeanGetter.getBean("marksBD", MarksBD.class);
            outList = marksBdObj.studReportselect(stud.getId());
        }
        return outList;

    }

    @WebMethod
    public List<MyAttendance> studentAttendanceWs(@WebParam(name = "arg0") Login user) {
        List<MyAttendance> outList = new ArrayList<MyAttendance>();
        boolean loginStatus = doLoginUser(user);
        if (loginStatus) {
            Student stud = getStudent(user);

            AttendanceBD attendanceBdObj = BeanGetter.getBean("attendanceBD", AttendanceBD.class);
            outList = attendanceBdObj.selectStudAttendance(stud.getId());
        }
        return outList;

    }


    private Student getStudent(Login user) {
        StudentBD studentBdObj = BeanGetter.getBean("studentBD", StudentBD.class);
        Student stud = studentBdObj.selectStudentRollNo(user.getUserId());
        return stud;
    }
}
