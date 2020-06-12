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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Caixa extends AppCompatActivity {
    private ImageButton contato;
    private ImageButton caixa;
    private ImageButton caminhao;
    private ImageButton btn;
    private TextView empresa1;
    DatabaseReference reff;
    private final String TAG = this.getClass().getName().toUpperCase();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caixa);
        contato = (ImageButton) findViewById(R.id.contato_caixa);
        caminhao = (ImageButton) findViewById(R.id.caminhao_caixa);
        caixa = (ImageButton) findViewById(R.id.caixa_caixa);

        empresa1=findViewById(R.id.empresa1);


        btn=(ImageButton) findViewById(R.id.imageButton15);

        reff = FirebaseDatabase.getInstance().getReference().child("empresas").child("empresa1");

        // Read from the database
        reff.addValueEventListener(new ValueEventListener() {
            String fname, contact, product, location, price;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                fname = dataSnapshot.child("nome").getValue().toString();
                empresa1.setText(fname);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openActivityAccept();
        }
    });}
    public void openActivityAccept() {
        Intent intent = new Intent(this, AcceptDelivery.class);
        startActivity(intent);
    }
}
