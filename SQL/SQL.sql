--create by:   Nguyen Duc Nam
--email: 	   nam03031999@gmail.com
--link github: https://github.com/NamNguyen03
--create date: 01/08/2020 (mm/dd/yyyy) 

create database ResourceServerDB

go

use ResourceServerDB

go

create table t_user(
	user_username nvarchar(64) primary key,
	user_password nvarchar(256),
	user_fullname nvarchar(64),
	user_role nvarchar(16)
)
create table oauth_client_details (
  client_id varchar(255) not null,
  client_secret varchar(255) not null,
  web_server_redirect_uri varchar(2048) default null,
  scope varchar(255) default null,
  access_token_validity int null,
  refresh_token_validity int null,
  resource_ids varchar(1024) default null,
  authorized_grant_types varchar(1024) default null,
  authorities varchar(1024) default null,
  additional_information varchar(4096) default null,
  autoapprove varchar(255) default null,
  primary key (client_id)
)

create table oauth_refresh_token (
  token_id VARCHAR(256),
  token VARBINARY(max),
  authentication VARBINARY(max)
);

create table oauth_code (
  code VARCHAR(256), 
  authentication VARBINARY(max)
);

create table oauth_client_token (
  token_id VARCHAR(256),
  token VARBINARY(max),
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

create table oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt datetime,
	lastModifiedAt datetime
);
create table oauth_access_token (
  token_id VARCHAR(256),
  token VARBINARY(max),
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication VARBINARY(max),
  refresh_token VARCHAR(256)
);

INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information)
VALUES ('mobile', '$2a$10$gPhlXZfms0EpNHX0.HHptOhoFD1AoxSr/yUIdTqA8vtjeP4zi0DDu', 'http://localhost:8081/oauth/callback', 'READ,WRITE', '3600', '10000', 'inventory,payment', 'authorization_code,password,refresh_token,implicit', '{}');
