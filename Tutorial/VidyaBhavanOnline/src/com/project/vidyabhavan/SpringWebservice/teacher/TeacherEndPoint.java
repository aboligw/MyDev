package com.project.vidyabhavan.SpringWebservice.teacher;

import com.project.vb.common.BeanGetter;
import com.project.vb.model.Teacher;
import com.project.vb.presentation.ExamBD;
import com.project.vb.presentation.LectureBD;
import com.project.vb.presentation.LoginBD;
import com.project.vb.presentation.NoticeBD;
import com.project.vb.presentation.StudentBD;
import com.project.vb.presentation.TeaSubBD;
import com.project.vb.presentation.TeacherBD;
import com.project.vidyabhavan.SpringWebservice.teacher.request.InsertExamRequest;
import com.project.vidyabhavan.SpringWebservice.teacher.request.InsertLectureRequest;
import com.project.vidyabhavan.SpringWebservice.teacher.request.InsertNoticeRequest;
import com.project.vidyabhavan.SpringWebservice.teacher.request.StudInfoRequest;
import com.project.vidyabhavan.SpringWebservice.teacher.response.InsertExamResponse;
import com.project.vidyabhavan.SpringWebservice.teacher.response.InsertLectureResponse;
import com.project.vidyabhavan.SpringWebservice.teacher.response.InsertNoticeResponse;
import com.project.vidyabhavan.SpringWebservice.teacher.response.StudInfoResponse;
import com.project.vidyabhavan.online.presentation.Common.JavaClasses.CommonUtils;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TeacherEndPoint {
    public TeacherEndPoint() {
        super();
    }

    @PayloadRoot(namespace = "http://localhost:7000/VidyaBhavan/Teacher", localPart = "studInfoRequest")
    @ResponsePayload
    public StudInfoResponse studentInfoWS(@RequestPayload StudInfoRequest in) {
        StudInfoResponse out = new StudInfoResponse();
        boolean loginStat = loginTeacher(in);
        if (loginStat) {
            StudentBD studBdObj = BeanGetter.getBean("studentBD", StudentBD.class);
            int roll = in.getStudent().getId();
            int classId = in.getStudent().getClassId();
            String name = in.getStudent().getName();
            out.setStudOut(studBdObj.select(roll, name, classId));
        }
        return out;
    }

    @PayloadRoot(namespace = "http://localhost:7000/VidyaBhavan/Teacher", localPart = "insertNoticeRequest")
    @ResponsePayload
    public InsertNoticeResponse insertNoticeWS(@RequestPayload InsertNoticeRequest in) {
        InsertNoticeResponse out = new InsertNoticeResponse();

        String user = in.getLogin().getUserId();
        String pass = in.getLogin().getPwd();
        LoginBD bdObj = BeanGetter.getBean("loginBD", LoginBD.class);
        boolean loginStat = bdObj.select(user, pass, "TEACHER");

        if (loginStat) {
            /*getSubID*/
            int subjectId = getSubIdofTeacher(user);
            String text = in.getNotice().getData();

            /*Convert string date to java.SQL.date format*/
            String dateStr = in.getDateStr();
            Date noticeDate = CommonUtils.formatDate(dateStr);

            /*getallEligible Student roll nos for this notice.*/
            int criteria = in.getCriteria();
            List<Integer> list = getEligibleRollnoList(in, criteria);

            /*finally insert notice into DB*/
            NoticeBD noticeBdObj = BeanGetter.getBean("noticeBD", NoticeBD.class);
            boolean result = noticeBdObj.insert(subjectId, text, noticeDate, list);

            if (result) {
                out.setMessage("Notice insert OKAY.");
            } else {
                out.setMessage("Notice insert FAILED.");
            }
        } else {
            out.setMessage("Notice insert Failed since Login failed. ");
        }
        return out;
    }

    @PayloadRoot(namespace = "http://localhost:7000/VidyaBhavan/Teacher", localPart = "insertExamRequest")
    @ResponsePayload
    public InsertExamResponse insertExamWS(@RequestPayload InsertExamRequest in) {
        InsertExamResponse out = new InsertExamResponse();

        String user = in.getLogin().getUserId();
        String pass = in.getLogin().getPwd();
        LoginBD bdObj = BeanGetter.getBean("loginBD", LoginBD.class);
        boolean loginStat = bdObj.select(user, pass, "TEACHER");

        if (loginStat) {
            int subjectId = getSubIdofTeacher(user);
            int classId = in.getExam().getClassId();
            int totMks = in.getExam().getTotMks();
            ExamBD examBdObj = BeanGetter.getBean("examBD", ExamBD.class);
            examBdObj.insert(subjectId, totMks, classId);
            out.setMessage("Test insert OKAY. ");
        } else {
            out.setMessage("Test details insert Failed since Login failed. ");
        }
        return out;
    }


    @PayloadRoot(namespace = "http://localhost:7000/VidyaBhavan/Teacher", localPart = "insertLectureRequest")
    @ResponsePayload
    public InsertLectureResponse insertLectureWS(@RequestPayload InsertLectureRequest in) {
        InsertLectureResponse out = new InsertLectureResponse();

        String user = in.getLogin().getUserId();
        String pass = in.getLogin().getPwd();
        LoginBD bdObj = BeanGetter.getBean("loginBD", LoginBD.class);
        boolean loginStat = bdObj.select(user, pass, "TEACHER");

        if (loginStat) {
            int lecNo = 0;
            int subjectId = getSubIdofTeacher(user);
            int teacherId = getTeacherIdOfTeacher(user);
            int classId = in.getLecture().getClassId();
            int duration = in.getLecture().getDuration();
            String dateStr = in.getDateStr();
            Date lecDate = CommonUtils.formatDate(dateStr);


            LectureBD lectureBdObj = BeanGetter.getBean("lectureBD", LectureBD.class);
            lecNo = lectureBdObj.insert(subjectId, classId, teacherId, duration, lecDate, lecNo);
            if (lecNo != 0) {
                out.setMessage("Lecture insert OKAY. ");
            } else {
                out.setMessage("Lecture insert FAILED. ");
            }
        } else {
            out.setMessage("Lecture details insert Failed since Login failed. ");
        }
        return out;
    }

    private List<Integer> getEligibleRollnoList(InsertNoticeRequest in, int criteria) {
        int classNo = 0;
        StudentBD studentBdObj = BeanGetter.getBean("studentBD", StudentBD.class);
        List<Integer> list = new ArrayList<Integer>();
        switch (criteria) {
        case 1:
            //student
            list.add(in.getStudent().getId());
            break;
        case 2:
            //class
            classNo = in.getClassNo();
            list = studentBdObj.getStudFromSchool(classNo);
            break;
        case 3:
            //school
            list = studentBdObj.getStudFromSchool(classNo);
            break;
        }
        return list;
    }

    private boolean loginTeacher(StudInfoRequest in) {
        String user = in.getLogin().getUserId();
        String pass = in.getLogin().getPwd();
        LoginBD bdObj = BeanGetter.getBean("loginBD", LoginBD.class);

        boolean loginStat = bdObj.select(user, pass, "TEACHER");
        return loginStat;
    }

    private int getSubIdofTeacher(String user) {
        int teacherId = getTeacherIdOfTeacher(user);
        /*getSubID*/

        TeaSubBD tsBdObj = BeanGetter.getBean("teaSubBD", TeaSubBD.class);
        int subjectId = tsBdObj.select(teacherId);
        return subjectId;
    }

    private int getTeacherIdOfTeacher(String user) {
        TeacherBD teacherBdObj = BeanGetter.getBean("teacherBD", TeacherBD.class);
        Teacher t = teacherBdObj.select(user, 0, null);
        int teacherId = t.getId();
        return teacherId;
    }
}
