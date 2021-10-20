drop table if exists forum_sub;
drop table if exists topic_sub;
drop table if exists reply_sub;


create table forum_sub (
    id  integer primary key,
    name varchar(255)
);

create table topic_sub (
    id  integer primary key,
    name varchar(255),
    content varchar(8000),
    date varchar(255)
);

create table topic_sub (
    fId int,
    id  integer primary key,
    name varchar(255),
    subject varchar(255),
    content varchar(8000),
    date varchar(255)
);