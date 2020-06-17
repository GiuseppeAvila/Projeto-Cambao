package br.edu.insper.al.carolineclc.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Fretes extends AppCompatActivity {
    private ImageButton frete1,frete2,frete3,frete4,frete5,frete6, completados;
    private TextView caminhao1,caminhao2,caminhao3;
    private Button entregue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fretes);



        frete1 = (ImageButton) findViewById(R.id.frete1);
        frete2 = (ImageButton) findViewById(R.id.frete2);
        frete3 = (ImageButton) findViewById(R.id.frete3);
        frete4 = (ImageButton) findViewById(R.id.frete4);
        frete5 = (ImageButton) findViewById(R.id.frete5);
        frete6 = (ImageButton) findViewById(R.id.frete6);
        completados = (ImageButton) findViewById(R.id.completados);

        caminhao1=findViewById(R.id.c1);
        caminhao2=findViewById(R.id.c2);
        caminhao3=findViewById(R.id.c3);

        BottomNavigationView bottomnav = findViewById(R.id.bottom_navigation);
        bottomnav.setOnNavigationItemSelectedListener(naviselect);




        DatabaseReference reff = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = reff.child("users");
        Log.v("USERID", userRef.getKey());

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        userRef.addValueEventListener(new ValueEventListener() {
            String  caminhoes,nomeC1,nomeC2,nomeC3, num, fname1,fname2,fname3,fname4,fname5,fname6;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                caminhoes = dataSnapshot.child(uid).child("caminhoes").getValue().toString();
                nomeC1=dataSnapshot.child(uid).child("nomec1").getValue().toString();
                nomeC2=dataSnapshot.child(uid).child("nomec2").getValue().toString();
                nomeC3=dataSnapshot.child(uid).child("nomec3").getValue().toString();
                num=dataSnapshot.child(uid).child("entregas").getValue().toString();
                fname1 = dataSnapshot.child(uid).child("frete1").child("contato").getValue().toString();
                fname2 = dataSnapshot.child(uid).child("frete2").child("contato").getValue().toString();
                fname3 = dataSnapshot.child(uid).child("frete3").child("contato").getValue().toString();
                fname4 = dataSnapshot.child(uid).child("frete4").child("contato").getValue().toString();
                fname5 = dataSnapshot.child(uid).child("frete5").child("contato").getValue().toString();
                fname6 = dataSnapshot.child(uid).child("frete6").child("contato").getValue().toString();


                if (fname1.equals("")){
                    frete1.setImageResource(R.drawable.buttons);
                }
                if (fname2.equals("")){
                    frete2.setImageResource(R.drawable.buttons);
                }
                if (fname3.equals("")){
                    frete3.setImageResource(R.drawable.buttons);
                }
                if (fname4.equals("")){
                    frete4.setImageResource(R.drawable.buttons);
                }
                if (fname5.equals("")){
                    frete5.setImageResource(R.drawable.buttons);
                }
                if (fname6.equals("")){
                    frete6.setImageResource(R.drawable.buttons);
                }


                //completados.setText(num);


                caminhao1.setText(nomeC1);
                caminhao2.setText(nomeC2);
                caminhao3.setText(nomeC3);




                if (caminhoes .equals("2")) {
                    frete5.setVisibility(View.INVISIBLE);
                    frete6.setVisibility(View.INVISIBLE);
                    caminhao3.setVisibility(View.INVISIBLE);

                } else if (caminhoes.equals("1")) {
                    frete3.setVisibility(View.INVISIBLE);
                    frete4.setVisibility(View.INVISIBLE);
                    frete5.setVisibility(View.INVISIBLE);
                    frete6.setVisibility(View.INVISIBLE);
                    caminhao2.setVisibility(View.INVISIBLE);
                    caminhao3.setVisibility(View.INVISIBLE);

                }
                System.out.println(caminhoes);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        frete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Fretes.this, DetailsFrete.class);
                // intent.tExtra("position", position);
                // Or / And
                intent.putExtra("frete", ("frete1"));
                startActivity(intent);              }
        });

        frete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Fretes.this, DetailsFrete.class);
                // intent.tExtra("position", position);
                // Or / And
                intent.putExtra("frete", ("frete2"));
                startActivity(intent);              }
        });

        frete3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Fretes.this, DetailsFrete.class);
                // intent.tExtra("position", position);
                // Or / And
                intent.putExtra("frete", ("frete3"));
                startActivity(intent);            }
        });

        frete4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Fretes.this, DetailsFrete.class);
                // intent.tExtra("position", position);
                // Or / And
                intent.putExtra("frete", ("frete4"));
                startActivity(intent);            }
        });
        frete5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Fretes.this, DetailsFrete.class);
                // intent.tExtra("position", position);
                // Or / And
                intent.putExtra("frete", ("frete5"));
                startActivity(intent);            }
        });
        frete6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Fretes.this, DetailsFrete.class);
                // intent.tExtra("position", position);
                // Or / And
                intent.putExtra("frete", ("frete6"));
                startActivity(intent);            }
        });

        completados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityOld();
            }
        });



    }

    private BottomNavigationView.OnNavigationItemSelectedListener naviselect =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.nav_home:
                            openActivityFretes();
                            System.out.println("Isso esta funcionando");
                            break;

                        case R.id.nav_phone:
                            openActivityContacts();

                            break;

                        case R.id.nav_recomendados:
                            openActivityCaixas();
                            break;
                    }
                    return true;
                }
            };

    public void openActivityFretes() {
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
    public void openActivityOld() {
        Intent intent = new Intent(this, OldFretes.class);
        startActivity(intent);
    }
}