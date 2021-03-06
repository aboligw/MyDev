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

create or replace PACKAGE BODY PA_LECTURE AS PROCEDURE I_LECTURE( nSUB_ID IN LECTURE.SUB_ID%TYPE, nCLASS_ID IN LECTURE.CLASS_ID%TYPE, nTEACHER_ID IN LECTURE.TEACHER_ID%TYPE, dLEC_DATE IN LECTURE.LEC_DATE%TYPE, nDURATION IN LECTURE.DURATION%TYPE, nLEC_NUM IN LECTURE.LEC_NUM%TYPE, nLEC_ID OUT LECTURE.LEC_ID%TYPE, nRETURNCODE OUT NUMBER) AS BEGIN BEGIN SELECT LEC_ID_SEQ.NEXTVAL INTO nLEC_ID FROM DUAL; nRETURNCODE:=0; BEGIN INSERT INTO LECTURE VALUES ( nLEC_ID, nSUB_ID, nCLASS_ID, nTEACHER_ID, TO_DATE(dLEC_DATE), nDURATION, (SELECT NVL(MAX(LEC_NUM),0)+1 FROM LECTURE WHERE CLASS_ID = nCLASS_ID AND SUB_ID = nSUB_ID ) ) ; END; EXCEPTION WHEN OTHERS THEN nRETURNCODE := -15; END; END I_LECTURE; PROCEDURE S_LECTURE( dLEC_DATE IN LECTURE.LEC_DATE%TYPE, nCLASS_ID IN LECTURE.CLASS_ID%TYPE, nLEC_NUM IN LECTURE.LEC_NUM%TYPE, nTEACHER_ID IN LECTURE.TEACHER_ID%TYPE, nLEC_ID OUT LECTURE.LEC_ID%TYPE, nRETURNCODE OUT NUMBER) AS BEGIN BEGIN nRETURNCODE := 0; SELECT LEC_ID INTO nLEC_ID FROM LECTURE WHERE dLEC_DATE = LEC_DATE AND nCLASS_ID = CLASS_ID AND nLEC_NUM = LEC_NUM AND nTEACHER_ID = TEACHER_ID; EXCEPTION WHEN OTHERS THEN nRETURNCODE := -16; END; END S_LECTURE; END PA_LECTURE;
