package br.edu.insper.al.carolineclc.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OldFretes extends AppCompatActivity {
    private ImageButton caminhao1, caminhao2, caminhao3, caminhao4, caminhao5, caminhao6;
    private ImageButton frete1, frete2, frete3, frete4, frete5, frete6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_fretes);


        frete1 = (ImageButton) findViewById(R.id.old1);
        frete2 = (ImageButton) findViewById(R.id.old2);
        frete3 = (ImageButton) findViewById(R.id.old3);
        frete4 = (ImageButton) findViewById(R.id.old4);
        frete5 = (ImageButton) findViewById(R.id.old5);
        frete6 = (ImageButton) findViewById(R.id.old6);
        BottomNavigationView bottomnav = findViewById(R.id.bottom_navigation);
        bottomnav.setOnNavigationItemSelectedListener(naviselect);

        frete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(OldFretes.this, DetailsAntigos.class);
                // intent.tExtra("position", position);
                // Or / And
                intent.putExtra("frete", ("antiga1"));
                startActivity(intent);
            }
        });

        frete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(OldFretes.this, DetailsAntigos.class);
                // intent.tExtra("position", position);
                // Or / And
                intent.putExtra("frete", ("antiga2"));
                startActivity(intent);
            }
        });

        frete3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(OldFretes.this, DetailsAntigos.class);
                // intent.tExtra("position", position);
                // Or / And
                intent.putExtra("frete", ("antiga3"));
                startActivity(intent);
            }
        });

        frete4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(OldFretes.this, DetailsAntigos.class);
                // intent.tExtra("position", position);
                // Or / And
                intent.putExtra("frete", ("antiga4"));
                startActivity(intent);
            }
        });
        frete5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(OldFretes.this, DetailsAntigos.class);
                // intent.tExtra("position", position);
                // Or / And
                intent.putExtra("frete", ("antiga5"));
                startActivity(intent);
            }
        });
        frete6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(OldFretes.this, DetailsAntigos.class);
                // intent.tExtra("position", position);
                // Or / And
                intent.putExtra("frete", ("antiga6"));
                startActivity(intent);
            }
        });

    }

    private BottomNavigationView.OnNavigationItemSelectedListener naviselect =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.nav_home:
                            openActivityHome();
                            System.out.println("Isso esta funcionando");
                            break;

                        case R.id.nav_phone:
                            openActivityContacts();

                            break;

                        case R.id.nav_recomendados:
                            openActivityCaixas();
                            break;

                        case R.id.nav_fretes:
                            openActivityFretes();
                            break;
                    }
                    return true;
                }
            };


    public void openActivityFretes() {
        Intent intent = new Intent(this, Fretes.class);
        startActivity(intent);
    }

    public void openActivityHome() {
        Intent intent = new Intent(this, MainScreen.class);
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
}