
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
    PRIMARY KEY (codeCountry, codeCity , phoneNumber)

);


Insert into Employe (firstname, surname, projectName,department,email) values('qwe','ewq','asd','zxc','asd@da.ru');
Insert into Department (department,chief_id) values ('zxc',1);
Insert into Telephone(clientid,codeCountry,codeCity,phoneNumber,mobile) values(1,7,915,0388402,true);

select * from employe;
select * from Department;
select * from Telephone;