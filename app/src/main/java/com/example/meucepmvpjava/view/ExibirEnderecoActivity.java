package com.example.meucepmvpjava.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.meucepmvpjava.R;
import com.example.meucepmvpjava.databinding.ActivityExibirEnderecoBinding;
import com.example.meucepmvpjava.model.enttities.Cep;
import com.example.meucepmvpjava.presenter.ExibirEnderecoPresenter;
import com.example.meucepmvpjava.view.interfaces.ExibirEnderrecoView;

public class ExibirEnderecoActivity extends AppCompatActivity implements ExibirEnderrecoView {
    private ActivityExibirEnderecoBinding binding;
    private ExibirEnderecoPresenter presenter = new ExibirEnderecoPresenter(this);
    private String cep = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExibirEnderecoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            cep = bundle.getString("cep");
            presenter.buscarCep(cep);
        }
    }

    @Override
    public void onExebirCEp(Cep cep) {
        binding.textViewCep.setText(cep.getCep());
        binding.textViewBairro.setText(cep.getBairro());
        binding.textViewLogradouro.setText(cep.getLogradouro());
        binding.textViewComplemento.setText(cep.getComplemento());
        binding.textViewLocalidade.setText(cep.getLocalidade());
        binding.textView2Uf.setText(cep.getComplemento());
        binding.textViewDDD.setText(cep.getLocalidade());

    }

    @Override
    public void mensagem(String mensagem) {
        Toast.makeText(this,mensagem, Toast.LENGTH_SHORT).show();

    }
}