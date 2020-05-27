package br.edu.insper.al.gabriellaec.projeto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class Deliveries extends AppCompatActivity {
    float x1, y1, x2, y2;
    private ImageButton contato;
    private ImageButton caixa;
    private ImageButton caminhao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliveries);

        contato = (ImageButton) findViewById(R.id.caminhao);
        caixa = (ImageButton) findViewById(R.id.caixa);
        caminhao = (ImageButton) findViewById(R.id.caminhao);


        contato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityContacts();
            }
        });

        caixa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMainScreen();
            }
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
                if(x1 > x2){
                    Intent i = new Intent(Deliveries.this, MainScreen.class);
                    startActivity(i);
                }else if(x1 < x2){
                    Intent i = new Intent(Deliveries.this, Contato.class);
                    startActivity(i);
                }

                break;
        }
        return false;
    }

    public void openActivityContacts() {
        Intent intent = new Intent(this, Contato.class);
        startActivity(intent);
    }

    public void openActivityMainScreen() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }
}
