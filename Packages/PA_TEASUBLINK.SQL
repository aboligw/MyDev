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
