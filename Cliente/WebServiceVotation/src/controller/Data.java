/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Candidato;
import Model.Informacion;
import Model.Pais;
import Model.Partido;
import Model.Persona;
import Model.Resultado;
import Model.Voto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class Data {

    private ObjectMapper mapper;

    public Data() {
        mapper = new ObjectMapper();
    }

    public List<Pais> getPaises() {

        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://localhost:8000/api/v2/pais")
                    .get()
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "dfb80d3b-9c7f-97c4-7a58-87386941ea0c")
                    .build();
            Response response = client.newCall(request).execute();
            String json = response.body().string();

            Pais[] lista = mapper.readValue(json, Pais[].class);
            List<Pais> listaPaises = Arrays.asList(lista);
            return listaPaises;

        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Resultado> resultados() {

        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://localhost:8000/api/v2/voto")
                    .get()
                    .addHeader("Cache-Control", "no-cache")
                    .addHeader("Postman-Token", "5be40838-c050-4baf-8d85-dfc54f9e4225")
                    .build();

            Response response = client.newCall(request).execute();
            String json = response.body().string();

            Resultado[] lista = mapper.readValue(json, Resultado[].class);
            List<Resultado> result = Arrays.asList(lista);
            return result;

        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean agregarPais(Pais pais) {

        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/octet-stream");
            RequestBody body = RequestBody.create(mediaType, "{'nombre':'" + pais.getNombre() + "'}");

            Request request = new Request.Builder()
                    .url("http://localhost:8000/api/v2/pais")
                    .post(body)
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "ff953a65-9f59-4228-5763-ce6301a837f8")
                    .build();

            Response response = client.newCall(request).execute();

            String string = response.body().string();
            Informacion info = mapper.readValue(string, Informacion.class);
            if (info.getId() == 1) {
                return false;
            }
            return true;

        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public List<Candidato> lista_candidatos() {

        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://localhost:8000/api/v2/candidato")
                    .get()
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "94289e00-073c-3259-f5ae-af2986e96a1f")
                    .build();

            Response response = client.newCall(request).execute();
            String json = response.body().string();

            Candidato[] lista = mapper.readValue(json, Candidato[].class);
            List<Candidato> result = Arrays.asList(lista);
            return result;
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void votar(Persona p, String idCandidato) {
        try {
            int idCan = Integer.parseInt(idCandidato);
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n        \n\t\"persona\": " + p.getId() + ",\n    \"candidato\": " + idCan + "\n\t\n}");
            Request request = new Request.Builder()
                    .url("http://localhost:8000/api/v2/votar")
                    .post(body)
                    .addHeader("content-type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "6d15611a-e56a-dbf4-132c-85a38aa07990")
                    .build();

            Response response = client.newCall(request).execute();
//            String string = response.body().string();
//            Voto v = mapper.readValue(string, Voto.class);
//            if (v.getId() == 1) {
//                return false;
//            }
//            return true;

        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getPartidoId(String idCandidato) {

        try {

            int id = Integer.parseInt(idCandidato);
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://localhost:8000/api/v2/partido_c/" + id)
                    .get()
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "251b251e-ef37-6cf6-976c-86daa07c0c7d")
                    .build();

            Response response = client.newCall(request).execute();
            String json = response.body().string();
            Partido[] p = mapper.readValue(json, Partido[].class);
            List<Partido> result = Arrays.asList(p);
            return result.get(0).getPartido_fk();
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public Persona getPersona(String rut) {

        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://localhost:8000/api/v2/votante/" + rut)
                    .get()
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "b7ca3ea8-6281-6eae-c9b6-6ed96a114d6c")
                    .build();

            Response response = client.newCall(request).execute();
            String json = response.body().string();
            Persona[] person = mapper.readValue(json, Persona[].class);
            List<Persona> result = Arrays.asList(person);
            if (result != null) {
                return result.get(0);
            }
            return null;
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Candidato getCandidatoId(int id) {

        try{
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://localhost:8000/api/v2/candidato/" + id)
                .get()
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "922d89e2-0a88-90fd-f2fb-47f008f5b5d6")
                .build();

        Response response = client.newCall(request).execute();
            String json = response.body().string();
            Candidato[] c = mapper.readValue(json, Candidato[].class);
            List<Candidato> result = Arrays.asList(c);
            return result.get(0);
        
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
