--------------------------------------------------------
--  File created - Thursday-February-15-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PA_STUDENT
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "VB"."PA_STUDENT" 
AS
  PROCEDURE S_STUDENT(
      nID    IN STUDENT.STUD_ID%TYPE,
      sNAME  IN STUDENT.NAME%TYPE,
      nCLASS IN STUDENT.CLASS_ID%TYPE,
      STUD_REC OUT SYS_REFCURSOR);
      
  PROCEDURE GET_STUDENT_ROLL(
      nUSER_ID IN STUDENT.USER_ID%TYPE,
      STUD_REC OUT SYS_REFCURSOR,
      nRETURNCODE OUT NUMBER);
      
  PROCEDURE GET_STUDENT_FROM_SCHOOL(
      nCLASS_ID IN STUDENT.CLASS_ID%TYPE,
      STUD_REC OUT SYS_REFCURSOR,
      nRETURNCODE OUT NUMBER);
      
END PA_STUDENT;

/
