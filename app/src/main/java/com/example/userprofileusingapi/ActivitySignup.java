package com.example.userprofileusingapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivitySignUp extends AppCompatActivity {
    EditText mEmailEt, mPasswordEt, mNameEt;
    Button buttonSignUpUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mEmailEt = findViewById(R.id.editTextEmailSignUp);
        mPasswordEt = findViewById(R.id.editTextPasswordSignUp);
        mNameEt = findViewById(R.id.editTexNameSignUp);
        buttonSignUpUser = findViewById(R.id.buttonSignUpUser);

        buttonSignUpUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpResponse();

            }
        });
    }

    public void signUpResponse() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SignUpRequestData signUpRequestData = new SignUpRequestData(mEmailEt.getText().toString(), mPasswordEt.getText().toString());
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<SignUpResponseData> call = apiInterface.getSignUpResponse(signUpRequestData);
        call.enqueue(new Callback<SignUpResponseData>() {
            @Override
            public void onResponse(Call<SignUpResponseData> call, Response<SignUpResponseData> response) {
                if (response.isSuccessful()) {

                   // Toast.makeText(ActivitySignUp.this, "save success " + response.body().toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ActivitySignUp.this, ActivityLogin.class);
                    startActivity(intent);
                    Toast.makeText(ActivitySignUp.this, "signUp Successfully", Toast.LENGTH_SHORT).show();

                } else
                    try {

                        SignUpResponseData jObjError = new SignUpResponseData("","","user not found");
                        Toast.makeText(ActivitySignUp.this, jObjError.error, Toast.LENGTH_LONG).show();
                        // Toast.makeText(ActivityLogin.this, jObjError.token, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(ActivitySignUp.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
            }

            @Override
            public void onFailure(Call<SignUpResponseData> call, Throwable t) {
                Log.d("Call", "onFailure : " + t.getMessage());
                Toast.makeText(ActivitySignUp.this, "connect to internet", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
