package br.edu.insper.al.carolineclc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Fretes extends AppCompatActivity {
    private ImageButton contato;
    private ImageButton caixa;
    private ImageButton caminhao;
    private ImageButton aceito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fretes);

        contato = (ImageButton) findViewById(R.id.contato_fretes);
        caminhao = (ImageButton) findViewById(R.id.caminhao_fretes);
        caixa = (ImageButton) findViewById(R.id.caixa_fretes);
        aceito = (ImageButton) findViewById(R.id.caixa_fretes);

        caminhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityFretes();
            }
        });


        contato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityContacts();
            }
        });
        caixa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityCaixas();
            }
        });
        aceito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityAceito();
            }
        });

    }

    public void openActivityFretes() {
        Intent intent = new Intent(this, Fretes.class);
        startActivity(intent);
    }

    public void openActivityContacts() {
        Intent intent = new Intent(this, Contato.class);
        startActivity(intent);
    }
    public void openActivityCaixas() {
        Intent intent = new Intent(this, Caixa.class);
        startActivity(intent);
    }
    public void openActivityAceito() {
        Intent intent = new Intent(this, Aceito.class);
        startActivity(intent);
    }
}
