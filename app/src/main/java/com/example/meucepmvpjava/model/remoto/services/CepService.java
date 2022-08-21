package com.example.meucepmvpjava.model.remoto.services;

import com.example.meucepmvpjava.model.enttities.Cep;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CepService {
    @GET("{cep}/json/")
    Call<Cep> buscarCep(@Path(value = "cep",encoded = true) String cep);
}
