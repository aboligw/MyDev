--------------------------------------------------------
--  File created - Thursday-February-15-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PA_ATTENDANCE
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "VB"."PA_ATTENDANCE" 
AS
  
  PROCEDURE S_ATTENDANCE(
      nCLASS_ID   IN LECTURE.CLASS_ID%TYPE,
      nLEC_NUM  IN LECTURE.LEC_NUM%TYPE,
      nTEACER_ID IN LECTURE.TEACHER_ID%TYPE,
      DATA_REC OUT SYS_REFCURSOR,
      nRETURNCODE OUT NUMBER);
      
      PROCEDURE S_MYATTENDANCE(
      nSTUD_ID IN STUDENT.STUD_ID%TYPE,
      DATA_REC OUT SYS_REFCURSOR,
      nRETURNCODE OUT NUMBER);
  
END PA_ATTENDANCE;

/
