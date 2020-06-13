package com.example.exemplokitkatjava;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button ButtonLogin;
    private Button ButtonCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButtonLogin = (Button) findViewById(R.id.ButtonLogin);
        ButtonCadastro = (Button) findViewById(R.id.ButtonCadastro);

        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMainScreen();
            }
        });

        ButtonCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityCadastro();
            }
        });
    }

    public void openActivityMainScreen() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }

    public void openActivityCadastro() {
        Intent intent = new Intent(this, NovoCadastro.class);
        startActivity(intent);
    }

}
