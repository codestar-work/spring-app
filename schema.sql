create database database1 default charset=utf8;
create user 'user'@'localhost' identified by 'password';
grant all on database1.* to 'user'@'localhost';
-- set password for 'user'@'localhost' = password('');

use database1;
-- drop table if exists users;
create table users (
  id         serial,
  email      nvarchar(255) unique,
  password   varchar(2047),
  name       nvarchar(2047)
);

insert into users(name, email, password)
  values('User', 'user@codestar.work', sha2('password', 256));

insert into users(name, email, password)
  values('Support', 'support@codestar.work', sha2('password', 256));

create table posts (
  id         serial,
  user       bigint,
  topic      nvarchar(2047),
  detail     nvarchar(16383)
);


-- end
