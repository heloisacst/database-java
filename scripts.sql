--------> CREATE TABLES
create table ator(
	id_ator int,
	nome_ator varchar(255),
	primary key(id_ator)
);

create table filme(
	id_filme int,
	titulo_filme varchar(255),
	id_ator_filme int,
	id_produtora_filme int,
	primary key(id_filme),
	foreign key (id_ator_filme) references ator(id_ator)
);

--------> INSERT VALUES

insert into ator values (1, 'Johnny Depp'), (2, 'Chris Evans'), (3, 'Vin Diesel');
insert into filme values (1, 'Velozes e Furiosos', 3), (2, 'Animais Fantasticos e Onde Habitam', 1), (3, 'Vingadores', 2);

--------> "BACKUP"

insert into ator values (3, 'Vin Diesel');
insert into ator values (6, 'Emma Watson');
insert into filme values (1, 'Velozes e Furioso', 3);
delete from filme where filme.id_filme in (4);
delete from ator where ator.id_ator in (4, 5);

select * from ator;
select * from filme;