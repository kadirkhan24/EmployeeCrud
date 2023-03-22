
select * from employee;

drop table EMPLOYEE;

CREATE TABLE employee (
   id Number(10) NOT NULL ,
   first_name varchar2(45) DEFAULT NULL,
   last_name varchar2(45) DEFAULT NULL,
   email varchar2(45) DEFAULT NULL,
   age varchar2(45) DEFAULT NULL,
  PRIMARY KEY (id)
);


INSERT ALL
  INTO employee VALUES (1,'Raj ','Verma','raj.verma@imagine.com','35')
  INTO employee VALUES (2,'Vaibhav','Telang','v.telang@futureready.com','29') 
  INTO employee VALUES (3,'Ketan','Bahadur','k.bahadur@infonext.com','32')
  INTO employee VALUES (4,'Abhishek','Raj','abhi.raj@softsol.com','30')
  SELECT * FROM dual  ;
	
create sequence id_seq  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1;