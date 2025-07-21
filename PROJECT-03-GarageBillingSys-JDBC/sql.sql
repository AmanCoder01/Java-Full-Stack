create database garage;

use garage;

create table customer(
	id int auto_increment primary key,
    name varchar(30),
    phone varchar(15)
);   

select * from customer;

truncate customer;

 

show tables;

create table vehicle(
	id int auto_increment primary key,
    customer_id int,
    number_plate varchar(15),
    model varchar(10),
    foreign key (customer_id) references cus tomer(id)
); 

insert into vehicle(customer_id,number_plate,model) values(1,'UPJKDB7467','2025');

select * from vehicle;

create table service(
	id int auto_increment primary key,
    name varchar(15),
    cost double
);     

insert into service(name,cost)
values
('oil change',1500),
('Engine repair',5000),
('Tyre change',3000),
('Washing',500);

select * from service;
select * from invoice;
select * from invoice_service;


create table invoice(
	id int auto_increment primary key,
    customer_id int,
    vehicle_id int,
    date timestamp default current_timestamp,
    foreign key (customer_id) references customer(id),
	foreign key (vehicle_id) references vehicle(id)
);   

drop table service;
drop table invoice;

CREATE TABLE invoice_service (
    invoice_id INT,
    service_id INT,
    PRIMARY KEY (invoice_id, service_id),
    FOREIGN KEY (invoice_id) REFERENCES invoice(id) ON DELETE CASCADE,
    FOREIGN KEY (service_id) REFERENCES service(id) 
);

DESCRIBE service;




