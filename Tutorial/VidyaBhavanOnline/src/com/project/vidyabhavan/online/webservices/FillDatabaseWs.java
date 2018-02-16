package com.project.vidyabhavan.online.webservices;

import com.project.vb.common.BeanGetter;
import com.project.vb.model.Login;
import com.project.vb.model.Teacher;
import com.project.vb.presentation.ExamBD;
import com.project.vb.presentation.LectureBD;
import com.project.vb.presentation.NoticeBD;
import com.project.vb.presentation.StudentBD;
import com.project.vb.presentation.TeaSubBD;
import com.project.vb.presentation.TeacherBD;
import com.project.vidyabhavan.online.presentation.Common.JavaClasses.CommonUtils;
import static com.project.vidyabhavan.online.presentation.Common.JavaClasses.CommonUtils.doLoginUser;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "FillDatabaseWs")
public class FillDatabaseWs {
    public FillDatabaseWs() {
        super();
    }

    @WebMethod
    public String fillNotice(@WebParam(name = "arg0") Login user, @WebParam(name = "arg1") String date,
                             @WebParam(name = "arg2") String text, @WebParam(name = "arg3") int roll,
                             @WebParam(name = "arg4") int classNo, @WebParam(name = "arg5") int school) {
        String str = "Notice insert operation FAILED";
        boolean loginStatus = doLoginUser(user);
        if (loginStatus) {
            TeacherBD teacherBdObj = BeanGetter.getBean("teacherBD", TeacherBD.class);
            Teacher t = teacherBdObj.select(user.getUserId(), 0, null);
            roll = (roll != 0) ? roll : 0;
            classNo = (classNo != 0) ? classNo : 0;
            school = (school != 0) ? school : 0;
            List<Integer> recepientList = getRecepientList(roll, classNo, school);
            Date dateOfNotice = CommonUtils.formatDate(date);
            NoticeBD bdObj = BeanGetter.getBean("noticeBD", NoticeBD.class);
            boolean result = bdObj.insert(t.getId(), text, dateOfNotice, recepientList);

            if (result) {
                str = "Notice inserted SUCCESSFULLY!";
            }
        }
        return str;
    }

    @WebMethod
    public String fillTest(@WebParam(name = "arg0") Login user, @WebParam(name = "arg1") int classNo,
                           @WebParam(name = "arg2") int totalMarks) {
        String str = "Test insert operation FAILED";
        boolean loginStatus = doLoginUser(user);
        if (loginStatus) {
            TeacherBD teacherBdObj = BeanGetter.getBean("teacherBD", TeacherBD.class);
            Teacher t = teacherBdObj.select(user.getUserId(), 0, null);
            int teacherId = t.getId();

            TeaSubBD tsBdObj = BeanGetter.getBean("teaSubBD", TeaSubBD.class);
            int subId = tsBdObj.select(teacherId);

            ExamBD examBdObj = BeanGetter.getBean("examBD", ExamBD.class);
            examBdObj.insert(subId, totalMarks, classNo);
            str = "Test inserted SUCCESSFULLY!";
        }
        return str;
    }

    @WebMethod
    public String fillLecture(@WebParam(name = "arg0") Login user, @WebParam(name = "arg1") int classNo,
                              @WebParam(name = "arg2") int duration, @WebParam(name = "arg3") String date) {
        String str = "Lecture insert operation FAILED";
        boolean loginStatus = doLoginUser(user);
        int lecNo = 0;
        if (loginStatus) {
            TeacherBD teacherBdObj = BeanGetter.getBean("teacherBD", TeacherBD.class);
            Teacher t = teacherBdObj.select(user.getUserId(), 0, null);
            int teacherId = t.getId();

            TeaSubBD tsBdObj = BeanGetter.getBean("teaSubBD", TeaSubBD.class);
            int subId = tsBdObj.select(teacherId);

            Date dateOfLec = CommonUtils.formatDate(date);
            LectureBD lectureBdObj = BeanGetter.getBean("lectureBD", LectureBD.class);
            lecNo = lectureBdObj.insert(subId, classNo, teacherId, duration, dateOfLec, lecNo);

            if (lecNo != 0) {
                str = "Lecture inserted SUCCESSFULLY!";
            }
        }
        return str;
    }

    private List<Integer> getRecepientList(int roll, int classNo, int school) {

        StudentBD studentBdObj = BeanGetter.getBean("studentBD", StudentBD.class);
        List<Integer> list = new ArrayList<Integer>();
        if (roll != 0) {
            //student
            list.add(roll);
        } else if (classNo != 0) {
            //class
            list = studentBdObj.getStudFromSchool(classNo);
        } else if (school != 0) {
            //school
            list = studentBdObj.getStudFromSchool(0);
        }
        return list;
    }
}
