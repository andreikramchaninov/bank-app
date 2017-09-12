create table if not exists customer (
	id int(10) not null auto_increment,
  fullname varchar(30) not null,
  address varchar(75) not null,
  age int(10) not null,
  primary key (id)
);

create table if not exists bank_account (
	id int(10) not null auto_increment,
  customer_id int(10) not null,
  money decimal(15, 2) not null,
  primary key (id),
  constraint foreign key (customer_id) references customer (id)
);

create table if not exists bank_operation (
	id int (10) not null auto_increment,
  account_id int(10) not null,
  op_type tinyint(1) not null,
  money decimal(15, 2) not null,
  op_date timestamp not null,
  primary key (id),
  constraint foreign key (account_id) references bank_account (id)
);