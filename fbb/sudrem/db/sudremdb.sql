-- SQL create DB

-- DB sudrem

DROP TABLE IF EXISTS tempera;

CREATE TABLE tempera ( 
	id int AUTO_INCREMENT PRIMARY KEY, 
	stadt char(32) not null, 
	temperatur int default 0, 
	datum timestamp default current_timestamp);