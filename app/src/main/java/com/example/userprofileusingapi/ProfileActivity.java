package com.example.userprofileusingapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileActivity extends AppCompatActivity {

    String emailUser,idUser,firstNameUser,lastNameUser,imageUser;
    TextView id,firstName,lastName,email;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

       lastNameUser  = getIntent().getStringExtra("lastName");
        firstNameUser = getIntent().getStringExtra("firstName");
        idUser = getIntent().getStringExtra("id");
        emailUser = getIntent().getStringExtra("email");
        imageUser = getIntent().getStringExtra("image");

         email = findViewById(R.id.textViewEmailProfile);
        email.setText(emailUser);

        id = findViewById(R.id.textViewIdProfile);
        id.setText(idUser);

        firstName = findViewById(R.id.textViewFirstNameProfile);
        firstName.setText(firstNameUser);

        lastName = findViewById(R.id.textViewLastNameProfile);
        lastName.setText(lastNameUser);

        imageView = findViewById(R.id.imageViewUserProfile);
       // imageView.setTag(imageUser);
        Picasso.get().load(imageUser).into(imageView);



    }
}

