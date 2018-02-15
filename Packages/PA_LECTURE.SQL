--------------------------------------------------------
--  File created - Thursday-February-15-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PA_LECTURE
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "VB"."PA_LECTURE" 
AS
  PROCEDURE I_LECTURE(
      nSUB_ID     IN LECTURE.SUB_ID%TYPE,
      nCLASS_ID   IN LECTURE.CLASS_ID%TYPE,
      nTEACHER_ID IN LECTURE.TEACHER_ID%TYPE,
      dLEC_DATE   IN LECTURE.LEC_DATE%TYPE,
      nDURATION   IN LECTURE.DURATION%TYPE,
      nLEC_NUM    IN LECTURE.LEC_NUM%TYPE,
      nLEC_ID OUT LECTURE.LEC_ID%TYPE,
      nRETURNCODE OUT NUMBER);
      
        PROCEDURE S_LECTURE(
      dLEC_DATE   IN LECTURE.LEC_DATE%TYPE,
      nCLASS_ID   IN LECTURE.CLASS_ID%TYPE,
      nLEC_NUM IN LECTURE.LEC_NUM%TYPE,
      nTEACHER_ID IN LECTURE.TEACHER_ID%TYPE,
      nLEC_ID OUT LECTURE.LEC_ID%TYPE,
      nRETURNCODE OUT NUMBER);
      
END PA_LECTURE;

/
