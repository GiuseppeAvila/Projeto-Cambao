package br.edu.insper.al.carolineclc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

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
    private ImageButton frete1,frete2,frete3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fretes);

        contato = (ImageButton) findViewById(R.id.contato_fretes);
        caminhao = (ImageButton) findViewById(R.id.caminhao_fretes);
        caixa = (ImageButton) findViewById(R.id.caixa_fretes);

        frete1 = (ImageButton) findViewById(R.id.frete1);
        frete2 = (ImageButton) findViewById(R.id.frete2);
        frete3 = (ImageButton) findViewById(R.id.frete3);


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
            String fname, contact, caminhoes, location, price, saida, chegada, peso;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                caminhoes = dataSnapshot.child(uid).child("caminhoes").getValue().toString();
                if (caminhoes .equals("2")) {
                    frete2.setVisibility(View.INVISIBLE);
                } else if (caminhoes.equals("1")) {
                    frete2.setVisibility(View.INVISIBLE);
                    frete3.setVisibility(View.INVISIBLE);
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
}
