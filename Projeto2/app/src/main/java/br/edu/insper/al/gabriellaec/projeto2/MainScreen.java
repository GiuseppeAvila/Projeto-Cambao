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

    private ImageButton imageButtonMap;
    private ImageView imageButtonNews;
    private ImageButton imageButtonProf;
    private ImageButton contato;
    private ImageButton caixa;
    private ImageButton caminhao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        imageButtonMap = (ImageButton) findViewById(R.id.imageButtonMap);
        imageButtonNews = (ImageView) findViewById(R.id.imageButtonNews);
        imageButtonProf = (ImageButton) findViewById(R.id.imageButtonProf2);
        contato = (ImageButton) findViewById(R.id.contato);
        caixa = (ImageButton) findViewById(R.id.caixa);
        caminhao = (ImageButton) findViewById(R.id.caminhao);


        imageButtonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        imageButtonProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, Info.class));
            }
        });

        caminhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityDeliveries();
            }
        });

        contato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityContacts();
            }
        });


        imageButtonNews.setOnClickListener(new View.OnClickListener() {
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
                }else if(x1 > x2){
                    Intent i = new Intent(MainScreen.this, Contato.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }

    public void openActivityDeliveries() {
        Intent intent = new Intent(this, Deliveries.class);
        startActivity(intent);
    }

    public void openActivityContacts() {
        Intent intent = new Intent(this, Contato.class);
        startActivity(intent);
    }
}
