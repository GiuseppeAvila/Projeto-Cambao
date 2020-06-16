package br.edu.insper.al.carolineclc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
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

public class Fretes extends AppCompatActivity {
    private ImageButton contato;
    private ImageButton caixa;
    private ImageButton caminhao;
    private ImageButton frete1,frete2,frete3,frete4,frete5,frete6;
    private TextView caminhao1,caminhao2,caminhao3;
    private Button entregue, completados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fretes);

        contato = (ImageButton) findViewById(R.id.contato_fretes);
        caminhao = (ImageButton) findViewById(R.id.caminhao_fretes);
        caixa = (ImageButton) findViewById(R.id.caixa_fretes);
        completados = findViewById(R.id.completados);

        frete1 = (ImageButton) findViewById(R.id.frete1);
        frete2 = (ImageButton) findViewById(R.id.frete2);
        frete3 = (ImageButton) findViewById(R.id.frete3);
        frete4 = (ImageButton) findViewById(R.id.frete4);
        frete5 = (ImageButton) findViewById(R.id.frete5);
        frete6 = (ImageButton) findViewById(R.id.frete6);

        caminhao1=findViewById(R.id.c1);
        caminhao2=findViewById(R.id.c2);
        caminhao3=findViewById(R.id.c3);


        caminhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityFretes();
            }
        });


        contato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityContacts();
            }
        });
        caixa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityCaixas();
            }
        });





        DatabaseReference reff = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = reff.child("users");
        Log.v("USERID", userRef.getKey());

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        userRef.addValueEventListener(new ValueEventListener() {
            String  caminhoes,nomeC1,nomeC2,nomeC3, num;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                caminhoes = dataSnapshot.child(uid).child("caminhoes").getValue().toString();
                nomeC1=dataSnapshot.child(uid).child("nomec1").getValue().toString();
                nomeC2=dataSnapshot.child(uid).child("nomec2").getValue().toString();
                nomeC3=dataSnapshot.child(uid).child("nomec3").getValue().toString();
                num=dataSnapshot.child(uid).child("entregas").getValue().toString();

                completados.setText(num);


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

    public void openActivityFretes() {
        Intent intent = new Intent(this, Fretes.class);
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
