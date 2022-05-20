drop table if exists packages cascade;
drop sequence if exists packages_id cascade;
create sequence packages_id start 100000001;

---CLIENTS

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

insert into clients(first_name, last_name, patronymic, email, telephone)
select 
	'SomeName'||generate_series(1, 50, 1) as first_name,
	'SomeFamilie'||generate_series(1, 50, 1) as last_name,
	'SomePatronymic'||generate_series(1, 50, 1) as patronymic,
	generate_series(1, 50, 1)||'client.email@gmail.com' as email,
	'+38050'||(random()*10000000)::numeric(13,0) as telefon_number
from generate_series(1,1,+1) as series(value);

SELECT * FROM clients;

---OFFICES

drop table if exists offices;
drop sequence if exists offices_id cascade;
create sequence offices_id start 100000001;

create table offices(
    id_office bigint NOT NULL DEFAULT nextval('offices_id'),
    office_number bigint not null primary key,
    description varchar(255) not null
);

insert into offices(office_number, description)
select 
	generate_series(1, 50, 1) as office_number,
	'Descriprion Office № '||generate_series(1, 50, 1) as description
from generate_series(1,1,+1) as series(value);

select * from offices;

-----PACKAGES

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
	date_change_status timestamp not null default now() --'yyyy-mm-dd hh24:mi:ss'
);

insert into packages (num_office_recipient, telephone, first_name, last_name, patronymic, status, telephone_sender)
select
	generate_series(1, 50, 1) as num_office_recipient,
	'+38050'||(random()*10000000)::numeric(13,0) as telefon_number,
	'SomeName'||generate_series(1, 50, 1) as first_name,
	'SomeFamilie'||generate_series(1, 50, 1) as last_name,
	'SomePatronymic'||generate_series(1, 50, 1) as patronymic,
	'new_package' as status,
	telephone from clients as telephone_cender limit 300;

select * from packages;

---MESSAGES

drop table if exists messages;
drop sequence if exists messages_id cascade;
create sequence messages_id start 100000001;

create table messages(
    id_notification bigint NOT NULL DEFAULT nextval('messages_id'),
    num_package bigint references packages(id_package),
	text_message text,
	status varchar(20),
	date_change_status timestamp  --'yyyy-mm-dd hh24:mi:ss'
);

select * from messages;-- where status = 'new_message';

