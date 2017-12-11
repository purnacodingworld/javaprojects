CREATE TABLE USERS
(
  CIN VARCHAR2(20) not null,
  USER_NAME varchar2(12) not null,
  PASSWORD varchar2(10) not null,
  FULL_NAME varchar2(40) not null,
  DOB DATE,
  IS_ACTIVE varchar2(1) default 'Y',
  CONSTRAINT USERS_CIN_USER_NAME_PK PRIMARY KEY (CIN,USER_NAME)
)
/
