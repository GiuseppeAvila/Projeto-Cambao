package br.edu.insper.al.gabriellaec.projeto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainScreen extends AppCompatActivity {
    float x1, y1, x2, y2;

    private Button mapa;
    private Button meu_frete;
    private Button portal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        mapa.setOnClickListener((view) -> {
            Intent i = new Intent(MainScreen.this, MainMapa1.class);
            startActivity(i);

        });

        meu_frete.setOnClickListener((view) -> {
            Intent i = new Intent(MainScreen.this, MainMapa1.class);
            startActivity(i);

        });


    }


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
                    Intent i = new Intent(MainScreen.this, Deliveries.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}
