create table tb_condutores (

	id 					serial primary key,
	nome 				varchar(30) not null,
	cpf 				varchar(15) not null unique,
	telefone 			varchar(17) not null,
	tempo_pago 			time not null,
	tempo_desconto		time not null
);

insert into tb_condutores (id, nome, cpf, telefone, tempo_pago, tempo_desconto) 
	values (1, 'gabriel', '709.832.945-10', '55(45)99999-9999', '10:00', '5:00');

insert into tb_condutores (id, nome, cpf, telefone, tempo_pago, tempo_desconto)
	values (2, 'alice', '101.902.404-09', '55(43)98888-8888', '12:00', '3:00');
	
insert into tb_condutores (id, nome, cpf, telefone, tempo_pago, tempo_desconto)
	values (3, 'Filomena', '808.707.101-99', '55(41)94455-8833', '20:00', '2:00');

create type cor as enum ('amarelo', 'azul', 'branco', 'preto', 'prata', 'verde', 'vermelho');
create type tipo as enum ('carro', 'moto', 'van');

create table tb_veiculos (

	id 				serial primary key,
	placa 			varchar(10) not null unique,
	modelo_id 		integer not null,
	cor 			cor not null,
	tipo			tipo not null,
	ano 			integer not null
);

alter table tb_veiculos add foreign key (modelo_id) references tb_modelos(id);

insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (1, 'OLA1E23', 1, 'amarelo', 'carro', 1967);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (2, 'OPA1A10', 2,'azul', 'carro', 1964);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (3, 'HEL0E24', 3, 'preto', 'moto', 1948);

create table tb_modelos (

	id 				serial primary key,
	nome 			varchar(100) not null unique,
	marca_id 		integer not null
);

alter table tb_modelos add foreign key (marca_id) references tb_marcas(id);

insert into tb_modelos (id, nome, marca_id)
	values (1, 'Impala', 1);
	
insert into tb_modelos (id, nome, marca_id)
	values (2, 'Mustang', 2);
	
insert into tb_modelos (id, nome, marca_id)
	values (3, 'Pan Head', 3);

create table tb_marcas (

	id 		serial not primary key,
	nome 	varchar(100) not null unique
);

insert into tb_marcas (id, nome)
	values (1, 'Chevrolett');
	
insert into tb_marcas (id, nome)
	values (2, 'Fiat');
	
insert into tb_marcas (id, nome)
	values (3, 'Harley Davidson');

create table tb_movimentacoes (

	id 						serial primary key,
	veiculo_id 				integer not null unique,
	condutor_id 			integer not null,
	entrada 				timestamp not null,
	saida 					timestamp,
	tempo 					time,
	tempo_desconto		    time,
	tempo_multa 			time,
	valor_desconto 			numeric,
	valor_multa 			numeric,
	valor_total 			numeric,
	valor_hora 				numeric,
	valor_hora_multa 		numeric
);

alter table tb_movimentacoes add foreign key (veiculo_id) references tb_veiculos(id);
alter table tb_movimentacoes add foreign key (condutor_id) references tb_condutores(id);

create table tb_configuracoes (

	id							serial primary key,
	valor_hora 					numeric,
	valor_minuto_multa 			numeric,
	inicio_expediente 			time,
	fim_expediente 				time,
	tempo_para_desconto 		time,
	tempo_de_desconto			time,
	gerar_desconto 				boolean,
	vagas_carro 				integer,
	vagas_moto 					integer,
	vagas_van 					integer
);

insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada)
	values (1, 1, 1, '2023-03-22 08:10:23');
	
update tb_movimentacoes 
	set saida = '2023-03-22 09:15:34' 
		where id = 1;
		
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada)
	values (2, 2, 2, '2023-03-23 10:10:05');

update tb_movimentacoes
	set saida = '2023-03-22 11:04:45'
		where id = 2;

update tb_movimentacoes set tempo = saida - entrada;

select * from tb_modelos;