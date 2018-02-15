
alter table STUDENT disable constraint SYS_C004057;
alter table TEST disable constraint SYS_C004060;
alter table REPORT disable constraint SYS_C004062;
alter table REPORT disable constraint SYS_C004061;
alter table TEACHER disable constraint SYS_C004065;
alter table STUDENT disable constraint LOGIN_FK;
alter table TEASUB_LINK disable constraint SYS_C004068;
alter table TEASUB_LINK disable constraint SYS_C004067;
alter table LECTURE disable constraint SYS_C004072;
alter table LECTURE disable constraint SYS_C004071;
alter table LECTURE disable constraint SYS_C004070;
alter table ATTENDANCE disable constraint SYS_C004074;
alter table ATTENDANCE disable constraint SYS_C004073;
alter table STUDNOTE_LINK disable constraint SYS_C004154;

 TRUNCATE TABLE CLASS;
TRUNCATE TABLE STUDENT;
TRUNCATE TABLE SUBJECT;
TRUNCATE TABLE TEST;
TRUNCATE TABLE REPORT;
TRUNCATE TABLE LOGIN;
TRUNCATE TABLE TEACHER;
TRUNCATE TABLE TEASUB_LINK;
TRUNCATE TABLE LECTURE;
TRUNCATE TABLE ATTENDANCE;
TRUNCATE TABLE NOTICE;
TRUNCATE TABLE STUDNOTE_LINK;

alter table STUDENT enable constraint SYS_C004057;
alter table TEST enable constraint SYS_C004060;
alter table REPORT enable constraint SYS_C004062;
alter table REPORT enable constraint SYS_C004061;
alter table TEACHER enable constraint SYS_C004065;
alter table STUDENT enable constraint LOGIN_FK;
alter table TEASUB_LINK enable constraint SYS_C004068;
alter table TEASUB_LINK enable constraint SYS_C004067;
alter table LECTURE enable constraint SYS_C004072;
alter table LECTURE enable constraint SYS_C004071;
alter table LECTURE enable constraint SYS_C004070;
alter table ATTENDANCE enable constraint SYS_C004074;
alter table ATTENDANCE enable constraint SYS_C004073;
alter table STUDNOTE_LINK enable constraint SYS_C004154;

DROP SEQUENCE "VB"."LEC_ID_SEQ";
DROP SEQUENCE "VB"."NOTICE_ID_SEQ";
DROP SEQUENCE "VB"."SUB_ID_SEQ";
DROP SEQUENCE "VB"."TEST_ID_SEQ";
--------------------------------------------------------
--  DDL for Sequence LEC_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "VB"."LEC_ID_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence NOTICE_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "VB"."NOTICE_ID_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SUB_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "VB"."SUB_ID_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TEST_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "VB"."TEST_ID_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
