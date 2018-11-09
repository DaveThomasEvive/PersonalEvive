/*
create table activity
(
   upin integer not null,
   client_code varchar(255) not null,
   vendor varchar(255),
   created_at timestamp,
   data varchar(255),
   primary key(upin,client_code,vendor,created_at)
);*/

INSERT INTO ACTIVITY (UPIN, CLIENT_CODE, VENDOR, CREATED_AT, DATA ) VALUES(10001,  '1001', 'Livango',dateadd(year,-5,sysdate()),'register');
INSERT INTO ACTIVITY (UPIN, CLIENT_CODE, VENDOR, CREATED_AT, DATA ) VALUES(10001,  '1001', 'Livango',dateadd(year,-4,sysdate()),'logon');
INSERT INTO ACTIVITY (UPIN, CLIENT_CODE, VENDOR, CREATED_AT, DATA ) VALUES(10001,  '1001', 'Livango',dateadd(year,-3,sysdate()),'logon');
INSERT INTO ACTIVITY (UPIN, CLIENT_CODE, VENDOR, CREATED_AT, DATA ) VALUES(10001,  '1001', 'Livango',dateadd(year,-2,sysdate()),'logon');
INSERT INTO ACTIVITY (UPIN, CLIENT_CODE, VENDOR, CREATED_AT, DATA ) VALUES(10001,  '1001', 'Livango',dateadd(year,-1,sysdate()),'logon');
INSERT INTO ACTIVITY (UPIN, CLIENT_CODE, VENDOR, CREATED_AT, DATA ) VALUES(10002,  '1001', 'Livango',dateadd(year,-5,sysdate()),'register');
INSERT INTO ACTIVITY (UPIN, CLIENT_CODE, VENDOR, CREATED_AT, DATA ) VALUES(10003,  '1002', 'Livango',dateadd(year,-5,sysdate()),'register');
INSERT INTO ACTIVITY (UPIN, CLIENT_CODE, VENDOR, CREATED_AT, DATA ) VALUES(10004,  '1003', 'Livango', {ts '2016-06-01 01:30:00.100'}, 'register');
INSERT INTO ACTIVITY (UPIN, CLIENT_CODE, VENDOR, CREATED_AT, DATA ) VALUES(10004,  '1003', 'Livango', {ts '2016-06-02 01:30:00.100'}, 'logon');