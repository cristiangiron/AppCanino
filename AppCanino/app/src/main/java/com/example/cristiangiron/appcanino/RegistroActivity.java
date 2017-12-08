package com.example.cristiangiron.appcanino;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cristiangiron.appcanino.databinding.ActivityRegistroBinding;
import com.example.cristiangiron.appcanino.models.SimpleResponse;
import com.example.cristiangiron.appcanino.net.UserService;
import com.example.cristiangiron.appcanino.util.Data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroActivity extends AppCompatActivity implements  Callback<SimpleResponse> {



    ActivityRegistroBinding binding;

    //esto es nuevo
    UserService service;
    //hasta aqui

   // private DbAppcanino db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registro);
        binding.setRegistro(this);

        //esto es nuevo
        service = Data.retrofit.create(UserService.class);
        //hasta aqui

      /*  binding.setRegistro(this); */
       // binding.btnReg.setOnClickListener(this);

     //   db = new DbAppcanino(this);

    }

 /*   public void goToRegistro() {

        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }
*/
  //  @Override
   // public void onClick(View v) {
     //   switch (v.getId()){
       //     case R.id.btnReg:
         //       register();
           //     break;
             //   default:
        //}
    //}

    public void register(){
        String email = binding.etEmail.getText().toString();
        String pass = binding.etPass.getText().toString();
        String nombre = binding.etNombre.getText().toString();
        String passconfirm = binding.etConfir.getText().toString();

        //esto es nuevo

        //hasta aqui

      if(email.isEmpty() || pass.isEmpty()|| nombre.isEmpty() ||  passconfirm.isEmpty()){
        Toast.makeText(this,"Campos vacios",Toast.LENGTH_SHORT).show();

        }

        else{

          User user = new User(nombre, email, pass);

          Call<SimpleResponse> request = service.registro(user);

          request.enqueue(this);


      }
        //else if (email.isEmpty()){
         //   Toast.makeText(this,"Proporcione una direccion de Correo Electrónico", Toast.LENGTH_SHORT).show();

     //   } else if (pass.isEmpty()){
       //     Toast.makeText(this,"Cree una Contraseña", Toast.LENGTH_SHORT).show();

        //} else if (nombre.isEmpty()){
         //   Toast.makeText(this,"Campo de Nombre vacio", Toast.LENGTH_SHORT).show();

//        } else if (passconfirm.isEmpty()){
  //          Toast.makeText(this,"Confirme Contraseña", Toast.LENGTH_SHORT).show();
    //    }
      //  else{
        //    db.addUser(email,pass);
          //  Toast.makeText(this,"USUARIO REGISTRADO", Toast.LENGTH_SHORT).show();
            //finish();

        //}
    }

    //esto es nuevo

    @Override
    public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
        if(response.isSuccessful()){
            SimpleResponse res = response.body();
            if(res.isSuccess()){
                Toast.makeText(RegistroActivity.this, "Usuario Registrado", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(RegistroActivity.this, res.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onFailure(Call<SimpleResponse> call, Throwable t) {



    }

    //hasta aqui
}



