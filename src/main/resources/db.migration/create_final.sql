drop table if exists clients;
drop sequence if exists clients_id cascade;
create sequence clients_id start 100000001;

create table clients(
    id_client bigint NOT NULL DEFAULT nextval('clients_id'),
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    patronymic varchar(50) not null,
    telephone varchar(20) not null primary key
);

SELECT * FROM clients;

drop table if exists offices;
drop sequence if exists offices_id cascade;
create sequence offices_id start 100000001;

create table offices(
    id_office bigint NOT NULL DEFAULT nextval('offices_id'),
    description varchar(255) not null,
    office_number varchar(50) not null primary key
);