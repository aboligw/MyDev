--------------------------------------------------------
--  File created - Thursday-February-15-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PA_TEST
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "VB"."PA_TEST" 
AS
  PROCEDURE I_TEST(
      nSUB_ID     IN TEST.SUB_ID%TYPE,
      nTOT_MKS IN TEST.TOT_MKS%TYPE,
      nCLASS_ID   IN TEST.CLASS_ID%TYPE,
      nRETURNCODE OUT NUMBER);
      
        PROCEDURE S_TEST(
      nSUB_ID     IN TEST.SUB_ID%TYPE,
      nCLASS_ID   IN TEST.CLASS_ID%TYPE,
      nTEST_NUM   IN TEST.TEST_NUM%TYPE,
      nTEST_ID    OUT TEST.TEST_ID%TYPE,
      nRETURNCODE OUT NUMBER);
      
END PA_TEST;

/
