
drop database TelBook;


create database TelBook;
use TelBook;

create table Employe(
	firstName varchar(20)  not null ,
	surname varchar(20)  not null,
	projectName varchar(20),
	department varchar(20) ,
	email varchar(20),
	id int not null auto_increment primary key

);

create table Department(
	department varchar(20),
	chief_id int
);

create table Telephone(
	clientid int not null,
	codeCountry int not null,
	codeCity int not null,
	phoneNumber int not null,
	mobile boolean not null,
	stringNumber varchar(20) not null primary key

);


Insert into Employe (firstname, surname, projectName,department,email) values('f1n','f1s','p1','dep1','email_1@mail.ru');
Insert into Employe (firstname, surname, projectName,department,email) values('f2n','f2s','p1','dep1','email_2@mail.ru');
Insert into Employe (firstname, surname, projectName,department,email) values('f3n','f3s','p1','dep1','email_3@mail.ru');
Insert into Employe (firstname, surname, projectName,department,email) values('f4n','f4s','p2','dep1','email_4@mail.ru');
Insert into Employe (firstname, surname, projectName,department,email) values('f5n','f5s','p2','dep1','email_5@mail.ru');
Insert into Employe (firstname, surname, projectName,department,email) values('f6n','f6s','p2','dep1','email_6@mail.ru');
Insert into Employe (firstname, surname, projectName,department,email) values('f7n','f7s','p3','dep2','email_7@mail.ru');
Insert into Employe (firstname, surname, projectName,department,email) values('f8n','f8s','p3','dep2','email_8@mail.ru');
Insert into Employe (firstname, surname, projectName,department,email) values('f9n','f9s','p3','dep2','email_9@mail.ru');
Insert into Employe (firstname, surname, projectName,department,email) values('f10n','f10s','p4','dep3','email_10@mail.ru');
Insert into Employe (firstname, surname, projectName,department,email) values('f11n','f11s','p4','dep3','email_11@mail.ru');
Insert into Employe (firstname, surname, projectName,department,email) values('f12n','f12s','p4','dep3','email_12@mail.ru');
Insert into Employe (firstname, surname, projectName,department,email) values('f13n','f13s','p4','dep3','email_13@mail.ru');
Insert into Employe (firstname, surname, projectName,department,email) values('f14n','f14s','p5','dep4','email_14@mail.ru');
Insert into Employe (firstname, surname, projectName,department,email) values('f15n','f15s','p6','dep4','email_15@mail.ru');

Insert into Department (department,chief_id) values ('dep1',1);
Insert into Department (department,chief_id) values ('dep2',7);
Insert into Department (department,chief_id) values ('dep3',12);
Insert into Department (department,chief_id) values ('dep4',15);


Insert into Telephone(clientid,codeCountry,codeCity,phoneNumber,mobile) values(1,7,915,1111001,true, '+79151111001');
Insert into Telephone(clientid,codeCountry,codeCity,phoneNumber,mobile) values(1,7,915,1111002,true, '+79151111002');
Insert into Telephone(clientid,codeCountry,codeCity,phoneNumber,mobile) values(1,7,915,1111003,true, '+79151111003');
Insert into Telephone(clientid,codeCountry,codeCity,phoneNumber,mobile) values(1,7,915,1111004,true, '+79151111004');
Insert into Telephone(clientid,codeCountry,codeCity,phoneNumber,mobile) values(1,7,915,1111005,true, '+79151111005');
Insert into Telephone(clientid,codeCountry,codeCity,phoneNumber,mobile) values(1,7,915,1111006,true, '+79151111006');
Insert into Telephone(clientid,codeCountry,codeCity,phoneNumber,mobile) values(1,7,915,1111007,true, '+79151111007');
Insert into Telephone(clientid,codeCountry,codeCity,phoneNumber,mobile) values(1,7,915,1111008,true, '+79151111008');
Insert into Telephone(clientid,codeCountry,codeCity,phoneNumber,mobile) values(1,7,915,1111009,true, '+79151111009');
Insert into Telephone(clientid,codeCountry,codeCity,phoneNumber,mobile) values(1,7,915,1111010,true, '+79151111010');
Insert into Telephone(clientid,codeCountry,codeCity,phoneNumber,mobile) values(1,7,915,1111011,true, '+79151111011');
Insert into Telephone(clientid,codeCountry,codeCity,phoneNumber,mobile) values(1,7,915,1111012,true, '+79151111012');
Insert into Telephone(clientid,codeCountry,codeCity,phoneNumber,mobile) values(1,7,915,1111013,true, '+79151111013');
Insert into Telephone(clientid,codeCountry,codeCity,phoneNumber,mobile) values(1,7,915,1111014,true, '+79151111014');
Insert into Telephone(clientid,codeCountry,codeCity,phoneNumber,mobile) values(1,7,915,1111015,true, '+79151111015');


select * from employe;
select * from Department;
select * from Telephone;