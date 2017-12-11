CREATE USER banking
  IDENTIFIED BY banking;
  
CREATE SCHEMA AUTHORIZATION banking
    CREATE TABLE banking.USERS
(
  CIN VARCHAR2(9) not null,
  USER_NAME varchar2(12) not null,
  PASSWORD varchar2(15) not null,
  FULL_NAME varchar2(40) not null,
  DOB DATE,
  IS_ACTIVE varchar2(1) default 'Y',
  CONSTRAINT USERS_CIN_USER_NAME_PK PRIMARY KEY (CIN,USER_NAME)
)
/



CREATE SCHEMA AUTHORIZATION banking
   CREATE TABLE banking.USERS
	(
	  CIN VARCHAR2(20) not null,
	  USER_NAME varchar2(12) not null,
	  PASSWORD varchar2(10) not null,
	  FULL_NAME varchar2(40) not null,
	  DOB DATE,
	  IS_ACTIVE varchar2(1) default 'Y',
	  CONSTRAINT USERS_CIN_USER_NAME_PK PRIMARY KEY (CIN,USER_NAME)
	) 
   GRANT SELECT,CREATE,UPDATE,DELETE,DAO ON USERS TO system; 
   
   CREATE SEQUENCE users
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;