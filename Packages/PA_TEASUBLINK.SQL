--------------------------------------------------------
--  File created - Thursday-February-15-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PA_TEASUBLINK
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "VB"."PA_TEASUBLINK" 
AS
  PROCEDURE S_TEASUBLINK(
      nTID IN TEASUB_LINK.TEACHER_ID%TYPE,
      nSID OUT TEASUB_LINK.SUB_ID%TYPE);
END PA_TEASUBLINK;

/

create or replace PACKAGE BODY PA_TEASUBLINK AS PROCEDURE S_TEASUBLINK( nTID IN TEASUB_LINK.TEACHER_ID%TYPE, nSID OUT TEASUB_LINK.SUB_ID%TYPE) AS BEGIN SELECT SUB_ID INTO nSID FROM TEASUB_LINK WHERE TEACHER_ID = nTID; END S_TEASUBLINK; END PA_TEASUBLINK;