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


create or replace PACKAGE BODY PA_LOGIN AS PROCEDURE S_LOGIN( sID IN LOGIN.USER_ID%TYPE, sPWD IN LOGIN.PWD%TYPE, sROLE IN LOGIN.ROLE%TYPE, nRETURNCODE OUT NUMBER) AS CNT INTEGER; BEGIN BEGIN nReturnCode :=0; BEGIN SELECT COUNT(*) INTO CNT FROM LOGIN WHERE USER_ID = sID; END; IF (CNT != 1) THEN RAISE INV_USER_ID; ELSE BEGIN SELECT COUNT(*) INTO CNT FROM LOGIN WHERE USER_ID = sID AND PWD = sPWD; END; IF (CNT != 1) THEN RAISE INV_PWD; ELSE BEGIN SELECT COUNT(*) INTO CNT FROM LOGIN WHERE USER_ID = sID AND PWD = sPWD AND ROLE = sROLE; END; IF(CNT != 1) THEN RAISE INV_ROLE; END IF; END IF; END IF; EXCEPTION WHEN INV_USER_ID THEN nReturnCode := -11; WHEN INV_PWD THEN nReturnCode :=-12; WHEN INV_ROLE THEN nReturnCode :=-13; END; END S_LOGIN; END PA_LOGIN;/