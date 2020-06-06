package br.edu.insper.al.carolineclc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Caixa extends AppCompatActivity {
    private ImageButton contato;
    private ImageButton caixa;
    private ImageButton caminhao;
    private ImageButton btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caixa);
        contato = (ImageButton) findViewById(R.id.contato_caixa);
        caminhao = (ImageButton) findViewById(R.id.caminhao_caixa);
        caixa = (ImageButton) findViewById(R.id.caixa_caixa);

        btn=(ImageButton) findViewById(R.id.imageButton15);


    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openActivityAccept();
        }
    });}
    public void openActivityAccept() {
        Intent intent = new Intent(this, AcceptDelivery.class);
        startActivity(intent);
    }
}
