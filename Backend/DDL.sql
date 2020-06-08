create table centres(
`id` int(255) not null primary key auto_increment,
`name` varchar(500) unique not null
);

create table commodities(
`id` int(255) not null primary key auto_increment,
`name` varchar(500) unique not null
);

create table regions(
`id` int(255) not null primary key auto_increment,
`name` varchar(500) unique not null
);

create table centr(
`id` int(255) not null primary key auto_increment,
`name` varchar(500) unique not null,
`latitude` varchar(500) not null,
`longitude` varchar(500) not null
);

drop table centr;


select * from centres;

select * from commodities;

select * from centr;