package com.example.cristiangiron.appcanino;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cristiangiron.appcanino.databinding.ActivityMainBinding;
import com.example.cristiangiron.appcanino.models.SimpleResponse;
import com.example.cristiangiron.appcanino.net.UserService;
import com.example.cristiangiron.appcanino.util.Data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {

    ActivityMainBinding binding;
    // esto es nuevo
    UserService service;
    SharedPreferences preferences;
    //hasta aqui
    private DbAppcanino db;
    private Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //nuevo

            preferences = getSharedPreferences("preferences",MODE_PRIVATE);

        boolean logged = preferences.getBoolean("logged", false);
        if(logged){
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        //hasta aqui
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main );
        binding.setHandler(this);
        binding.setHandlerRegistro(this);
       /* binding.setHandler(this);
        binding.setHandlerRegistro(this); */
     //   binding.btnLogin.setOnClickListener(this);
      //  binding.btnReg.setOnClickListener(this);

        //esto es nuevo
        service = Data.retrofit.create(UserService.class);

        //hasta aqui

        //db = new DbAppcanino(this);
        //session = new Session(this);

        //if(session.loggedin()){
          //  startActivity(new Intent(MainActivity.this, MapsActivity.class ));
            //finish();

        //}
    }


    public void goToRegister(){
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }



    //region Description
   /* public void goToNext(){
       // String usr = binding.usuario.getEditText().getText().toString();
        // String pass = binding.password.getEditText().getText().toString();

        Intent intent = new Intent( MainActivity.this, MapsActivity.class);
        startActivity(intent);

    }

    public void goToRegistro(){
        Intent intent = new Intent( MainActivity.this, RegistroActivity.class);
        startActivity(intent);

    }

*/
    //endregion
    //SharedPreferences

    //@Override
   // public void onClick(View v) {
     //   switch (v.getId()){
       //     case R.id.btnLogin:
         //       login();
           //     break;

            //case R.id.btnReg:
              //  startActivity(new Intent(MainActivity.this, RegistroActivity.class));
               // break;
           // default:
       // }

    //}

    public void login(){
        final String email = binding.etEmail.getText().toString();
        String pass = binding.etPass.getText().toString();

        //esto es nuevo
        User user = new User(email, pass);
        Call<SimpleResponse> request = service.login(user);

        request.enqueue(new Callback<SimpleResponse>() {
            @Override
            public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
                if(response.isSuccessful()){
                    SimpleResponse res = response.body();

                    if(res.isSuccess()){
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean("logged", true);
                        editor.apply();
                        editor.putString("email", email);
                        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, res.getMsg(),Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<SimpleResponse> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Error al conectarse", Toast.LENGTH_SHORT).show();

            }
        });
        //hasta aqui

        //if(db.getUser(email,pass)){
            //session.setLoggedin(true);
            //startActivity(new Intent(MainActivity.this, MapsActivity.class));
          //  finish();
        //} else{
            //Toast.makeText(getApplicationContext(), "EMAIL O CONTRASEÑA INCORRECTOS", Toast.LENGTH_SHORT).show();
      //  }

    }

}

