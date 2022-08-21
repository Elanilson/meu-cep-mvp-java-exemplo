package com.example.meucepmvpjava.presenter;

import com.example.meucepmvpjava.model.enttities.Cep;
import com.example.meucepmvpjava.model.interfaces.APIListener;
import com.example.meucepmvpjava.model.repositorios.CepRepositorio;
import com.example.meucepmvpjava.view.interfaces.ExibirEnderrecoView;

public class ExibirEnderecoPresenter {
    private ExibirEnderrecoView view;
    private CepRepositorio repositorio = new CepRepositorio();

    public ExibirEnderecoPresenter(ExibirEnderrecoView view) {
        this.view = view;
    }

    public void buscarCep(String cep){

        APIListener<Cep> listener = new APIListener<Cep>() {
            @Override
            public void onSuccess(Cep result) {
                view.onExebirCEp(result);
            }

            @Override
            public void onFailures(String mensagem) {
                view.mensagem(mensagem);
            }
        };

        repositorio.buscarCep(cep,listener);
    }
}
