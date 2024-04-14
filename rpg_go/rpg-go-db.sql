create database rpg_go;
create schema rpg_go;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table if not exists rpg_go.user(

id numeric primary key UNIQUE,
name varchar(255) UNIQUE,
password varchar(255)

);

create table if not exists rpg_go.sheet(

id numeric primary key,
name varchar(255),
class varchar(30),
race varchar(30),
p_level numeric,
spells text,
u_sheet numeric references rpg_go.user(id)

);


create table if not exists rpg_go.table (

id numeric primary key,
name varchar(255) UNIQUE,
master_id numeric references rpg_go.user(id)

);

create table if not exists rpg_go.room(

id numeric primary key,
user_id numeric references rpg_go.user(id),
table_id numeric references rpg_go.table(id),
sheet_id numeric references rpg_go.sheet(id)

);