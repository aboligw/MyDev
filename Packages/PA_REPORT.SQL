--------------------------------------------------------
--  File created - Thursday-February-15-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PA_REPORT
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "VB"."PA_REPORT" 
AS
  
  PROCEDURE S_REPORT(
      nSTUD_ID   IN REPORT.STUD_ID%TYPE,
      nSUB_ID  IN TEST.SUB_ID%TYPE,
      DATA_REC OUT SYS_REFCURSOR,
      nRETURNCODE OUT NUMBER);
      
   PROCEDURE S_MYREPORT(
      nSTUD_ID   IN REPORT.STUD_ID%TYPE,
      DATA_REC OUT SYS_REFCURSOR,
      nRETURNCODE OUT NUMBER);
  
END PA_REPORT;

/
