create database leituradb;
use leituradb;

create table consumidor (
id_consumidor int not null auto_increment primary key,
nome varchar (20) not null,
cpf varchar (11) not null,
contato varchar(20)
);

create table endereco (
id_endereco int not null auto_increment primary key,
rua varchar (30) not null,
numero int,
complemento varchar (40),
id_distrito integer not null,
constraint fk_endereco_distrito foreign key (id_distrito) references distrito (id_distrito)
);

create table hidrometro (
id_hidrometro int not null auto_increment primary key,
leitura_instalacao double not null,
situacao boolean not null,
id_consumidor integer not null,
constraint fk_hidrometro_consumidor foreign key (id_consumidor) references consumidor (id_consumidor),
id_endereco integer not null,
constraint fk_hidrometro_endereco foreign key (id_endereco) references endereco (id_endereco)
);

create table poco (
id_poco int not null auto_increment primary key,
unidade_consumidora varchar (20) not null,
id_distrito integer not null,
constraint fk_distrito_poco foreign key (id_distrito) references distrito (id_distrito)
);

create table despesa (
id_despesa int not null auto_increment primary key,
mes_vigente date not null,
valor_fatura_energia double not null,
id_poco integer not null,
constraint fk_despesa_poco foreign key (id_poco) references poco (id_poco)
);

create table fatura (
id_fatura int not null auto_increment primary key,
taxa_administrativa double not null,
valor_metro_cubico double not null,
valor_fatura double not null,
mes_referencia varchar (15) not null,
data_vencimento varchar (20) not null,
situacao boolean,
id_leitura integer not null,
constraint fk_fatura_leitura foreign key (id_leitura) references leitura (id_leitura)
);

create table distrito (
id_distrito  int not null auto_increment primary key,
nome_distrito varchar (20) not null,
cidade varchar (20)not null
);

create table leitura(
id_leitura int not null auto_increment primary key,
mes_referencia date not null,
leitura_mes_anterior double not null,
leitura_mes_atual double not null,
id_hidrometro integer not null,
constraint fk_leitura_hidrometro foreign key (id_hidrometro) references hidrometro (id_hidrometro),
id_usuario integer not null,
constraint fk_leitura_usuario foreign key (id_usuario) references usuario (id_usuario)
);

create table usuario(
id_usuario int not null auto_increment primary key,
tipo_usuario varchar (20) not null,
login varchar (20) not null,
senha int not null
);