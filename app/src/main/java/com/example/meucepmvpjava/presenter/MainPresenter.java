package com.example.meucepmvpjava.presenter;

import com.example.meucepmvpjava.view.interfaces.MainView;

public class MainPresenter {
    private MainView view;

    public MainPresenter(MainView view){
        this.view = view;
        view.campoValidado(false);
    }

    public void validarCampo(String cep){
        if(cep != null && cep != "" && cep != " "){
            view.campoValidado(true);
        }else{
            view.mensagem("Preencha o campo corretamente!");
        }
    }
}
