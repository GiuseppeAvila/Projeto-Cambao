package br.edu.insper.al.carolineclc.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainScreen extends AppCompatActivity {
    float x1, y1, x2, y2;

    private Button ButtonMap;
    private Button ButtonNews;
    private Button ButtonFrete;
    private ImageButton imageButtonProf;
    private TextView ola;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        ButtonMap = (Button) findViewById(R.id.ButtonMapa);
        ButtonFrete = (Button) findViewById(R.id.meu_frete);
        ButtonNews = (Button) findViewById(R.id.ButtonNews);
        imageButtonProf = (ImageButton) findViewById(R.id.perfil);
        ola= findViewById(R.id.oie);

        DatabaseReference reff = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = reff.child("users");
        Log.v("USERID", userRef.getKey());

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        userRef.addValueEventListener(new ValueEventListener() {
            String fname;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                fname = dataSnapshot.child(uid).child("fullName").getValue().toString();

                ola.setText("Olá, "+fname);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        BottomNavigationView bottomnav = findViewById(R.id.bottom_navigation);
        bottomnav.setOnNavigationItemSelectedListener(naviselect);


        ButtonMap.setOnClickListener(new View.OnClickListener() {
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

        ButtonFrete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityFretes();
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

        imageButtonProf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActivityPerfil();
            }
        });
    }


    private BottomNavigationView.OnNavigationItemSelectedListener naviselect =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.nav_fretes:
                            openActivityFretes();
                            System.out.println("Isso esta funcionando");
                            break;

                        case R.id.nav_phone:
                            openActivityContacts();

                            break;

                        case R.id.nav_recomendados:
                            openActivityCaixa();
                            break;
                    }
                    return true;
                }
            };

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
                    Intent i = new Intent(MainScreen.this, Fretes.class);
                    startActivity(i);
                }else if(x1 > x2){
                    Intent i = new Intent(MainScreen.this, Contato.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }



    public void openActivityFretes() {
        Intent intent = new Intent(this,Fretes.class);
        startActivity(intent);
    }

    public void openActivityContacts() {
        Intent intent = new Intent(this, Contato.class);
        startActivity(intent);
        System.out.println("Isso esta funcionando");
    }

    public void openActivityCaixa() {
        Intent intent = new Intent(this, Caixa.class);
        startActivity(intent);
    }

    public void openActivityPerfil() {
        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);
    }
}



