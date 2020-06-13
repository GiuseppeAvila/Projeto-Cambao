package br.edu.insper.al.carolineclc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Perfil extends AppCompatActivity {
    private TextView nome, tel, truck, mail;
    private final String TAG = this.getClass().getName().toUpperCase();
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private Map<String, String> userMap;
    private String email;
    private String userid;
    private String name;
    private Button logout;


    private static final String USERS = "users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nome = findViewById(R.id.nomeUser);
        tel = findViewById(R.id.telUser);
        truck = findViewById(R.id.newInfo);
        mail = findViewById(R.id.emailUser);
        logout = findViewById(R.id.logout);

        DatabaseReference reff = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = reff.child("users");
        Log.v("USERID", userRef.getKey());

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        userRef.addValueEventListener(new ValueEventListener() {
            String fname, contact, caminhoes, location, price, saida, chegada, peso;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    String email = user.getEmail();
                    fname = dataSnapshot.child(uid).child("fullName").getValue().toString();
                    contact = dataSnapshot.child(uid).child("phone").getValue().toString();
                    caminhoes = dataSnapshot.child(uid).child("caminhoes").getValue().toString();

                    nome.setText(fname);
                    tel.setText(Html.fromHtml("<b>" + "Telefone: " + "</b> " +contact.toString()));
                    truck.setText(Html.fromHtml("<b>" + "Quantidade de caminhões: " + "</b> " +caminhoes.toString()));
                    mail.setText(Html.fromHtml("<b>" + "email: " + "</b> " +email));
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
    }
    public void openLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}


