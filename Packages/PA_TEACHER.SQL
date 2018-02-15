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


create or replace PACKAGE BODY PA_TEACHER AS PROCEDURE S_TEACHER( sUSERID IN TEACHER.USER_ID%TYPE, nID IN TEACHER.TEACHER_ID%TYPE, sNAME IN TEACHER.TEACHER_NAME%TYPE, TEACHER_REC OUT SYS_REFCURSOR)AS BEGIN OPEN TEACHER_REC FOR SELECT USER_ID , TEACHER_ID, TEACHER_NAME FROM TEACHER WHERE USER_ID = sUSERID AND (sName IS NULL OR TEACHER_NAME=sName) AND (nID IS NULL OR nID=0 OR nID=TEACHER_ID); --END; END S_TEACHER; END PA_TEACHER;/