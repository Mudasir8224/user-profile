package com.example.userprofileusingapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityLogin extends AppCompatActivity {

    TextView emailtv, passwordtv;
    Button buttonLogin,buttonSignUp;
    String semail, spassword;
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailtv = findViewById(R.id.editTextEmail);
        passwordtv = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogIn);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        sharedPreferences = getSharedPreferences("prefStore",MODE_PRIVATE);
        String value = sharedPreferences.getString("token","");

        if (!value.equals("")){

            //Toast.makeText(this, "token value is "+value, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ActivityLogin.this,MainActivity.class);
            startActivity(intent);
            finish();

        }

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                semail = emailtv.getText().toString();
                spassword = passwordtv.getText().toString();
               /* if (semail.isEmpty()) {
                    emailtv.setError("email required");
                    emailtv.requestFocus();
                    return;
                }
                if (spassword.isEmpty()) {
                    passwordtv.setError("password required");
                    passwordtv.requestFocus();
                    return;
                }

                */

                loginResponse();


            }

        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this, ActivitySignUp.class);
                startActivity(intent);
            }
        });

    }

    public void loginResponse() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LogInUserData logInUserData = new LogInUserData(emailtv.getText().toString(), passwordtv.getText().toString());
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<LogInUserResponse> call = apiInterface.getLogInResponse(logInUserData);
        call.enqueue(new Callback<LogInUserResponse>() {
            @Override
            public void onResponse(Call<LogInUserResponse> call, final Response<LogInUserResponse> response) {

                if (response.isSuccessful()) {

                    String m = response.body().toString();
                     SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("token", m);
                    Log.d("Save", "response save :" + response.body().getToken());
                    editor.apply();

                  // Toast.makeText(ActivityLogin.this, "save success " + response.body().token, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(ActivityLogin.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                } else
                    try {
                        // SharedPreferences preferences = getSharedPreferences(myPreference,Context.MODE_PRIVATE);
                        // String hh  = preferences.getString("myPref",null);
                        // hh = buttonLogin.getText().toString();
                        LogInUserResponse jObjError = new LogInUserResponse("login", "user not found");
                        Toast.makeText(ActivityLogin.this, jObjError.error, Toast.LENGTH_LONG).show();
                        // Toast.makeText(ActivityLogin.this, jObjError.token, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(ActivityLogin.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }

            }

            @Override
            public void onFailure(Call<LogInUserResponse> call, Throwable t) {
                Log.d("Call", "onFailure : " + t.getMessage());
                Toast.makeText(ActivityLogin.this, "connect to internet", Toast.LENGTH_SHORT).show();

            }
        });


    }


}
