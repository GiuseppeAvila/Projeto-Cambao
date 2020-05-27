package br.edu.insper.al.gabriellaec.projeto2;

import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import java.util.Arrays;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class NovoCadastro extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Button concluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_cadastro);

        concluir = (Button) findViewById(R.id.button);

        concluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityLogin();
            }
        });


        Spinner spinnerCaminhao = (Spinner) findViewById(R.id.spinner);
        String[] items = new String[] {"Tipo do veículo","Carreta","Carreta LS","Vanderléia","Bitrem","Rodotrem","Truck","Bitruck","VCL","3/4","Toco"};
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCaminhao.setAdapter(adapter);
        spinnerCaminhao.setOnItemSelectedListener(this);


        Spinner spinnerQuantidade = (Spinner) findViewById(R.id.spinner2);
        String[] numeros = new String[] {"Quantidade de veículos","1","2","3"};
        ArrayAdapter<String> adapterNum =  new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, numeros);
        adapterNum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerQuantidade.setAdapter(adapterNum);
        spinnerQuantidade.setOnItemSelectedListener(this);
    }

    public void openActivityLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
