package com.example.cristiangiron.appcanino;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by CristianGiron on 1/06/2017.
 */

public class ListaReservaciones extends AppCompatActivity implements View.OnClickListener {

    TextView textfecha,texthora,textLugar;
    Button btnAceptar;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_reservaciones);

        textfecha = (TextView) findViewById(R.id.textfecha);
        texthora = (TextView) findViewById(R.id.texthora);
        textLugar = (TextView) findViewById(R.id.textLugar);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(this);

        preferences = getSharedPreferences("preferences", MODE_PRIVATE);

        String fecha = preferences.getString("fecha","");
        textfecha.setText(fecha);

        String hora = preferences.getString("hora","");
        texthora.setText(hora);

        String nombre = preferences.getString("nombre","");
        textLugar.setText(nombre);

    }




    @Override
    public void onClick(View v) {
        finish();
    }


}
