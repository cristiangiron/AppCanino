package com.example.cristiangiron.appcanino.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cristiangiron.appcanino.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InformacionFragment extends Fragment {

    TextView text;

    public InformacionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v =  inflater.inflate(R.layout.fragment_informacion, container, false);

        TextView text = (TextView) v.findViewById(R.id.text);

        return  v;



    }

}
