create database database1 default charset=utf8;
create user 'user'@'localhost' identified by 'password';
grant all on database1.* to 'user'@'localhost';
-- set password for 'user'@'localhost' = password('');

use database1;
-- drop table if exists users;
create table users (
  id         serial,
  email      nvarchar(200) unique,
  password   varchar(2048),
  name       nvarchar(2048)
);

insert into users(name, email, password)
  values('User', 'user@codestar.work', sha2('password', 256));

insert into users(name, email, password)
  values('Support', 'support@codestar.work', sha2('password', 256));

-- drop table if exists posts;
create table posts (
  id         serial,
  user       bigint,
  topic      nvarchar(2048),
  detail     nvarchar(16384),
  file       nvarchar(1024)
);


-- end
