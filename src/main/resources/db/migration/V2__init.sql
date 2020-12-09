create table tb_carteira
(
  id integer constraint tb_carteira_pk primary key not null
, inclusao timestamp not null
, alteracao timestamp
, status varchar(25) not null
, nome varchar(100) unique not null
, saldo numeric(12,2) not null default 0
);

create sequence seq_tb_carteira  minvalue 1 maxvalue 999999999999999 increment by 1 start with 2;

create table tb_categoria
(
  id bigint constraint tb_categoria_pk primary key not null
, inclusao timestamp not null
, alteracao timestamp
, status varchar(25) not null
, nome varchar(100) null
, codigo varchar(30) unique null
);

create sequence seq_tb_categoria  minvalue 1 maxvalue 999999999999999 increment by 1 start with 2;

create table tb_pessoa
(
  id integer constraint tb_pessoa_pk primary key not null
, inclusao timestamp not null
, alteracao timestamp
, status varchar(25) not null
, nome varchar(100) unique not null
, documento varchar(20) unique null
, telefone varchar(13)
);

create sequence seq_tb_pessoa  minvalue 1 maxvalue 999999999999999 increment by 1 start with 2;