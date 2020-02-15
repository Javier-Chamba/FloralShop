package com.example.floralshop;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class Perfil extends Fragment {


    public Perfil() {
        // Required empty public constructor
    }

    View view;
    TextView txtCI, txtNombre, txtApellido;
    Button actualizar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_perfil, container, false);
        txtCI = (TextView) view.findViewById(R.id.txtCI);
        txtNombre = (TextView) view.findViewById(R.id.txtNombre);
        final TextView txtApellido = (TextView) view.findViewById(R.id.txtApellido);
        txtCI.setText("0321");

        Button btnActualizar = (Button) view.findViewById(R.id.btnActualizar);
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux=String.valueOf(txtNombre.getText().toString());
                txtApellido.setText(aux);
                //Intent intent = new Intent(getActivity(),MainActivity.class);
                //startActivity(intent);
            }
        });

        return view;
    }

}
