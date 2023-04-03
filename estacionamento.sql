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

insert into tb_condutores (id, nome, cpf, telefone, tempo_pago, tempo_desconto)
	values (4, 'Madaleine Honey', '504.183.909-08', '55(44)98855-2228', '15:00', '1:00');

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

insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (4, 'OBA4E30', 4, 'verde', 'van', 1970);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (5, 'OBA1E23', 1, 'amarelo', 'carro', 1964);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (6, 'OLA1A10', 2,'azul', 'carro', 1967);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (7, 'LOL0E24', 3, 'preto', 'moto', 1948);

insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (8, 'OBA4A30', 4, 'verde', 'van', 1980);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (9, 'OLA1E21', 1, 'amarelo', 'carro', 1967);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (10, 'OPA1A12', 2,'azul', 'carro', 1964);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (11, 'HEL0E25', 3, 'preto', 'moto', 1948);

insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (12, 'OBA4E31', 4, 'verde', 'van', 1970);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (13, 'OBA1E24', 1, 'amarelo', 'carro', 1964);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (14, 'OLA1A11', 2,'azul', 'carro', 1967);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (15, 'LOL0E26', 3, 'preto', 'moto', 1948);

insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (16, 'OBA4A32', 4, 'verde', 'van', 1980);

insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (17, 'ALA1E23', 1, 'amarelo', 'carro', 1967);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (18, 'APA1A10', 2,'azul', 'carro', 1964);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (19, 'AEL0E24', 3, 'preto', 'moto', 1948);

insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (20, 'ABA4E30', 4, 'verde', 'van', 1970);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (21, 'EBA1E28', 1, 'amarelo', 'carro', 1964);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (22, 'ELA1A10', 2,'azul', 'carro', 1967);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (23, 'EOL0E24', 3, 'preto', 'moto', 1948);

insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (24, 'OBA4A12', 4, 'verde', 'van', 1980);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (25, 'OLA1A22', 1, 'amarelo', 'carro', 1967);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (26, 'OIE1A10', 2,'azul', 'carro', 1964);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (27, 'HEL0A23', 3, 'preto', 'moto', 1948);

insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (28, 'OBA4E33', 4, 'verde', 'van', 1970);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (29, 'EBA2E24', 1, 'amarelo', 'carro', 1964);
	
insert into tb_veiculos (id, placa, modelo_id, cor, tipo, ano)
	values (30, 'YLA1A11', 2,'azul', 'carro', 1967);

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

insert into tb_modelos (id, nome, marca_id)
	values (4, 'Kombi', 4);

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
	
insert into tb_marcas (id, nome)
	values (4, 'Wolkswaggen');


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
		
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada)
	values (3, 3, 3, '2023-03-23 12:05:06');
	
update tb_movimentacoes	
	set saida = '2023-03-23 13:15:54'	
		where id = 3;
		
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (4, 4, 4, '2023-03-23 14:00:05', '2023-03-23 16:00:04');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (5, 5, 4, '2023-03-24 14:00:07', '2023-03-24 20:14:09');

insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (6, 6, 3, '2023-03-24 14:20:07', '2023-03-24 16:15:09');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (7, 7, 1, '2023-03-24 14:40:07', '2023-03-24 17:34:09');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (8, 8, 2, '2023-03-24 15:00:08', '2023-03-24 20:04:03');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (9, 9, 4, '2023-03-23 14:00:05', '2023-03-23 16:00:04');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (10, 10, 4, '2023-03-24 14:00:07', '2023-03-24 20:14:09');

insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (11, 11, 3, '2023-03-24 14:20:07', '2023-03-24 16:15:09');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (12, 12, 1, '2023-03-24 14:40:07', '2023-03-24 17:34:09');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (13, 13, 2, '2023-03-24 15:00:08', '2023-03-24 20:04:03');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (14, 14, 4, '2023-03-23 14:00:05', '2023-03-23 16:00:04');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (15, 15, 4, '2023-03-24 14:00:07', '2023-03-24 20:14:09');

insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (16, 16, 3, '2023-03-24 14:20:07', '2023-03-24 16:15:09');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (17, 17, 1, '2023-03-24 14:40:07', '2023-03-24 17:34:09');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (18, 18, 2, '2023-03-24 15:00:08', '2023-03-24 20:04:03');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (19, 19, 4, '2023-03-23 14:00:05', '2023-03-23 16:00:04');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (20, 20, 4, '2023-03-24 14:00:07', '2023-03-24 20:14:09');

insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (21, 21, 3, '2023-03-24 14:20:07', '2023-03-24 16:15:09');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (22, 22, 1, '2023-03-24 14:40:07', '2023-03-24 17:34:09');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (23, 23, 2, '2023-03-24 15:00:08', '2023-03-24 20:04:03');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (24, 24, 1, '2023-03-24 14:40:07', '2023-03-24 17:34:09');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (25, 25, 2, '2023-03-24 15:00:08', '2023-03-24 20:04:03');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (26, 26, 3, '2023-03-24 14:20:07', '2023-03-24 16:15:09');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (27, 27, 1, '2023-03-24 14:40:07', '2023-03-24 17:34:09');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (28, 28, 2, '2023-03-24 15:00:08', '2023-03-24 20:04:03');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (29, 29, 1, '2023-03-24 14:40:07', '2023-03-24 17:34:09');
	
insert into tb_movimentacoes (id, veiculo_id, condutor_id, entrada, saida)
	values (30, 30, 2, '2023-03-24 15:00:08', '2023-03-24 20:04:03');

update tb_movimentacoes set tempo = saida - entrada;

select * from tb_movimentacoes;