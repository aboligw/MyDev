--------------------------------------------------------
--  File created - Thursday-February-15-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PA_NOTICE
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "VB"."PA_NOTICE" 
AS
  PROCEDURE S_NOTICE(
      nSTUD_ID IN STUDENT.STUD_ID%TYPE,
      DATA_REC OUT SYS_REFCURSOR,
      nRETURNCODE OUT NUMBER);
END PA_NOTICE;

/
