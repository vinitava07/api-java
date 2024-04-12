create database rpg_go;
create schema rpg_go;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table if not exists rpg_go.user(

id uuid default uuid_generate_v4() primary key,
name varchar(255) UNIQUE,
password varchar(255)

);

create table if not exists rpg_go.sheet(

name varchar(255),
class varchar(30),
race varchar(30),
p_level numeric,
spells text,
u_sheet uuid references rpg_go.user(id)

);

create table if not exists rpg_go.table_master(

id uuid default uuid_generate_v4() primary key,
name varchar(255) references rpg_go.user(name)

);

create table if not exists rpg_go.table (

id uuid default uuid_generate_v4() primary key,
name varchar(255) UNIQUE,
master uuid references rpg_go.table_master(id)

);

create table if not exists rpg_go.room(

room_user varchar(255) references rpg_go.user(name),
room_table varchar(255) references rpg_go.table(name)

);