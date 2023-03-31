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



select * from tb_condutores;