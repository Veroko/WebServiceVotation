create database votos_sistem;
--drop database votos_sistem;
use votos_sistem;

/*Pais*/
insert into pais values(null, 'chile');
insert into pais values(null, 'Rusia');


/*Nacionalidad*/
insert into nacionalidad values(null, 'chilena');
insert into nacionalidad values(null, 'Rusa');

/*Partido politico*/
insert into partido values(null, 'Partido Socialista');
insert into partido values(null, 'Partido Comunista');
insert into partido values(null, 'Partido Ñee');


/*Tipo Usuario*/
insert into tipo_usuario values(null, 'votante');
insert into tipo_usuario values(null, 'admin');

/*Persona*/
insert into persona values(null, '19083318-6', 'Matías Javier Silva Donoso', 1, 1, 2, 1);
insert into persona values(null, '19592387-6', 'Verónica Darla Alvarado Jimenez', 1, 1, 1, 1);
insert into persona values(null, '9289216-6', 'Francisco Javier Silva Acevedo', 1, 1, 1, 1);

/*Candidato*/
insert into candidato values(null, 1, 3);
insert into candidato values(null, 2, 2);

/*Voto*/
insert into voto values(null, 1, 1);
insert into voto values(null, 2, 1);
insert into voto values(null, 3, 2);
