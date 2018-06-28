<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It is a breeze. Simply tell Lumen the URIs it should respond to
| and give it the Closure to call when that URI is requested.
|
*/

$router->get('/', function () use ($router) {
    return $router->app->version();
});



$router->post('/api/v2/agregar_persona', function (Illuminate\Http\Request $request) use ($router) {
    //return array("eso"=>"ok");
	$rut = $request->json()->get('rut');
	$nombre = $request->json()->get('nombre');
	$nacionalidad = $request->json()->get('nombre_nacionalidad');
	$pais = $request->json()->get('nombre_pais');
	$tipo_usuario = $request->json()->get('privilegio');
	$sufragio = $request->json()->get('sufragio');
	
	DB::insert("INSERT INTO persona VALUES(null, ?, ?, ?, ?, ?, ?);",[$rut,$nombre,$nacionalidad,$pais,$tipo_usuario,$sufragio]);
});

$router->post('/api/v2/agregar_candidato', function (Illuminate\Http\Request $request) use ($router) {
    
	$persona = $request->json()->get('persona');
	$candidato = $request->json()->get('candidato');
	
	DB::insert("INSERT INTO candidato VALUES (null,?,?);",[$persona,$candidato]);
	
});

$router->post('/api/v2/agregar_partido', function (Illuminate\Http\Request $request) use ($router) {
    
	$nombre = $request->json()->get('nombre');
	
	
	DB::insert("INSERT INTO partido VALUES (null,?)",[$nombre]);
	
});

$router->get('/api/v2/candidato', function () use ($router) {
	return $results = DB::select("SELECT candidato.id, persona.rut, persona.nombre, partido.nombre_partido
								FROM candidato, persona, partido
								WHERE candidato.persona_fk = persona.id AND candidato.partido_fk = partido.id;");
});

$router->get('/api/v2/candidato/{id}', function ($id) use ($router) {
	if((DB::select("SELECT count(id) from candidato where id = $id"))== 0){
		return array("Error"=>"Candidato no encontrado");
	}else{
		return $results = DB::select("SELECT candidato.id, persona.rut, persona.nombre, partido.nombre_partido
									FROM candidato, persona, partido
									WHERE candidato.persona_fk = persona.id AND candidato.partido_fk = partido.id AND
									candidato.id = $id;");
	}								
});

$router->get('/api/v2/partido_c/{id}', function ($id) use ($router) {
	return $results = DB::select("SELECT candidato.partido_fk, partido.nombre_partido
								from candidato, partido
								where candidato.partido_fk = partido.id and candidato.id = $id");
});

$router->post('/api/v2/votar', function (Illuminate\Http\Request $request) use ($router) {
    
	$personaId = $request->json()->get('persona');
	$candidatoId = $request->json()->get('candidato');
	
	DB::insert("INSERT INTO voto VALUES (null,?,?);",[$personaId,$candidatoId]);
	
});

$router->get('/api/v2/voto', function () use ($router) {
	return $results = DB::select("SELECT candidato_fk as 'candidato', count(persona_fk) as 'cantidad' from voto
								group by candidato_fk");
});

$router->get('/api/v2/voto/{id}', function ($id) use ($router) {
	return $results = DB::select("SELECT candidato_fk as 'candidato', count(persona_fk) as 'cantidad' from voto
								where candidato_fk = $id");
});


$router->get('/api/v2/pais', function () use ($router) {
	return $results = DB::select("SELECT * FROM pais");
});

$router->get('/api/v2/pais/{id}', function ($id) use ($router) {
	return $results = DB::select("SELECT * FROM pais where id = $id");
});

$router->get('/api/v2/votantes', function () use ($router) {
	return $results = DB::select("SELECT persona.id, persona.rut, persona.nombre, nacionalidad.nombre_nacionalidad, 
								pais.nombre_pais, tipo_usuario.privilegio, sufragio
								from persona, nacionalidad, pais, tipo_usuario
								where persona.nacionalidad_fk = nacionalidad.id and persona.pais_fk = pais.id
								and tipo_usuario.id = persona.tipo_usuario_fk;");
});

$router->get('/api/v2/votantes/{id}', function ($id) use ($router) {
	return $results = DB::select("SELECT persona.id, persona.rut, persona.nombre, nacionalidad.nombre_nacionalidad, 
								pais.nombre_pais, tipo_usuario.privilegio, sufragio
								from persona, nacionalidad, pais, tipo_usuario
								where persona.nacionalidad_fk = nacionalidad.id and persona.pais_fk = pais.id
								and tipo_usuario.id = persona.tipo_usuario_fk and persona.id = $id;");
});

$router->get('/api/v2/votante/{rut}', function ($rut) use ($router) {
	$error = "Error";
	$tipo = "Candidato no encontrado";
	if((DB::select("SELECT count(id) from persona where rut = $rut"))== 0){
		return $router->$error->$tipo;
	}else{
		return $results = DB::select("SELECT persona.id, persona.rut, persona.nombre, nacionalidad.nombre_nacionalidad, 
								pais.nombre_pais, tipo_usuario.privilegio, sufragio
								from persona, nacionalidad, pais, tipo_usuario
								where persona.nacionalidad_fk = nacionalidad.id and persona.pais_fk = pais.id
								and tipo_usuario.id = persona.tipo_usuario_fk and persona.rut = '$rut';");
	}
});


