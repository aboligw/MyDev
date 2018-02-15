--------------------------------------------------------
--  File created - Thursday-February-15-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PA_TEACHER
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "VB"."PA_TEACHER" 
AS
  PROCEDURE S_TEACHER(
      sUSERID IN TEACHER.USER_ID%TYPE,
      nID     IN TEACHER.TEACHER_ID%TYPE,
      sNAME   IN TEACHER.TEACHER_NAME%TYPE,
      TEACHER_REC OUT SYS_REFCURSOR);
END PA_TEACHER;

/
