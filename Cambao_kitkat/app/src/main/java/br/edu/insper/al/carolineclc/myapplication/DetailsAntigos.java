package br.edu.insper.al.carolineclc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailsAntigos extends AppCompatActivity {
    private TextView nome, contato, localizacao, produto, preco, exit, arrival, weight;
    private Button entregue, voltar;
    DatabaseReference reff;
    private final String TAG = this.getClass().getName().toUpperCase();
    FirebaseAuth mFirebaseAuth;
    private Entrega entrega;
    private EditText emailId, password, placa, telefone, nomeid;
    private User user;
    private DatabaseReference mDatabase;
    private static final String USERS = "users";
    //private String TAG = "RegisterActivity";
    private FirebaseDatabase database;
    Caixa current;
    String empresaId="";
    private int numero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_antigos);


        nome = findViewById(R.id.nomeEmpresa);
        contato = findViewById(R.id.contatoEmpresa);
        localizacao = findViewById(R.id.localizacaoEmpresa);
        exit = findViewById(R.id.saida);
        arrival = findViewById(R.id.chegada);
        voltar=findViewById(R.id.buttonVoltar);

        Intent intent = getIntent();
        empresaId = intent.getStringExtra("frete");
        System.out.println(empresaId);

        DatabaseReference reff = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = reff.child("users");
        Log.v("USERID", userRef.getKey());

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        userRef.addValueEventListener(new ValueEventListener() {
            String fname, contact, caminhoes, location, price, saida, chegada, peso, num, product;
            String old1, old2,old3,old4,old5,old6;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String email = user.getEmail();
                fname = dataSnapshot.child(uid).child(empresaId).child("nome").getValue().toString();
                contact = dataSnapshot.child(uid).child(empresaId).child("contato").getValue().toString();
                location = dataSnapshot.child(uid).child(empresaId).child("endereco").getValue().toString();
                saida = dataSnapshot.child(uid).child(empresaId).child("saida").getValue().toString();
                chegada = dataSnapshot.child(uid).child(empresaId).child("chegada").getValue().toString();
                product = dataSnapshot.child(uid).child(empresaId).child("produto").getValue().toString();

                nome.setText(fname);
                localizacao.setText(Html.fromHtml("<b>" + "Telefone: " + "</b> " + location.toString()));
                contato.setText(Html.fromHtml("<b>" + "Contato: " + "</b> " + contact.toString()));
                exit.setText(Html.fromHtml("<b>" + "Saída: " + "</b> " + saida));
                arrival.setText(Html.fromHtml("<b>" + "Chegada: " + "</b> " + chegada));


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenOldFretes();
            }
        });






    }

    public void openActivityCaixa() {
        Intent intent = new Intent(this, Caixa.class);
        startActivity(intent);
    }

    public void OpenOldFretes() {
        Intent intent = new Intent(this, OldFretes.class);
        startActivity(intent);
    }



}