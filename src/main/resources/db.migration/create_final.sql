drop table if exists packages cascade;
drop sequence if exists packages_id cascade;
create sequence packages_id start 100000001;


drop table if exists clients cascade;
drop sequence if exists clients_id cascade;
create sequence clients_id start 100000001;

create table clients(
    id_client bigint NOT NULL DEFAULT nextval('clients_id'),
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    patronymic varchar(50) not null,
    email varchar(50) not null,
    telephone varchar(20) not null primary key
);

SELECT * FROM clients;

drop table if exists offices;
drop sequence if exists offices_id cascade;
create sequence offices_id start 100000001;

create table offices(
    id_office bigint NOT NULL DEFAULT nextval('offices_id'),
    office_number bigint not null primary key,
    description varchar(255) not null
);

select * from offices;


-----

create table packages(
	id_package bigint primary key not null default nextval('packages_id'),
	telephone_sender varchar(20) references clients(telephone),
	num_office_recipient bigint references offices(office_number),
	telephone varchar(20),
	first_name varchar(50),
	last_name varchar(50),
	patronymic varchar(50),
	status varchar(20),
	date_of_create timestamp not null default now(),--,'yyyy-mm-dd hh24:mi:ss'),
	date_change_status timestamp --'yyyy-mm-dd hh24:mi:ss'
);

select * from packages;

