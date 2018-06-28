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

insert into persona values(null, '11111111-1', 'Nilsson Aurelio Loyola ilabaca', 1, 1, 1, 1);
insert into persona values(null, '19851468-3', 'Diego Henriquez Miranda', 1, 1, 1, 1);
insert into persona values(null, '17333972-5', 'Cristian Estay Valenzuela', 1, 1, 1, 1);
insert into persona values(null, '19527116-k', 'Eduardo Ignacio Rubio Cabello', 1, 1, 1, 1);
insert into persona values(null, '16564067-5', 'Patricio Nicolas Perex Pinto', 1, 1, 1, 1);
insert into persona values(null, '19683832-5', 'Constanza Solange Sandoval Sandoval', 1, 1, 1, 1);
insert into persona values(null, '19265274-k', 'Jose Patricio Jara Aranguiz', 1, 1, 1, 1);
insert into persona values(null, '13391125-1', 'Patricia Isabel Sandoval Cea', 1, 1, 1, 1);
insert into persona values(null, '19589207-5', 'Karen Lizette Cabrera Gonzalez', 1, 1, 1, 1);
insert into persona values(null, '19588556-7', 'Pedro Ignacio Espinoza Severino', 1, 1, 1, 1);
insert into persona values(null, '19590530-4', 'María Pabla Michelle Cavieres San Martín', 1, 1, 1, 1);
insert into persona values(null, '10911001-5', 'Susana Giovanna San Martín Saez', 1, 1, 1, 1);
insert into persona values(null, '24548648-9', 'Trinidad Belen Hayde Cavieres', 1, 1, 1, 0);


/*Candidato*/
insert into candidato values(null, 1, 3);
insert into candidato values(null, 2, 2);

/*Voto*/
insert into voto values(null, 1, 1);
insert into voto values(null, 2, 1);
insert into voto values(null, 3, 2);
