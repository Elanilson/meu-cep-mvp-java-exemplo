package com.example.meucepmvpjava.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.meucepmvpjava.R;
import com.example.meucepmvpjava.databinding.ActivityMainBinding;
import com.example.meucepmvpjava.presenter.MainPresenter;
import com.example.meucepmvpjava.view.interfaces.MainView;

public class MainActivity extends AppCompatActivity implements MainView {
    private ActivityMainBinding binding;
    private MainPresenter presenter = new MainPresenter(this);
    private String campoCep = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campoCep = binding.editTextCep.getText().toString();
                presenter.validarCampo(campoCep);
            }
        });
    }

    public void irParaProximaTela(){
        Bundle bundle = new Bundle();
        bundle.putString("cep",campoCep);
        Intent intent = new Intent(this,ExibirEnderecoActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    @Override
    public void campoValidado(Boolean result) {
        if(result){
            irParaProximaTela();
        }

    }

    @Override
    public void mensagem(String mensagem) {
        if(mensagem != ""){
            Toast.makeText(this,mensagem,Toast.LENGTH_SHORT).show();
        }

    }
}