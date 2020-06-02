package br.edu.insper.al.carolineclc.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import java.util.Arrays;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class NovoCadastro extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Button concluir;
    FirebaseAuth mFirebaseAuth;
    private EditText emailId, password, placa, telefone, nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_cadastro);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.email);
        password = findViewById(R.id.senha);
        nome = findViewById(R.id.nome);
        placa = findViewById(R.id.placa);
        telefone = findViewById(R.id.telefone);
        concluir = (Button) findViewById(R.id.button);




        Spinner spinnerCaminhao = (Spinner) findViewById(R.id.spinner);
        String[] items = new String[] {"Tipo do veículo","Carreta","Carreta LS","Vanderléia","Bitrem","Rodotrem","Truck","Bitruck","VCL","3/4","Toco"};
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCaminhao.setAdapter(adapter);
        spinnerCaminhao.setOnItemSelectedListener(this);


        Spinner spinnerQuantidade = (Spinner) findViewById(R.id.spinner2);
        String[] numeros = new String[] {"Quantidade de veículos","1","2","3"};
        ArrayAdapter<String> adapterNum =  new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, numeros);
        adapterNum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerQuantidade.setAdapter(adapterNum);
        spinnerQuantidade.setOnItemSelectedListener(this);



        concluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                String name = emailId.getText().toString();
                String tel = password.getText().toString();
                String plate = emailId.getText().toString();

                if(email.isEmpty()){
                    emailId.setError("Por favor, informe seu email");
                    emailId.requestFocus();
                } else  if(pwd.isEmpty()){
                    password.setError("Por favor, informe sua senha");
                    password.requestFocus();
                } else  if(name.isEmpty()){
                    password.setError("Por favor, informe seu nome");
                    password.requestFocus();
                }else  if(tel.isEmpty()){
                    password.setError("Por favor, informe seu telefone");
                    password.requestFocus();
                }else  if(plate.isEmpty()){
                    password.setError("Por favor, informe sua placa");
                    password.requestFocus();
                }
                else  if(email.isEmpty() && pwd.isEmpty() && name.isEmpty() && tel.isEmpty() && plate.isEmpty()){
                    Toast.makeText(NovoCadastro.this,"Crie o cadastro para começar",Toast.LENGTH_SHORT).show();
                }

                else  if(!(email.isEmpty() && pwd.isEmpty() && name.isEmpty() && tel.isEmpty() && plate.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(NovoCadastro.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(NovoCadastro.this,"Houve um problema no cadastro. Por favor, tente novamente",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                startActivity(new Intent(NovoCadastro.this,MainActivity.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(NovoCadastro.this,"Houve um problema no cadastro",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }



    public void openActivityLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}