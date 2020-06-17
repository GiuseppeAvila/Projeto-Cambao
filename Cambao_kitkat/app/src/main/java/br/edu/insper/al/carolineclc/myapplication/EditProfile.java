package br.edu.insper.al.carolineclc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditProfile extends AppCompatActivity {
    private Button concluir, voltar;
    FirebaseAuth mFirebaseAuth;
    private EditText tel, plate,c1,c2,c3;
    private DatabaseReference mDatabase;
    private static final String USERS = "users";
    private String TAG = "RegisterActivity";
    private FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        tel=findViewById(R.id.telefonePerfil);
        plate=findViewById(R.id.placaPerfil);
        c1=findViewById(R.id.c1Perfil);
        c2=findViewById(R.id.c2Perfil);
        c3=findViewById(R.id.c3Perfil);

        concluir=findViewById(R.id.concluir);
        voltar=findViewById(R.id.voltar);


        

        DatabaseReference reff = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = reff.child("users");


        Log.v("USERID", userRef.getKey());

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();



        userRef.addValueEventListener(new ValueEventListener() {
            String nomef1, nomef2, nomef3,nomef4, nomef5, nomef6, caminhoes, price, saida, chegada, peso, nomec1, nomec2, nomec3;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                caminhoes = dataSnapshot.child(uid).child("caminhoes").getValue().toString();

                if (caminhoes .equals("2")) {
                    c3.setVisibility(View.GONE);

                } else if (caminhoes.equals("1")) {
                    c2.setVisibility(View.GONE);
                    c3.setVisibility(View.GONE);
                }

                concluir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String telefone = tel.getText().toString();
                    String placa = plate.getText().toString();
                    String cambao1 = c1.getText().toString();


                    reff.child("users").child(uid).child("phone").setValue(telefone);
                    reff.child("users").child(uid).child("placa").setValue(placa);
                    reff.child("users").child(uid).child("nomec1").setValue(cambao1);

                    if (Integer.parseInt(caminhoes) >= 2 ) {
                        String cambao2 = c2.getText().toString();
                        reff.child("users").child(uid).child("nomec2").setValue(cambao2);

                    } if (caminhoes=="3") {
                        String cambao3 = c3.getText().toString();
                        reff.child("users").child(uid).child("nomec3").setValue(cambao3);
                    }

                    Toast.makeText(EditProfile.this, "Perfil atualizado com sucesso", Toast.LENGTH_LONG).show();
                    openMainScreen();


                }});}

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }}
            );

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPerfil();
            }
        });



    }
    public void openMainScreen() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
        }
    public void openPerfil() {
        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);
    }
}
