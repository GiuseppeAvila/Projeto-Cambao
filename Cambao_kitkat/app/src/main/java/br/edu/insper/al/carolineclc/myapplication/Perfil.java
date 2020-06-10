package br.edu.insper.al.carolineclc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
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
    private TextView nome, tel, mail, truck;
    private final String TAG = this.getClass().getName().toUpperCase();
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private Map<String, String> userMap;
    private String email;
    private String userid;
    private String name;

    private static final String USERS = "users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Intent intent = getIntent();
        email = intent.getStringExtra("email");
       // name = intent.getStringExtra("nome");

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = rootRef.child(USERS);
        Log.v("USERID", userRef.getKey());

        nome = findViewById(R.id.userName);
        tel = findViewById(R.id.userPhone);
        mail = findViewById(R.id.userEmail);
        truck = findViewById(R.id.userTruck);

        getUserProfile();
       // getProviderData();

    }
        public void getUserProfile() {

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                String userId = user.getUid();

                // Name, email address, and profile photo Url
                String name = user.getDisplayName();
                String email = user.getEmail();

                String UserId = (user.getProviderId());
                DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("users").child(UserId);
                DatabaseReference f = reff.child("caminhoes");
                String x= reff.getKey();



                reff.addValueEventListener(new ValueEventListener() {
                    String fname, contact, product, location, price, saida, chegada, peso;
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //fname = dataSnapshot.child("fullName").getValue().toString();
                        //contact = dataSnapshot.child("phone").getValue().toString();
                       // product = dataSnapshot.child("email").getValue().toString();
                        //location = dataSnapshot.child("caminhoes").getValue().toString();

                        nome.setText(name);
                        tel.setText(Html.fromHtml("<b>" + "Telefone: " + "</b> " +  x));
                        mail.setText(Html.fromHtml("<b>" + "Email: " + "</b> " + email));
                        truck.setText(Html.fromHtml("<b>" + "Quantidade atual de caminhões: " + "</b> " + f));

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


                }}

    public void getProviderData() {
        // [START get_provider_data]
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            for (UserInfo profile : user.getProviderData()) {
                // Id of the provider (ex: google.com)
                String providerId = profile.getProviderId();

                // UID specific to the provider
                String uid = profile.getUid();

                // Name, email address, and profile photo Url
                //String name = profile.getDisplayName();
                String email = profile.getEmail();
               // Uri photoUrl = profile.getPhotoUrl();



        }}
        // [END get_provider_data]
    }
    }

