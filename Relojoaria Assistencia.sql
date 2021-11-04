/**
 Sistema para uma gestão de uma assistencia tecnica relogios 
 @autor Marcelo Faquim Dos Anjos
*/

create database dbrelojoaria;
use dbrelojoaria;

create table usuarios(
id int primary key auto_increment,
usuario varchar(50) not null,
login varchar(50) not null unique,
senha varchar(250)not null,
perfil varchar(50) not null
);

describe usuarios;

insert into usuarios(usuario,login,senha,perfil)
values('Marcelo Faquim','admin',md5('123456'),'administrador');

insert into usuarios(usuario,login,senha,perfil)
values('Vitor Augusto','admin1',md5('123456'),'administrador');

insert into usuarios(usuario,login,senha,perfil)
values('José Assis', 'jose', md5('123456'),'operador');

select*from usuarios where login = 'admin'and senha=md5('123456');

select* from usuarios where login='admin' and senha=md5('123456');

select* from usuarios where login='admin1' and senha=md5('123456');

select* from usuarios where login='jose' and senha=md5('123456');


create table clientes(
idcli int primary key auto_increment,
nome varchar(50) not null,
cep char(8),
endereço varchar(50) not null,
numero varchar(12) not null,
complemento varchar(30),
bairro varchar(50) not null,
cidade varchar(50) not null,
email varchar(70) unique not null,
fone varchar(15) not null

);

select*from clientes;
describe clientes;



insert into clientes(nome,cep,endereço,numero,complemento,bairro,cidade,email,fone)
values ('Maithe Faquim','03043070','R.Domingos Paiva', '206','apto 409B','Brás','São Paulo','maithe@email.com','945992386');

insert into clientes(nome,cep,endereço,numero,complemento,bairro,cidade,email,fone)
values ('Augusto','01224010','R.Martinico Prado', '361','apto 43','Brás','São Paulo','Augusto@email.com','40028922');

insert into clientes(nome,cep,endereço,numero,complemento,bairro,cidade,email,fone)
values ('João Carlos','01305000','R.Augusta', '522','apto 11','Consolação','São Paulo','jc@email.com','5082-4355');

insert into clientes(nome,cep,endereço,numero,complemento,bairro,cidade,email,fone)
values ('Willian','01226030','R.Barão de Tatui', '222','Casa 01','Vila Buarque','São Paulo','will@email.com','30033030');

insert into clientes(nome,cep,endereço,numero,complemento,bairro,cidade,email,fone)
values ('Roberto Andrade Carlos','01228010','R.Dona Veridiana', '250','apto 110','Higenopolis','São Paulo','rac@email.com','22856699');

insert into clientes(nome,cep,endereço,numero,complemento,bairro,cidade,email,fone)
values ('Adriano','01409010','R.Tatui', '222','apto 250','Jardim Paulista','São Paulo','adriano@email.com','98755460');

insert into clientes(nome,cep,endereço,numero,complemento,bairro,cidade,email,fone)
values ('Shirley','05416001','R.Frandique Coutinho', '750','apto 49B','Pinheiros','São Paulo','shirley@email.com','30045894');

insert into clientes(nome,cep,endereço,numero,complemento,bairro,cidade,email,fone)
values ('Vanessa Favorito','05407000','R.Cardeal Arcoverde', '850','apto 206','Pinheiros','São Paulo','Vanessa_favorito@email.com','977824520');

delete from clientes where idcli=4;

create table tbos(
os int primary key auto_increment,
dataos timestamp default current_timestamp,
tipo varchar(20) not null,
marca varchar(50) not null,
statusos varchar(30) not null,
modelo varchar(200) not null,
defeito varchar(200)not null,
tecnico varchar(50),
valor decimal(10,2),
idcli int not null,
foreign key(idcli) references clientes(idcli)
);


describe tbos;

insert into tbos
(tipo,marca,statusos,modelo,defeito,idcli)
values
('orçamento','Tommy Hilfiger','bancada','1791804','acabou a bateria',1);

insert into tbos
(tipo,marca,statusos,modelo,defeito,idcli)
values
('orçamento','Ballon Bleu de Cartier','bancada','extrafino 40mm','Trocar a pulseira',1);


insert into tbos
(tipo,marca,statusos,modelo,defeito,idcli)
values
('serviço','Lacoste','retirado','2011093','Trocar de ponteiros',2);

insert into tbos
(tipo,marca,statusos,modelo,defeito,idcli)
values
('orçamento','Lacoste','aguardando a aprovação','2011001','Trocar de vidro',2);

select*from tbos;

select * from tbos inner join clientes
on tbos.idcli = clientes.idcli;

select tbos.os,date_format(tbos.dataos,'%d/%m/%Y - %H:%i') as data_os, tbos.modelo,tbos.defeito,tbos.valor,clientes.nome as cliente
from tbos inner join clientes on tbos.idcli = clientes.idcli where statusos = 'retirado';

select tbos.modelo, tbos.defeito,tbos.statusos as stautus_os,tbos.valor,clientes.nome,clientes.fone from tbos inner join clientes on tbos.idcli = 
clientes.idcli where statusos = 'aguardando a aprovação';




