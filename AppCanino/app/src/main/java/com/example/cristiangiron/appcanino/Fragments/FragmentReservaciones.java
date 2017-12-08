package com.example.cristiangiron.appcanino.Fragments;


import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cristiangiron.appcanino.R;
import com.example.cristiangiron.appcanino.adapters.AdapterPeluqueria;
import com.example.cristiangiron.appcanino.databinding.ReservacionesFragmentBinding;
import com.example.cristiangiron.appcanino.util.Datos;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentReservaciones extends Fragment {

    ReservacionesFragmentBinding binding;
        AdapterPeluqueria adapter;


    public FragmentReservaciones() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(getLayoutInflater(null),R.layout.reservaciones_fragment, container, false);

        adapter = new AdapterPeluqueria(getLayoutInflater(null), Datos.getDatos());
        binding.listapeluquerias.setAdapter(adapter);
        binding.listapeluquerias.setLayoutManager(new LinearLayoutManager(getActivity()));

        return binding.getRoot();

    }

}
