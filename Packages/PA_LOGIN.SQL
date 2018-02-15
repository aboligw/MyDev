--------------------------------------------------------
--  File created - Thursday-February-15-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package PA_LOGIN
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "VB"."PA_LOGIN" 
AS
  --   PROCEDURE I_LOGIN(sID IN LOGIN.USER_ID%TYPE,
  --                  sPWD IN LOGIN.PWD%TYPE,
  --                  sROLE IN LOGIN.ROLE%TYPE,
  --                  nRETURNCODE OUT NUMBER);
  PROCEDURE S_LOGIN(
      sID   IN LOGIN.USER_ID%TYPE,
      sPWD  IN LOGIN.PWD%TYPE,
      sROLE IN LOGIN.ROLE%TYPE,
      nRETURNCODE OUT NUMBER);
  --    PROCEDURE D_LOGIN(sID IN LOGIN.USER_ID%tYPE,
  --                        nRET_VALUE OUT NUMBER);
  --    PROCEDURE U_LOGIN(sID IN LOGIN.USER_ID%TYPE,
  --                   sPWD IN LOGIN.PWD%TYPE,
  --                   sROLE IN LOGIN.ROLE%TYPE,
  --                   nRETURNCODE OUT NUMBER);
  INV_USER_ID EXCEPTION ;
  INV_PWD     EXCEPTION ;
  INV_ROLE    EXCEPTION ;
END PA_LOGIN;

/
