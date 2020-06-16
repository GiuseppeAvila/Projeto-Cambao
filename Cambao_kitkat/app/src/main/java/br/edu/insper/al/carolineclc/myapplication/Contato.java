package br.edu.insper.al.carolineclc.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.edu.insper.al.carolineclc.myapplication.R;

public class Contato extends AppCompatActivity {
    float x1, y1, x2, y2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
        BottomNavigationView bottomnav = findViewById(R.id.bottom_navigation);
        bottomnav.setOnNavigationItemSelectedListener(naviselect);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener naviselect =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.nav_fretes:
                            openActivityFretes();
                            break;

                        case R.id.nav_home:
                            openActivityMainScreen();
                            break;

                        case R.id.nav_recomendados:
                            openActivityDeliveries();
                            break;
                    }
                    return true;
                }
            };

    //MÉTODO PARA SLIDE DE TELA
    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 < x2){
                    Intent i = new Intent(Contato.this, MainScreen.class);
                    startActivity(i);
                } else if(x1 > x2){
                    Intent i = new Intent(Contato.this, Fretes.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }

    public void openActivityDeliveries() {
        Intent intent = new Intent(this, Caixa.class);
        startActivity(intent);
    }


    public void openActivityMainScreen() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }

    public void openActivityFretes() {
        Intent intent = new Intent(this, Fretes.class);
        startActivity(intent);
    }
}
