create sequence hibernate_sequence start with 1 increment by 1
create table employee (id integer not null, airst_name varchar(255), email varchar(255), last_name varchar(255), phone varchar(255), primary key (id))
create table employee (id integer not null, airst_name varchar(255), email varchar(255), last_name varchar(255), phone varchar(255), primary key (id)) engine=InnoDB
create table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
create table employee (id integer not null, airst_name varchar(255), email varchar(255), last_name varchar(255), phone varchar(255), primary key (id)) engine=InnoDB
create table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
create table employee (id integer not null, airst_name varchar(255), email varchar(255), last_name varchar(255), phone varchar(255), primary key (id)) engine=InnoDB
create table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
create table employee (id integer not null, airst_name varchar(255), email varchar(255), last_name varchar(255), phone varchar(255), primary key (id)) engine=InnoDB
create table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
create table employee (id integer not null, airst_name varchar(255), email varchar(255), last_name varchar(255), phone varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
