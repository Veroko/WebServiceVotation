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

$router->post('/api/v2/agregar_personas', function () use ($router) {
    //return array("eso"=>"ok");
});

$router->post('/api/v2/agregar_candidatos', function (Illuminate\Http\Request $request) use ($router) {
    $id = $request->json()->get('id');
	$nombre = $request->json()->get('nombre');
	$partido = $request->json()->get('partido');
	
	DB::insert("INSERT INTO tabla VALUES (?,?,?)",[$id,$nombre,$partido]);
	
});

$router->get('/api/v2/candidato', function () use ($router) {
	return $results = DB::select("SELECT candidato.id, persona.rut, persona.nombre, partido.nombre_partido
								FROM candidato, persona, partido
								WHERE candidato.persona_fk = persona.id AND candidato.partido_fk = partido.id;");
});

$router->get('/api/v2/candidato/{id}', function () use ($router) {
	return $results = DB::select("SELECT candidato.id, persona.rut, persona.nombre, partido.nombre_partido
								FROM candidato, persona, partido
								WHERE candidato.persona_fk = persona.id AND candidato.partido_fk = partido.id AND
								candidato.id = id;");
});

$router->get('/api/v2/voto', function () use ($router) {
	return $results = DB::select("SELECT candidato_fk as 'candidato', count(persona_fk) as 'cantidad' from voto
								group by candidato_fk");
});

$router->get('/api/v2/voto/{id}', function ($id) use ($router) {
	return $results = DB::select("SELECT candidato_fk as 'candidato', count(persona_fk) as 'cantidad' from voto
								group by candidato_fk = $id");
});


$router->get('/api/v2/pais', function () use ($router) {
	return $results = DB::select("SELECT * FROM pais");
});

$router->get('/api/v2/pais/{id}', function ($id) use ($router) {
	return $results = DB::select("SELECT * FROM pais where id = $id");
});


