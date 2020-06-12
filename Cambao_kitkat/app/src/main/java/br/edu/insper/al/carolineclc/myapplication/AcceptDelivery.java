package br.edu.insper.al.carolineclc.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Snapshot;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AcceptDelivery extends AppCompatActivity {
    private TextView nome, contato, localizacao, produto, preco, exit, arrival, weight;
    private Button accept, decline;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_delivery);

        nome=findViewById(R.id.nomeEmpresa);
        contato=findViewById(R.id.contatoEmpresa);
        localizacao=findViewById(R.id.localizacaoEmpresa);
        produto=findViewById(R.id.produtoEmpresa);
        preco=findViewById(R.id.precoEmpresa);
        exit=findViewById(R.id.saida);
        arrival=findViewById(R.id.chegada);
        weight=findViewById(R.id.peso);


        accept=findViewById(R.id.buttonAccept);
        decline=findViewById(R.id.buttonDecline);

        //Get Food_id from intent
        //if(getIntent() != null)
        Intent intent = getIntent();
        empresaId = intent.getStringExtra("id");
        System.out.println(empresaId);


        reff = FirebaseDatabase.getInstance().getReference().child("empresas").child(empresaId);

        // Read from the database
        reff.addValueEventListener(new ValueEventListener() {
            String fname, contact, product, location, price, saida, chegada, peso;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
             //  current= dataSnapshot.getValue(empresaId);

                fname = dataSnapshot.child("nome").getValue().toString();
                contact = dataSnapshot.child("contato").getValue().toString();
                product = dataSnapshot.child("produto").getValue().toString();
                location = dataSnapshot.child("endereco").getValue().toString();
                price = dataSnapshot.child("preco").getValue().toString();
                chegada = dataSnapshot.child("horariochegada").getValue().toString();
                saida = dataSnapshot.child("horariosaida").getValue().toString();
                peso = dataSnapshot.child("peso").getValue().toString();

                nome.setText(fname);
                contato.setText(Html.fromHtml("<b>" + "Contato: " + "</b> " + contact));
                produto.setText(Html.fromHtml("<b>" + "Produto e quantidade: " + "</b> " + product));
                localizacao.setText(Html.fromHtml("<b>" + "Localização: " + "</b> " + location));
                exit.setText(Html.fromHtml("<b>" + "Chegada: " + "</b> " + saida));
                arrival.setText(Html.fromHtml("<b>" + "Saída: " + "</b> " + chegada));
                weight.setText(Html.fromHtml("<b>" + "Peso: " + "</b> " + peso));

                preco.setText("R$" + price);


                entrega = new Entrega(contact, fname, location, saida, chegada, peso, price, product);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityCaixa();
            }
        });

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String keyid = mDatabase.push().getKey();
                //FirebaseUser user = mFirebaseAuth.getInstance().getCurrentUser();
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                //String userId = (user.getProviderId());
                String userId = user.getUid();

                mDatabase = FirebaseDatabase.getInstance().getReference();

                //databaseReference.child("users").child(userId).setValue(user);

                //reff = FirebaseDatabase.getInstance().getReference().child("users").child(UserId).child("frete1");
                //reff.setValue(entrega);
                mDatabase.child("users").child(userId).child("frete1").setValue(entrega);

            }});
        }

        public void openActivityCaixa() {
            Intent intent = new Intent(this, Caixa.class);
            startActivity(intent);
        }



    }

//https://www.youtube.com/watch?v=GuMwCuvGWx4
//https://github.com/Galosoft10/FireMenu/blob/master/app/src/main/java/com/example/jose/firemenu/FoodDetail.java