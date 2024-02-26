create table person
( 
	id integer not null,
    name varchar(200) not null,
    location varchar(200),
    primary key(id)
);


INSERT INTO PERSON
(ID , NAME , LOCATION )
VALUES(10004, 'Abigal', 'Mumbai') ;
INSERT INTO PERSON (ID, NAME, LOCATION) 
VALUES(10001,  'Ranga', 'Hyderabad');
INSERT INTO PERSON (ID, NAME, LOCATION) 
VALUES(10002,  'James', 'New York');
INSERT INTO PERSON (ID, NAME, LOCATION) 
VALUES(10003,  'Pieter', 'Amsterdam');