create database rpg_go;
create schema rpg_go;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table if not exists rpg_go.user(

id integer primary key UNIQUE,
name varchar(255) UNIQUE,
password varchar(255)

);

create table if not exists rpg_go.sheet(

id integer primary key,
name varchar(255),
class varchar(30),
race varchar(30),
armor_class integer,
movement integer,
health integer,
p_level integer,
strength integer,
intelligence integer,
dexterity integer,
constitution integer,
wisdom integer,
charisma integer,
attack text,
spells text,
inventory text,
skills text,
features text,
tools text,
user_id integer references rpg_go.user(id)

);


create table if not exists rpg_go.table (

id integer primary key,
name varchar(255),
master_id integer references rpg_go.user(id)

);

create table if not exists rpg_go.room(

id integer primary key,
user_id integer references rpg_go.user(id),
table_id integer references rpg_go.table(id),
sheet_id integer references rpg_go.sheet(id)

);