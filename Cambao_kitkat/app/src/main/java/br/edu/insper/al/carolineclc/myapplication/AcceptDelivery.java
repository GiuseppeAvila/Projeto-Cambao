package br.edu.insper.al.carolineclc.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Snapshot;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AcceptDelivery extends AppCompatActivity {
    private TextView nome, contato, localizacao, produto, preco;
    private Button accept, decline;
    DatabaseReference reff;
    private final String TAG = this.getClass().getName().toUpperCase();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_delivery);

        nome=findViewById(R.id.nomeEmpresa);
        contato=findViewById(R.id.contatoEmpresa);
        localizacao=findViewById(R.id.localizacaoEmpresa);
        produto=findViewById(R.id.produtoEmpresa);
        preco=findViewById(R.id.precoEmpresa);

        accept=findViewById(R.id.buttonAccept);
        decline=findViewById(R.id.buttonDecline);


        reff = FirebaseDatabase.getInstance().getReference().child("empresas").child("empresa1");

        // Read from the database
        reff.addValueEventListener(new ValueEventListener() {
            String fname, contact, product, location, price, saida, chegada, peso;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
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
                        produto.setText(Html.fromHtml("<b>" +"Produto e quantidade: " + "</b> "+ product));
                        localizacao.setText(Html.fromHtml("<b>" +"Localização: " + "</b> "+ location));
                        preco.setText("R$" + price);

                Entrega entrega = new Entrega(contact, fname, location, saida, chegada, peso, price, product);

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
            }
        });}


        public void openActivityCaixa() {
            Intent intent = new Intent(this, Caixa.class);
            startActivity(intent);
        }



    }

//https://www.youtube.com/watch?v=GuMwCuvGWx4
