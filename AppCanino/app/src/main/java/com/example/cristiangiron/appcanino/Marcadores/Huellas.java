package com.example.cristiangiron.appcanino.Marcadores;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.cristiangiron.appcanino.R;
import com.example.cristiangiron.appcanino.Reserva;
import com.example.cristiangiron.appcanino.models.SimpleResponse;
import com.example.cristiangiron.appcanino.net.ReservaService;
import com.example.cristiangiron.appcanino.util.Data;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Huellas extends AppCompatActivity implements View.OnClickListener, Callback<SimpleResponse> {
    Button bfecha,bhora,btnguardar;
    EditText efecha,ehora;
    private  int dia,mes,ano,hora,minutos;
    FloatingActionButton btnfav;
    SharedPreferences preferences;
    TextView textNombre;
    ReservaService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huellas);

        bfecha=(Button)findViewById(R.id.bfecha);
        bhora=(Button)findViewById(R.id.bhora);
        efecha=(EditText)findViewById(R.id.efecha);
        ehora=(EditText)findViewById(R.id.ehora);
        btnguardar = (Button) findViewById(R.id.btnguardar);
        bfecha.setOnClickListener(this);
        bhora.setOnClickListener(this);
        btnfav = (FloatingActionButton) findViewById(R.id.btnfav);
        btnfav.setOnClickListener(this);
        btnguardar.setOnClickListener(this);
        preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        textNombre = (TextView) findViewById(R.id.textNombre);
        service = Data.retrofit.create(ReservaService.class);



    }

    @Override
    public void onClick(View v) {
        if(v==bfecha){
            final Calendar c= Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            ano=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    efecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
                    ,dia,mes,ano);
            datePickerDialog.show();
        }
        if (v==bhora){
            final Calendar c= Calendar.getInstance();
            hora=c.get(Calendar.HOUR_OF_DAY);
            minutos=c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    ehora.setText(hourOfDay+":"+minute);
                }
            },hora,minutos,false);
            timePickerDialog.show();
        }

        if (v == btnfav) {
            btnfav.setImageResource(R.drawable.iconofavorite);
            Toast.makeText(this,"Añadido a faviritos", Toast.LENGTH_SHORT).show();
        }

        if(v == btnguardar){
            save();
            addReserva();
        }

    }
    public  void save(){
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("fecha", efecha.getText().toString());
        editor.putString("hora", ehora.getText().toString());
        editor.putString("nombre", textNombre.getText().toString());
        editor.apply();



    }
    public  void addReserva(){

        String fecha = preferences.getString("fecha", "");
        String hora = preferences.getString("hora", "");
        String nombre = preferences.getString("nombre", "");

        Reserva reserva = new Reserva(fecha, hora, nombre);
        service.insert(reserva).enqueue(this);
    }


    @Override
    public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
        if(response.isSuccessful()){
            SimpleResponse res = response.body();
            if(res.isSuccess()){
                Toast.makeText(Huellas.this, "Reserva Guardada", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(Huellas.this, "Error Al Reservar", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void onFailure(Call<SimpleResponse> call, Throwable t) {

    }

}
