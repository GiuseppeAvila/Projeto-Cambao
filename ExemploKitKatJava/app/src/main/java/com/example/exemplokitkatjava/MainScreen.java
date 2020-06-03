package com.example.exemplokitkatjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainScreen extends AppCompatActivity {
    float x1, y1, x2, y2;

    private Button ButtonMap;
    private Button ButtonNews;
    private Button ButtonFrete;
    private ImageButton imageButtonProf;
    private ImageButton ButtonContato;
    private ImageButton ButtonCaixa;
    private ImageButton ButtonCaminhao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        ButtonMap = (Button) findViewById(R.id.ButtonMapa);
        ButtonFrete = (Button) findViewById(R.id.meu_frete);
        ButtonNews = (Button) findViewById(R.id.ButtonNews);
        ButtonContato = (ImageButton) findViewById(R.id.contato);
        ButtonCaminhao = (ImageButton) findViewById(R.id.caminhao);
        ButtonCaixa = (ImageButton) findViewById(R.id.caixa);
        imageButtonProf = (ImageButton) findViewById(R.id.imageView2);


        ButtonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        ButtonCaminhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, ActivityMeusFretes.class));
            }
        });

        ButtonFrete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, ActivityMeusFretes.class));
            }
        });

        ButtonContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, ActivityContato.class));
            }
        });
        ButtonCaixa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, ActivityNovosFretes.class));
            }
        });
        ButtonNews.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.blogdocaminhoneiro.com"));
                startActivity(intent);
            }
        });



    }

    public void openMap() {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?"));
        startActivity(intent);

    }




}


