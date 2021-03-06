create database votos_sistem;
--drop database votos_sistem;
use votos_sistem;

create table pais(
    id INT AUTO_INCREMENT,
    nombre_pais VARCHAR(50),
    PRIMARY KEY(id)
);

create table nacionalidad(
    id INT AUTO_INCREMENT,
    nombre_nacionalidad VARCHAR(50),
    PRIMARY KEY(id)
);

create table partido(
    id INT AUTO_INCREMENT,
    nombre_partido VARCHAR(50),
    PRIMARY KEY(id)
);

create table tipo_usuario(
    id INT AUTO_INCREMENT,
    privilegio VARCHAR(50),
    PRIMARY KEY(id)
);

create table persona(
    id INT AUTO_INCREMENT,
    rut VARCHAR(10) UNIQUE,
    nombre VARCHAR(100),
    nacionalidad_fk int,
    pais_fk int,
    tipo_usuario_fk int,
    sufragio boolean,
    PRIMARY KEY(id),
    FOREIGN KEY(nacionalidad_fk) REFERENCES nacionalidad(id),
    FOREIGN KEY(pais_fk) REFERENCES pais(id),
    FOREIGN KEY(tipo_usuario_fk) REFERENCES tipo_usuario(id)
);

create table candidato(
    id INT AUTO_INCREMENT,
    persona_fk INT UNIQUE,
    partido_fk int,
    PRIMARY KEY(id),
    FOREIGN KEY(persona_fk) REFERENCES persona(id),
    FOREIGN KEY(partido_fk) REFERENCES partido(id)
);

create table voto(
    id INT AUTO_INCREMENT,
    persona_fk INT UNIQUE,
    candidato_fk INT,
    PRIMARY KEY(id),
    FOREIGN KEY(persona_fk) REFERENCES persona(id),
    FOREIGN KEY(candidato_fk) REFERENCES candidato(id)
);
