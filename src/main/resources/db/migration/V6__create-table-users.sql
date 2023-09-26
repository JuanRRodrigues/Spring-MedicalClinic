CREATE TABLE users (

id bigint not null auto_increment,
login varchar(100) not null,
password varchar(100) not null unique,


primary key(id)

);

