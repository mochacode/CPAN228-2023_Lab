create table if not exists item (
  id identity,
  name varchar(50) not null,
  year int not null,
  price double not null,
  brand_from varchar(50) not null,
   created_at timestamp not null
);