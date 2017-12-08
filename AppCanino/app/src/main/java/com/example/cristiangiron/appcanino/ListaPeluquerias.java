package com.example.cristiangiron.appcanino;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import com.example.cristiangiron.appcanino.databinding.ActivityListaPeluqueriasBinding;

public class ListaPeluquerias extends AppCompatActivity {

    SharedPreferences preferences;
    Context context;


    ActivityListaPeluqueriasBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lista_peluquerias);

        preferences = getSharedPreferences("preferences", context.MODE_PRIVATE);

        String fecha = preferences.getString("fecha","");
        binding.textView9.setText(fecha);




    }


}
