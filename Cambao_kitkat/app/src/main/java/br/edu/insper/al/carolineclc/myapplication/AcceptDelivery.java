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

public class AcceptDelivery extends AppCompatActivity {
    private TextView nome, contato, localizacao, produto, preco, exit, arrival, weight;
    private Button accept, decline, accept2, accept3;
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


        accept=findViewById(R.id.buttonEntregue);
        decline=findViewById(R.id.buttonDecline);

        accept2=findViewById(R.id.buttonC2);
        accept3=findViewById(R.id.buttonC3);


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


        DatabaseReference reff = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = reff.child("users");


        Log.v("USERID", userRef.getKey());

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();



        userRef.addValueEventListener(new ValueEventListener() {
            String nomef1, nomef2, nomef3,nomef4, nomef5, nomef6, caminhoes, price, saida, chegada, peso, nomec1, nomec2, nomec3;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String email = user.getEmail();
                nomef1 = dataSnapshot.child(uid).child("frete1").child("nome").getValue().toString();
                nomef2 = dataSnapshot.child(uid).child("frete2").child("nome").getValue().toString();
                nomef3 = dataSnapshot.child(uid).child("frete3").child("nome").getValue().toString();
                caminhoes = dataSnapshot.child(uid).child("caminhoes").getValue().toString();
                nomec1 = dataSnapshot.child(uid).child("nomec1").getValue().toString();
                nomec2 = dataSnapshot.child(uid).child("nomec2").getValue().toString();
                nomec3 = dataSnapshot.child(uid).child("nomec3").getValue().toString();

                System.out.println(nomef1);
                System.out.println(nomef2);
                System.out.println(nomef3);
                System.out.println(caminhoes);

                accept.setText(nomec1);
                accept2.setText(nomec2);
                accept3.setText(nomec3);



                accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // onDataChange(reff);

                System.out.println("nomef1");

                ///////////////////////////////////////////////////////////////
                if (TextUtils.isEmpty(nomef1)) {
                    reff.child("users").child(uid).child("frete1").setValue(entrega);
                    Toast.makeText(AcceptDelivery.this, "Frete adicionado", Toast.LENGTH_LONG).show();

                } else if ((!(nomef1).equals("")) && (nomef2).equals("") && Integer.parseInt(caminhoes) >= 2) {
                    reff.child("users").child(uid).child("frete2").setValue(entrega);
                    Toast.makeText(AcceptDelivery.this, "Frete adicionado", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(AcceptDelivery.this, "Este caminhão está muito ocupado! Complete alguma entrega para aceitar o novo frete", Toast.LENGTH_LONG).show();
                }

                openMainScreen();
            }});

                if (Integer.parseInt(caminhoes) >= 2){
                    accept2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // onDataChange(reff);

                            System.out.println("nomef1");

                            ///////////////////////////////////////////////////////////////
                            if (TextUtils.isEmpty(nomef3)) {
                                reff.child("users").child(uid).child("frete1").setValue(entrega);
                                Toast.makeText(AcceptDelivery.this, "Frete adicionado", Toast.LENGTH_LONG).show();

                            } else if ((!(nomef3).equals("")) && (nomef4).equals("") && Integer.parseInt(caminhoes) >= 2) {
                                reff.child("users").child(uid).child("frete2").setValue(entrega);
                                Toast.makeText(AcceptDelivery.this, "Frete adicionado", Toast.LENGTH_LONG).show();

                            } else {
                                Toast.makeText(AcceptDelivery.this, "Este caminhão está muito ocupado! Complete alguma entrega para aceitar o novo frete", Toast.LENGTH_LONG).show();
                            }

                            openMainScreen();
                        }});
                }

                if (Integer.parseInt(caminhoes)==3){
                    accept2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // onDataChange(reff);

                            System.out.println("nomef1");

                            ///////////////////////////////////////////////////////////////
                            if (TextUtils.isEmpty(nomef5)) {
                                reff.child("users").child(uid).child("frete1").setValue(entrega);
                                Toast.makeText(AcceptDelivery.this, "Frete adicionado", Toast.LENGTH_LONG).show();

                            } else if ((!(nomef5).equals("")) && (nomef6).equals("") && Integer.parseInt(caminhoes) >= 2) {
                                reff.child("users").child(uid).child("frete2").setValue(entrega);
                                Toast.makeText(AcceptDelivery.this, "Frete adicionado", Toast.LENGTH_LONG).show();

                            } else {
                                Toast.makeText(AcceptDelivery.this, "Este caminhão está muito ocupado! Complete alguma entrega para aceitar o novo frete", Toast.LENGTH_LONG).show();
                            }

                            openMainScreen();
                        }});
                }


                if (caminhoes.equals("2")){
                    accept3.setVisibility(View.GONE);

                }else if (caminhoes.equals("1")){
                    accept2.setVisibility(View.GONE);
                    accept3.setVisibility(View.GONE);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("cancelouuuuuuu");

            }
            ////////////////////////////////////////////////////
        });}
        public void openActivityCaixa() {
            Intent intent = new Intent(this, Caixa.class);
            startActivity(intent);
        }

    public void openMainScreen() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }



    }

//https://www.youtube.com/watch?v=GuMwCuvGWx4
//https://github.com/Galosoft10/FireMenu/blob/master/app/src/main/java/com/example/jose/firemenu/FoodDetail.java