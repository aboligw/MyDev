package com.project.vidyabhavan.online.webservices;

import com.project.vb.common.BeanGetter;
import com.project.vb.model.Login;
import com.project.vb.model.Student;
import com.project.vb.presentation.StudentBD;
import static com.project.vidyabhavan.online.presentation.Common.JavaClasses.CommonUtils.doLoginUser;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "StudentInfoWs")
public class StudentInfoWs {
    public StudentInfoWs() {
        super();
    }

    @WebMethod
    public List<Student> studInfoService(@WebParam(name = "arg0") Login user, @WebParam(name = "arg1") int roll,
                                         @WebParam(name = "arg2") int classNo, @WebParam(name = "arg3") String name) {
        List<Student> list = new ArrayList<Student>();
        boolean loginStatus = doLoginUser(user);
        if (loginStatus) {
            roll = (roll != 0) ? roll : 0;
            name = (null != name) ? name : null;
            classNo = (classNo != 0) ? classNo : 0;

            StudentBD studBdObj = BeanGetter.getBean("studentBD", StudentBD.class);
            list = studBdObj.select(roll, name, classNo);
        }
        return list;
    }
}
