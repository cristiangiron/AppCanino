package com.example.cristiangiron.appcanino.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cristiangiron.appcanino.Fragments.FragmentReservaciones;
import com.example.cristiangiron.appcanino.ListaPeluquerias;
import com.example.cristiangiron.appcanino.Marcadores.Animalitos;
import com.example.cristiangiron.appcanino.R;
import com.example.cristiangiron.appcanino.databinding.ActivityListaPeluqueriasBinding;
import com.example.cristiangiron.appcanino.databinding.ReservacionesFragmentBinding;
import com.example.cristiangiron.appcanino.models.Peluqueria01;
import com.example.cristiangiron.appcanino.util.Datos;

import java.util.List;

/**
 * Created by CristianGiron on 22/05/2017.
 */

public class AdapterPeluqueria extends RecyclerView.Adapter<AdapterPeluqueria.AdapterHolder> implements Toolbar.OnMenuItemClickListener {


    LayoutInflater inflater;
    List<Peluqueria01> data;



    public AdapterPeluqueria(LayoutInflater inflater, List<Peluqueria01> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public AdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.activity_lista_peluquerias, parent, false);
        return new AdapterHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterHolder holder, int position) {
    Peluqueria01 p = data.get(position);
        holder.binding.setPeluq(p);
        holder.binding.toolbar2.inflateMenu(R.menu.delete);
        holder.binding.toolbar2.setOnMenuItemClickListener(this);



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {


        return false;
    }

    static class AdapterHolder extends RecyclerView.ViewHolder{

        ActivityListaPeluqueriasBinding binding;

        public AdapterHolder (View itemView){
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

        }


    }
}
