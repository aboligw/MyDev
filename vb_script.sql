CREATE TABLE "SUBJECT" (	"SUB_ID" NUMBER, "SUB_NAME" VARCHAR2(20), PRIMARY KEY ("SUB_ID") ENABLE ) / CREATE TABLE "TEACHER" (	"USER_ID" VARCHAR2(20), "TEACHER_ID" NUMBER, "TEACHER_NAME" VARCHAR2(20), PRIMARY KEY ("TEACHER_ID") ENABLE, FOREIGN KEY ("USER_ID") REFERENCES "LOGIN" ("USER_ID") ENABLE ) / CREATE TABLE "LECTURE" (	"LEC_ID" NUMBER, "SUB_ID" NUMBER, "CLASS_ID" NUMBER, "TEACHER_ID" NUMBER, "LEC_DATE" DATE, "DURATION" NUMBER, "LEC_NUM" NUMBER, PRIMARY KEY ("LEC_ID") ENABLE, FOREIGN KEY ("SUB_ID") REFERENCES "SUBJECT" ("SUB_ID") ENABLE, FOREIGN KEY ("CLASS_ID") REFERENCES "CLASS" ("CLASS_ID") ENABLE, FOREIGN KEY ("TEACHER_ID") REFERENCES "TEACHER" ("TEACHER_ID") ENABLE ) / CREATE TABLE "STUDENT" (	"USER_ID" VARCHAR2(20), "STUD_ID" NUMBER, "NAME" VARCHAR2(50), "CLASS_ID" NUMBER NOT NULL ENABLE, "PARENTS_CONTACT_NO" NUMBER(10,0), "ADDRESS" VARCHAR2(50), PRIMARY KEY ("STUD_ID") ENABLE, FOREIGN KEY ("CLASS_ID") REFERENCES "CLASS" ("CLASS_ID") ENABLE, CONSTRAINT "LOGIN_FK" FOREIGN KEY ("USER_ID") REFERENCES "LOGIN" ("USER_ID") ENABLE ) / CREATE TABLE "ATTENDANCE" (	"STUD_ID" NUMBER, "LEC_ID" NUMBER, "STATUS" CHAR(1), FOREIGN KEY ("STUD_ID") REFERENCES "STUDENT" ("STUD_ID") ENABLE, FOREIGN KEY ("LEC_ID") REFERENCES "LECTURE" ("LEC_ID") ENABLE ) / CREATE TABLE "CLASS" (	"CLASS_ID" NUMBER, "CLASS_TEACHER" VARCHAR2(20), "TOT_STUD" NUMBER, PRIMARY KEY ("CLASS_ID") ENABLE ) / CREATE TABLE "LOGIN" (	"USER_ID" VARCHAR2(20), "PWD" VARCHAR2(20), "ROLE" VARCHAR2(8), PRIMARY KEY ("USER_ID") ENABLE ) / CREATE TABLE "NOTICE" (	"NOTICE_ID" NUMBER, "NOTICE_DATA" VARCHAR2(1000), "SUB_ID" NUMBER, "NOTICE_DATE" DATE, PRIMARY KEY ("NOTICE_ID") ENABLE ) / CREATE TABLE "TEST" (	"TEST_ID" NUMBER, "SUB_ID" NUMBER, "TOT_MKS" NUMBER, "CLASS_ID" NUMBER, "TEST_NUM" NUMBER, PRIMARY KEY ("TEST_ID") ENABLE, FOREIGN KEY ("SUB_ID") REFERENCES "SUBJECT" ("SUB_ID") ENABLE ) / CREATE TABLE "REPORT" (	"STUD_ID" NUMBER, "TEST_ID" NUMBER, "MARKS_OBT" NUMBER, FOREIGN KEY ("STUD_ID") REFERENCES "STUDENT" ("STUD_ID") ENABLE, FOREIGN KEY ("TEST_ID") REFERENCES "TEST" ("TEST_ID") ENABLE ) / CREATE TABLE "STUDNOTE_LINK" (	"NOTICE_ID" NUMBER, "STUD_ID" NUMBER, "NOTICE_NUM" NUMBER, FOREIGN KEY ("NOTICE_ID") REFERENCES "NOTICE" ("NOTICE_ID") ENABLE ) / CREATE TABLE "TEASUB_LINK" (	"TEACHER_ID" NUMBER, "SUB_ID" NUMBER, FOREIGN KEY ("TEACHER_ID") REFERENCES "TEACHER" ("TEACHER_ID") ENABLE, FOREIGN KEY ("SUB_ID") REFERENCES "SUBJECT" ("SUB_ID") ENABLE ) / CREATE UNIQUE INDEX "SYS_C004153" ON "NOTICE" ("NOTICE_ID") / CREATE UNIQUE INDEX "SYS_C004069" ON "LECTURE" ("LEC_ID") / CREATE UNIQUE INDEX "SYS_C004064" ON "TEACHER" ("TEACHER_ID") / CREATE UNIQUE INDEX "SYS_C004063" ON "LOGIN" ("USER_ID") / CREATE UNIQUE INDEX "SYS_C004059" ON "TEST" ("TEST_ID") / CREATE UNIQUE INDEX "SYS_C004058" ON "SUBJECT" ("SUB_ID") / CREATE UNIQUE INDEX "SYS_C004056" ON "STUDENT" ("STUD_ID") / CREATE UNIQUE INDEX "SYS_C004054" ON "CLASS" ("CLASS_ID") / CREATE OR REPLACE PACKAGE "PA_TEST" AS PROCEDURE I_TEST( nSUB_ID IN TEST.SUB_ID%TYPE, nTOT_MKS IN TEST.TOT_MKS%TYPE, nCLASS_ID IN TEST.CLASS_ID%TYPE, nRETURNCODE OUT NUMBER); PROCEDURE S_TEST( nSUB_ID IN TEST.SUB_ID%TYPE, nCLASS_ID IN TEST.CLASS_ID%TYPE, nTEST_NUM IN TEST.TEST_NUM%TYPE, nTEST_ID OUT TEST.TEST_ID%TYPE, nRETURNCODE OUT NUMBER); END PA_TEST; / CREATE OR REPLACE PACKAGE BODY "PA_TEST" AS PROCEDURE I_TEST( nSUB_ID IN TEST.SUB_ID%TYPE, nTOT_MKS IN TEST.TOT_MKS%TYPE, nCLASS_ID IN TEST.CLASS_ID%TYPE, nRETURNCODE OUT NUMBER) AS X NUMBER; BEGIN BEGIN SELECT TEST_ID_SEQ.NEXTVAL INTO X FROM DUAL; nRETURNCODE:=0; BEGIN INSERT INTO TEST VALUES ( X, nSUB_ID, nTOT_MKS, nCLASS_ID, (SELECT NVL(MAX(TEST_NUM),0)+1 FROM TEST WHERE CLASS_ID = nCLASS_ID AND SUB_ID = nSUB_ID ) ) ; END; EXCEPTION WHEN OTHERS THEN nRETURNCODE := -19; END; END I_TEST; PROCEDURE S_TEST( nSUB_ID IN TEST.SUB_ID%TYPE, nCLASS_ID IN TEST.CLASS_ID%TYPE, nTEST_NUM IN TEST.TEST_NUM%TYPE, nTEST_ID OUT TEST.TEST_ID%TYPE, nRETURNCODE OUT NUMBER) AS BEGIN BEGIN nRETURNCODE := 0; SELECT TEST_ID INTO nTEST_ID FROM TEST WHERE nSUB_ID = SUB_ID AND nCLASS_ID = CLASS_ID AND nTEST_NUM = TEST_NUM; EXCEPTION WHEN OTHERS THEN nRETURNCODE := -20; END; END S_TEST; END PA_TEST; / CREATE OR REPLACE PACKAGE "PA_TEASUBLINK" AS PROCEDURE S_TEASUBLINK( nTID IN TEASUB_LINK.TEACHER_ID%TYPE, nSID OUT TEASUB_LINK.SUB_ID%TYPE); END PA_TEASUBLINK; / CREATE OR REPLACE PACKAGE BODY "PA_TEASUBLINK" AS PROCEDURE S_TEASUBLINK( nTID IN TEASUB_LINK.TEACHER_ID%TYPE, nSID OUT TEASUB_LINK.SUB_ID%TYPE) AS BEGIN SELECT SUB_ID INTO nSID FROM TEASUB_LINK WHERE TEACHER_ID = nTID; END S_TEASUBLINK; END PA_TEASUBLINK; / CREATE OR REPLACE PACKAGE "PA_TEACHER" AS PROCEDURE S_TEACHER( sUSERID IN TEACHER.USER_ID%TYPE, nID IN TEACHER.TEACHER_ID%TYPE, sNAME IN TEACHER.TEACHER_NAME%TYPE, TEACHER_REC OUT SYS_REFCURSOR); END PA_TEACHER; / CREATE OR REPLACE PACKAGE BODY "PA_TEACHER" AS PROCEDURE S_TEACHER( sUSERID IN TEACHER.USER_ID%TYPE, nID IN TEACHER.TEACHER_ID%TYPE, sNAME IN TEACHER.TEACHER_NAME%TYPE, TEACHER_REC OUT SYS_REFCURSOR)AS BEGIN OPEN TEACHER_REC FOR SELECT USER_ID , TEACHER_ID, TEACHER_NAME FROM TEACHER WHERE USER_ID = sUSERID AND (sName IS NULL OR TEACHER_NAME=sName) AND (nID IS NULL OR nID=0 OR nID=TEACHER_ID); --END; END S_TEACHER; END PA_TEACHER; / CREATE OR REPLACE PACKAGE "PA_STUDENT" AS PROCEDURE S_STUDENT( nID IN STUDENT.STUD_ID%TYPE, sNAME IN STUDENT.NAME%TYPE, nCLASS IN STUDENT.CLASS_ID%TYPE, STUD_REC OUT SYS_REFCURSOR); PROCEDURE GET_STUDENT_ROLL( nUSER_ID IN STUDENT.USER_ID%TYPE, STUD_REC OUT SYS_REFCURSOR, nRETURNCODE OUT NUMBER); PROCEDURE GET_STUDENT_FROM_SCHOOL( nCLASS_ID IN STUDENT.CLASS_ID%TYPE, STUD_REC OUT SYS_REFCURSOR, nRETURNCODE OUT NUMBER); END PA_STUDENT; / CREATE OR REPLACE PACKAGE BODY "PA_STUDENT" AS PROCEDURE S_STUDENT( nID IN STUDENT.STUD_ID%TYPE, sNAME IN STUDENT.NAME%TYPE, nCLASS IN STUDENT.CLASS_ID%TYPE, STUD_REC OUT SYS_REFCURSOR) AS BEGIN BEGIN OPEN STUD_REC FOR SELECT STUD_ID , NAME , CLASS_ID , PARENTS_CONTACT_NO, ADDRESS FROM STUDENT WHERE (nID IS NULL OR nID=0 OR nID=STUD_ID) AND (sName IS NULL OR NAME LIKE '%' || sName ||'%') AND (nClass IS NULL OR nClass=0 OR nClass=CLASS_ID); END; END S_STUDENT; PROCEDURE GET_STUDENT_ROLL( nUSER_ID IN STUDENT.USER_ID%TYPE, STUD_REC OUT SYS_REFCURSOR, nRETURNCODE OUT NUMBER) AS BEGIN nRETURNCODE:=0; BEGIN OPEN STUD_REC FOR SELECT STUD_ID , NAME , USER_ID FROM STUDENT WHERE (nUSER_ID = USER_ID); END; EXCEPTION WHEN OTHERS THEN nRETURNCODE:=-21; END GET_STUDENT_ROLL; PROCEDURE GET_STUDENT_FROM_SCHOOL( nCLASS_ID IN STUDENT.CLASS_ID%TYPE, STUD_REC OUT SYS_REFCURSOR, nRETURNCODE OUT NUMBER) AS BEGIN nRETURNCODE := 0; BEGIN IF (nCLASS_ID = 0) THEN BEGIN OPEN STUD_REC FOR SELECT STUD_ID FROM STUDENT; END; ELSE BEGIN OPEN STUD_REC FOR SELECT STUD_ID FROM STUDENT WHERE nCLASS_ID = CLASS_ID; END; END IF; EXCEPTION WHEN OTHERS THEN nRETURNCODE := -23; END; END GET_STUDENT_FROM_SCHOOL; END PA_STUDENT; / CREATE OR REPLACE PACKAGE "PA_REPORT" AS PROCEDURE S_REPORT( nSTUD_ID IN REPORT.STUD_ID%TYPE, nSUB_ID IN TEST.SUB_ID%TYPE, DATA_REC OUT SYS_REFCURSOR, nRETURNCODE OUT NUMBER); PROCEDURE S_MYREPORT( nSTUD_ID IN REPORT.STUD_ID%TYPE, DATA_REC OUT SYS_REFCURSOR, nRETURNCODE OUT NUMBER); END PA_REPORT; / CREATE OR REPLACE PACKAGE BODY "PA_REPORT" AS PROCEDURE S_REPORT( nSTUD_ID IN REPORT.STUD_ID%TYPE, nSUB_ID IN TEST.SUB_ID%TYPE, DATA_REC OUT SYS_REFCURSOR, nRETURNCODE OUT NUMBER) AS BEGIN nRETURNCODE := 0; BEGIN OPEN DATA_REC FOR SELECT R.STUD_ID,S.NAME,SB.SUB_NAME,T.CLASS_ID,T.TEST_NUM,T.TOT_MKS,R.MARKS_OBT FROM TEST T,REPORT R,STUDENT S,SUBJECT SB WHERE T.TEST_ID = R.TEST_ID AND R.STUD_ID = nSTUD_ID AND T.CLASS_ID IN (SELECT CLASS_ID FROM TEST WHERE SUB_ID = nSUB_ID ) AND S.STUD_ID = nSTUD_ID AND SB.SUB_ID = nSUB_ID; EXCEPTION WHEN OTHERS THEN nRETURNCODE := -21; END; END S_REPORT; PROCEDURE S_MYREPORT( nSTUD_ID IN REPORT.STUD_ID%TYPE, DATA_REC OUT SYS_REFCURSOR, nRETURNCODE OUT NUMBER) AS BEGIN nRETURNCODE := 0; BEGIN OPEN DATA_REC FOR SELECT S.STUD_ID,S.NAME,SB.SUB_NAME,T.TEST_NUM,T.TOT_MKS,R.MARKS_OBT FROM STUDENT S, REPORT R, TEST T,SUBJECT SB WHERE R.STUD_ID = nSTUD_ID AND R.TEST_ID = T.TEST_ID AND T.SUB_ID = SB.SUB_ID AND S.STUD_ID = nSTUD_ID; EXCEPTION WHEN OTHERS THEN nRETURNCODE := -21; END; END S_MYREPORT; END PA_REPORT; / CREATE OR REPLACE PACKAGE "PA_NOTICE" AS PROCEDURE S_NOTICE( nSTUD_ID IN STUDENT.STUD_ID%TYPE, DATA_REC OUT SYS_REFCURSOR, nRETURNCODE OUT NUMBER); END PA_NOTICE; / CREATE OR REPLACE PACKAGE BODY "PA_NOTICE" AS PROCEDURE S_NOTICE( nSTUD_ID IN STUDENT.STUD_ID%TYPE, DATA_REC OUT SYS_REFCURSOR, nRETURNCODE OUT NUMBER) AS BEGIN nRETURNCODE := 0; BEGIN OPEN DATA_REC FOR SELECT S.STUD_ID,S.NAME,SB.SUB_NAME, SL.NOTICE_NUM,N.NOTICE_DATE,N.NOTICE_DATA FROM STUDENT S,SUBJECT SB,STUDNOTE_LINK SL,NOTICE N WHERE N.NOTICE_ID = SL.NOTICE_ID AND S.STUD_ID = SL.STUD_ID AND SB.SUB_ID = N.SUB_ID AND SL.STUD_ID = nSTUD_ID; EXCEPTION WHEN OTHERS THEN nRETURNCODE := -24; END; END S_NOTICE; END PA_NOTICE; / CREATE OR REPLACE PACKAGE "PA_LOGIN" AS -- PROCEDURE I_LOGIN(sID IN LOGIN.USER_ID%TYPE, -- sPWD IN LOGIN.PWD%TYPE, -- sROLE IN LOGIN.ROLE%TYPE, -- nRETURNCODE OUT NUMBER); PROCEDURE S_LOGIN( sID IN LOGIN.USER_ID%TYPE, sPWD IN LOGIN.PWD%TYPE, sROLE IN LOGIN.ROLE%TYPE, nRETURNCODE OUT NUMBER); -- PROCEDURE D_LOGIN(sID IN LOGIN.USER_ID%tYPE, -- nRET_VALUE OUT NUMBER); -- PROCEDURE U_LOGIN(sID IN LOGIN.USER_ID%TYPE, -- sPWD IN LOGIN.PWD%TYPE, -- sROLE IN LOGIN.ROLE%TYPE, -- nRETURNCODE OUT NUMBER); INV_USER_ID EXCEPTION ; INV_PWD EXCEPTION ; INV_ROLE EXCEPTION ; END PA_LOGIN; / CREATE OR REPLACE PACKAGE BODY "PA_LOGIN" AS PROCEDURE S_LOGIN( sID IN LOGIN.USER_ID%TYPE, sPWD IN LOGIN.PWD%TYPE, sROLE IN LOGIN.ROLE%TYPE, nRETURNCODE OUT NUMBER) AS CNT INTEGER; BEGIN BEGIN nReturnCode :=0; BEGIN SELECT COUNT(*) INTO CNT FROM LOGIN WHERE USER_ID = sID; END; IF (CNT != 1) THEN RAISE INV_USER_ID; ELSE BEGIN SELECT COUNT(*) INTO CNT FROM LOGIN WHERE USER_ID = sID AND PWD = sPWD; END; IF (CNT != 1) THEN RAISE INV_PWD; ELSE BEGIN SELECT COUNT(*) INTO CNT FROM LOGIN WHERE USER_ID = sID AND PWD = sPWD AND ROLE = sROLE; END; IF(CNT != 1) THEN RAISE INV_ROLE; END IF; END IF; END IF; EXCEPTION WHEN INV_USER_ID THEN nReturnCode := -11; WHEN INV_PWD THEN nReturnCode :=-12; WHEN INV_ROLE THEN nReturnCode :=-13; END; END S_LOGIN; END PA_LOGIN; / CREATE OR REPLACE PACKAGE "PA_LECTURE" AS PROCEDURE I_LECTURE( nSUB_ID IN LECTURE.SUB_ID%TYPE, nCLASS_ID IN LECTURE.CLASS_ID%TYPE, nTEACHER_ID IN LECTURE.TEACHER_ID%TYPE, dLEC_DATE IN LECTURE.LEC_DATE%TYPE, nDURATION IN LECTURE.DURATION%TYPE, nLEC_NUM IN LECTURE.LEC_NUM%TYPE, nLEC_ID OUT LECTURE.LEC_ID%TYPE, nRETURNCODE OUT NUMBER); PROCEDURE S_LECTURE( dLEC_DATE IN LECTURE.LEC_DATE%TYPE, nCLASS_ID IN LECTURE.CLASS_ID%TYPE, nLEC_NUM IN LECTURE.LEC_NUM%TYPE, nTEACHER_ID IN LECTURE.TEACHER_ID%TYPE, nLEC_ID OUT LECTURE.LEC_ID%TYPE, nRETURNCODE OUT NUMBER); END PA_LECTURE; / CREATE OR REPLACE PACKAGE BODY "PA_LECTURE" AS PROCEDURE I_LECTURE( nSUB_ID IN LECTURE.SUB_ID%TYPE, nCLASS_ID IN LECTURE.CLASS_ID%TYPE, nTEACHER_ID IN LECTURE.TEACHER_ID%TYPE, dLEC_DATE IN LECTURE.LEC_DATE%TYPE, nDURATION IN LECTURE.DURATION%TYPE, nLEC_NUM IN LECTURE.LEC_NUM%TYPE, nLEC_ID OUT LECTURE.LEC_ID%TYPE, nRETURNCODE OUT NUMBER) AS BEGIN BEGIN SELECT LEC_ID_SEQ.NEXTVAL INTO nLEC_ID FROM DUAL; nRETURNCODE:=0; BEGIN INSERT INTO LECTURE VALUES ( nLEC_ID, nSUB_ID, nCLASS_ID, nTEACHER_ID, TO_DATE(dLEC_DATE), nDURATION, (SELECT NVL(MAX(LEC_NUM),0)+1 FROM LECTURE WHERE CLASS_ID = nCLASS_ID AND SUB_ID = nSUB_ID ) ) ; END; EXCEPTION WHEN OTHERS THEN nRETURNCODE := -15; END; END I_LECTURE; PROCEDURE S_LECTURE( dLEC_DATE IN LECTURE.LEC_DATE%TYPE, nCLASS_ID IN LECTURE.CLASS_ID%TYPE, nLEC_NUM IN LECTURE.LEC_NUM%TYPE, nTEACHER_ID IN LECTURE.TEACHER_ID%TYPE, nLEC_ID OUT LECTURE.LEC_ID%TYPE, nRETURNCODE OUT NUMBER) AS BEGIN BEGIN nRETURNCODE := 0; SELECT LEC_ID INTO nLEC_ID FROM LECTURE WHERE dLEC_DATE = LEC_DATE AND nCLASS_ID = CLASS_ID AND nLEC_NUM = LEC_NUM AND nTEACHER_ID = TEACHER_ID; EXCEPTION WHEN OTHERS THEN nRETURNCODE := -16; END; END S_LECTURE; END PA_LECTURE; / CREATE OR REPLACE PACKAGE "PA_ATTENDANCE" AS PROCEDURE S_ATTENDANCE( nCLASS_ID IN LECTURE.CLASS_ID%TYPE, nLEC_NUM IN LECTURE.LEC_NUM%TYPE, nTEACER_ID IN LECTURE.TEACHER_ID%TYPE, DATA_REC OUT SYS_REFCURSOR, nRETURNCODE OUT NUMBER); PROCEDURE S_MYATTENDANCE( nSTUD_ID IN STUDENT.STUD_ID%TYPE, DATA_REC OUT SYS_REFCURSOR, nRETURNCODE OUT NUMBER); END PA_ATTENDANCE; / CREATE OR REPLACE PACKAGE BODY "PA_ATTENDANCE" AS PROCEDURE S_ATTENDANCE( nCLASS_ID IN LECTURE.CLASS_ID%TYPE, nLEC_NUM IN LECTURE.LEC_NUM%TYPE, nTEACER_ID IN LECTURE.TEACHER_ID%TYPE, DATA_REC OUT SYS_REFCURSOR, nRETURNCODE OUT NUMBER) AS BEGIN nRETURNCODE := 0; BEGIN OPEN DATA_REC FOR SELECT S.STUD_ID,S.NAME,A.STATUS FROM ATTENDANCE A,STUDENT S WHERE A.LEC_ID = (SELECT L.LEC_ID FROM LECTURE L WHERE L.TEACHER_ID = nTEACER_ID AND L.LEC_NUM = nLEC_NUM AND L.CLASS_ID = nCLASS_ID ) AND A.STUD_ID = S.STUD_ID; END; EXCEPTION WHEN OTHERS THEN nRETURNCODE := -18; END S_ATTENDANCE; PROCEDURE S_MYATTENDANCE( nSTUD_ID IN STUDENT.STUD_ID%TYPE, DATA_REC OUT SYS_REFCURSOR, nRETURNCODE OUT NUMBER) AS BEGIN nRETURNCODE := 0; BEGIN OPEN DATA_REC FOR SELECT ST.NAME,A.STUD_ID,A.STATUS,S.SUB_NAME,L.LEC_NUM FROM SUBJECT S,ATTENDANCE A,LECTURE L, STUDENT ST WHERE A.STUD_ID = nSTUD_ID AND A.LEC_ID = L.LEC_ID AND S.SUB_ID = L.SUB_ID AND ST.STUD_ID = nSTUD_ID; END; EXCEPTION WHEN OTHERS THEN nRETURNCODE := -18; END S_MYATTENDANCE; END PA_ATTENDANCE; / CREATE SEQUENCE "TEST_ID_SEQ" MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER NOCYCLE / CREATE SEQUENCE "SUB_ID_SEQ" MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE / CREATE SEQUENCE "NOTICE_ID_SEQ" MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER NOCYCLE / CREATE SEQUENCE "LEC_ID_SEQ" MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE /