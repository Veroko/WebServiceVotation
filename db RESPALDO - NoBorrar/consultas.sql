
create database votos_sistem;
--drop database votos_sistem;
use votos_sistem;


/*Tabla candidato*/
SELECT candidato.id, persona.rut, persona.nombre, partido.nombre_partido
FROM candidato, persona, partido
WHERE candidato.persona_fk = persona.id AND candidato.partido_fk = partido.id;

SELECT candidato.id, persona.rut, persona.nombre, partido.nombre_partido
FROM candidato, persona, partido
WHERE candidato.persona_fk = persona.id AND candidato.partido_fk = partido.id AND
candidato.id = 1


/*Cantidad de Votos*/
SELECT candidato_fk as 'candidato', count(persona_fk) as 'cantidad' from voto
group by candidato_fk;


SELECT candidato_fk as 'candidato', count(persona_fk) as 'cantidad' from voto
where candidato_fk = 1;

SELECT count(id) from candidato where id = 2;
SELECT count(id) from candidato where id = 21;

/*persona*/
SELECT persona.id, persona.rut, persona.nombre, nacionalidad.nombre_nacionalidad, pais.nombre_pais, tipo_usuario.privilegio, sufragio
from persona, nacionalidad, pais, tipo_usuario
where persona.nacionalidad_fk = nacionalidad.id and persona.pais_fk = pais.id and tipo_usuario.id = persona.tipo_usuario_fk;


/*Select todo*/

select * from pais;
select * from nacionalidad;
select * from tipo_usuario;
select * from partido;
select * from persona;
select * from candidato;
select * from voto;