--------------------------------------------------------
--  File created - Thursday-February-15-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PA_REPORT
--------------------------------------------------------
CREATE OR REPLACE PACKAGE "VB"."PA_REPORT" AS
 PROCEDURE S_REPORT (
  NSTUD_ID      IN REPORT.STUD_ID%TYPE,
  NSUB_ID       IN TEST.SUB_ID%TYPE,
  DATA_REC      OUT SYS_REFCURSOR,
  NRETURNCODE   OUT NUMBER
 );

 PROCEDURE S_MYREPORT (
  NSTUD_ID      IN REPORT.STUD_ID%TYPE,
  DATA_REC      OUT SYS_REFCURSOR,
  NRETURNCODE   OUT NUMBER
 );

END PA_REPORT;
/

CREATE OR REPLACE PACKAGE BODY PA_REPORT AS

 PROCEDURE S_REPORT (
  NSTUD_ID      IN REPORT.STUD_ID%TYPE,
  NSUB_ID       IN TEST.SUB_ID%TYPE,
  DATA_REC      OUT SYS_REFCURSOR,
  NRETURNCODE   OUT NUMBER
 )
  AS
 BEGIN
  NRETURNCODE := 0;
  BEGIN
   OPEN DATA_REC FOR
    SELECT
     R.STUD_ID,
     S.NAME,
     SB.SUB_NAME,
     T.CLASS_ID,
     T.TEST_NUM,
     T.TOT_MKS,
     R.MARKS_OBT
    FROM
     TEST T,
     REPORT R,
     STUDENT S,
     SUBJECT SB
    WHERE
      T.TEST_ID = R.TEST_ID
     AND
      R.STUD_ID = NSTUD_ID
     AND
      T.CLASS_ID IN (
       SELECT
        CLASS_ID
       FROM
        TEST
       WHERE
        SUB_ID = NSUB_ID
      )
     AND
      S.STUD_ID = NSTUD_ID
     AND
      SB.SUB_ID = NSUB_ID;

  EXCEPTION
   WHEN OTHERS THEN
    NRETURNCODE :=-21;
  END;

 END S_REPORT;

 PROCEDURE S_MYREPORT (
  NSTUD_ID      IN REPORT.STUD_ID%TYPE,
  DATA_REC      OUT SYS_REFCURSOR,
  NRETURNCODE   OUT NUMBER
 )
  AS
 BEGIN
  NRETURNCODE := 0;
  BEGIN
   OPEN DATA_REC FOR
    SELECT
     S.STUD_ID,
     S.NAME,
     SB.SUB_NAME,
     T.TEST_NUM,
     T.TOT_MKS,
     R.MARKS_OBT
    FROM
     STUDENT S,
     REPORT R,
     TEST T,
     SUBJECT SB
    WHERE
      R.STUD_ID = NSTUD_ID
     AND
      R.TEST_ID = T.TEST_ID
     AND
      T.SUB_ID = SB.SUB_ID
     AND
      S.STUD_ID = NSTUD_ID;

  EXCEPTION
   WHEN OTHERS THEN
    NRETURNCODE :=-21;
  END;

 END S_MYREPORT;

END PA_REPORT;
/