create table tb_condutores (

	id 					serial not null primary key,
	nome 				varchar(30) not null,
	cpf 				varchar(15) not null unique,
	telefone 			varchar(17) not null,
	tempo_pago 			TIME not null,
	tempo_desconto		TIME not null
);

insert into tb_condutores (id, nome, cpf, telefone, tempo_pago, tempo_desconto) 
	values (1, 'gabriel', '709.832.945-10', '55(45)99999-9999', '10:00', '5:00');

insert into tb_condutores (id, nome, cpf, telefone, tempo_pago, tempo_desconto)
	values (2, 'alice', '101.902,404-09', '55(43)98888-8888', '12:00', '3:00');

create type cor as enum ('amarelo', 'azul', 'branco', 'preto', 'prata', 'verde', 'vermelho');
create type tipo as enum ('carro', 'moto', 'van');

create table tb_veiculos (

	id 				serial not null primary key,
	placa 			varchar(10) not null unique,
	modelo_id 		integer not null,
	cor 			cor not null,
	tipo			tipo not null,
	ano 			integer not null
)

alter table tb_veiculos add foreign key (modelo_id) references tb_modelos(id);

create table tb_modelos (

	id 				serial not null primary key,
	nome 			varchar(100) not null,
	marca_id 		integer not null
)

alter table tb_modelos add foreign key (marca_id) references tb_marcas(id);

create table tb_marcas (

	id 		serial not null primary key,
	nome 	varchar(100) not null
)

select * from tb_marcas;