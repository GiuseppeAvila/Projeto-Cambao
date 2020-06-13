package br.edu.insper.al.carolineclc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Caixa extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    private ImageButton contato;
    private ImageButton caixa;
    private ImageButton caminhao;
    private ImageButton btn;
    private TextView empresa1;
    DatabaseReference reff;
    EditText nameeditText,urleditText;
    Button btnsave;
    ListView listView;
    //FirebaseClient firebaseClient;
    EditText GetValue;


    private final String TAG = this.getClass().getName().toUpperCase();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caixa);
        contato = (ImageButton) findViewById(R.id.contato_caixa);
        caminhao = (ImageButton) findViewById(R.id.caminhao_caixa);
        caixa = (ImageButton) findViewById(R.id.caixa_caixa);
        //GetValue = findViewById(R.id.editText1);

        Spinner spinnerQuantidade = (Spinner) findViewById(R.id.spinner);
        String[] numeros = new String[] {"Nome","Horário","Valor","Cidade"};
        ArrayAdapter<String> adapterNum =  new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, numeros);
        adapterNum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerQuantidade.setAdapter(adapterNum);
        spinnerQuantidade.setOnItemSelectedListener(this);



        //empresa1=findViewById(R.id.empresa1);
        // btn=(ImageButton) findViewById(R.id.imageButton15);
        ListView listview = (ListView) findViewById(R.id.listView1);
        listview.setOnItemClickListener(this);


        reff = FirebaseDatabase.getInstance().getReference().child("empresas");
        String[] ListElements = new String[]{};

        final List<String> ListElementsArrayList = new ArrayList<>(Arrays.asList(ListElements));
        final ArrayAdapter<String> adapter = new ArrayAdapter<>
                (Caixa.this, android.R.layout.simple_list_item_1, ListElementsArrayList);
        listview.setAdapter(adapter);

        // Read from the database
        reff.addValueEventListener(new ValueEventListener() {
            String fname, contact, product, location, price;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {

                    fname = childDataSnapshot.child("nome").getValue().toString();
                    //empresa1.setText(fname);
                    ListElementsArrayList.add(fname);
                    adapter.notifyDataSetChanged();

                }
                System.out.println(ListElementsArrayList);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
    public void openActivityAccept() {
        Intent intent = new Intent(this, AcceptDelivery.class);
        startActivity(intent);
    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        Log.i("HelloListView", "You clicked Item: " + id + " at position:" + position);
        System.out.println(id);
        // Then you start a new Activity via Intent
        Intent intent = new Intent();
        intent.setClass(this, AcceptDelivery.class);
       // intent.putExtra("position", position);
        // Or / And
        intent.putExtra("id", (new Long(id)).toString());
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}


//https://stackoverflow.com/questions/13281197/android-how-to-create-clickable-listview