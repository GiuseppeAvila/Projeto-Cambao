package br.edu.insper.al.carolineclc.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText emailId, password;
    private Button loginbtn;
    private Button cadastrobtn;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth auth;

    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mFirebaseAuth=FirebaseAuth.getInstance();
        emailId=findViewById(R.id.TextUsuario);
        password=findViewById(R.id.TextSenha);

        loginbtn = (Button) findViewById(R.id.ButtonLogin);
        cadastrobtn = (Button) findViewById(R.id.ButtonCadastro);


        auth = FirebaseAuth.getInstance();

        cadastrobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NovoCadastro.class));
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(emailId);

                String email = emailId.getText().toString();
                final String senha = password.getText().toString();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Enter email address !",Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(senha)){
                    Toast.makeText(getApplicationContext(),"Enter password ! ",Toast.LENGTH_LONG).show();
                    return;
                }
                //progressBar.setVisibility(View.VISIBLE);

                //auth user
                auth.signInWithEmailAndPassword(email,senha).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       // progressBar.setVisibility(View.GONE);
                        if(!task.isSuccessful()){
                            //there was an error
                            if(password.length()<6){
                                password.setError("minimo de 6 caracteres");
                            }else {
                                Toast.makeText(MainActivity.this,"auth_failed",Toast.LENGTH_LONG).show();
                            }
                        }else {
                            Intent intent = new Intent(MainActivity.this, Bottom_nav.class);
                            startActivity(intent);
                            finish();
                        }

                    }
                });
            }
        });


    }}

