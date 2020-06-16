package br.edu.insper.al.carolineclc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
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

public class DetailsFrete extends AppCompatActivity {

    private TextView nome, contato, localizacao, produto, preco, exit, arrival, weight;
    private Button entregue, completados;
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
        setContentView(R.layout.activity_details_frete);

        nome = findViewById(R.id.nomeEmpresa);
        contato = findViewById(R.id.contatoEmpresa);
        localizacao = findViewById(R.id.localizacaoEmpresa);
        exit = findViewById(R.id.saida);
        arrival = findViewById(R.id.chegada);


        entregue = findViewById(R.id.buttonEntregue);


        Intent intent = getIntent();
        empresaId = intent.getStringExtra("frete");
        System.out.println(empresaId);

        DatabaseReference reff = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = reff.child("users");
        Log.v("USERID", userRef.getKey());

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        userRef.addValueEventListener(new ValueEventListener() {
            String fname, contact, caminhoes, location, price, saida, chegada, peso, num;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String email = user.getEmail();
                fname = dataSnapshot.child(uid).child(empresaId).child("nome").getValue().toString();
                contact = dataSnapshot.child(uid).child(empresaId).child("contato").getValue().toString();
                location = dataSnapshot.child(uid).child(empresaId).child("endereco").getValue().toString();
                saida = dataSnapshot.child(uid).child(empresaId).child("saida").getValue().toString();
                chegada = dataSnapshot.child(uid).child(empresaId).child("chegada").getValue().toString();
                num=dataSnapshot.child(uid).child("entregas").getValue().toString();

                numero = Integer.parseInt(num);
                nome.setText(fname);
                localizacao.setText(Html.fromHtml("<b>" + "Telefone: " + "</b> " + location.toString()));
                contato.setText(Html.fromHtml("<b>" + "Contato: " + "</b> " + contact.toString()));
                exit.setText(Html.fromHtml("<b>" + "Saída: " + "</b> " + saida));
                arrival.setText(Html.fromHtml("<b>" + "Chegada: " + "</b> " + chegada));

                if (fname.equals("")){
                    localizacao.setVisibility(View.INVISIBLE);
                    contato.setVisibility(View.INVISIBLE);
                    exit.setVisibility(View.INVISIBLE);
                    arrival.setVisibility(View.INVISIBLE);
                    nome.setText("\n"+"Sem fretes no momento");
                    entregue.setVisibility(View.INVISIBLE);
                }

                entregue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        String userId = user.getUid();
                        mDatabase = FirebaseDatabase.getInstance().getReference();

                        entrega = new Entrega("", "", "", "", "", "", "", "");

                        mDatabase.child("users").child(userId).child(empresaId).setValue(entrega);

                        localizacao.setVisibility(View.INVISIBLE);
                        contato.setVisibility(View.INVISIBLE);
                        exit.setVisibility(View.INVISIBLE);
                        arrival.setVisibility(View.INVISIBLE);

                        numero++;

                        reff.child("users").child(userId).child("entregas").setValue(Integer.toString(numero));


                        Toast.makeText(DetailsFrete.this,"Parabéns, você completou mais uma entrega!",Toast.LENGTH_LONG).show();
                    }});

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

    public void openActivityCaixa() {
        Intent intent = new Intent(this, Caixa.class);
        startActivity(intent);
    }



}