package com.example.lecture8.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.lecture8.R;


public class Screen1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_screen1, container, false);

        final Button btnInsert = root.findViewById(R.id.btnInsert);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sp = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("a", 5);
                editor.putInt("b", 5);

                editor.putString("name1", "yousef");
                editor.putString("name2", "ali");

                editor.putBoolean("isActive", true);
                editor.putBoolean("isHere", false);

                if (editor.commit()) {

                    Toast.makeText(getActivity(), "Add Succefully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                }

                }
            });



        final Button btnSelect = root.findViewById(R.id.btnSelect);

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sp =getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);

                int a = sp.getInt("a", -1);
                int b = sp.getInt("b", -1);

                String name1 = sp.getString("name1", "");
                String name2 = sp.getString("name2", "");

                Boolean isActive = sp.getBoolean("isActive", false);
                Boolean isHere = sp.getBoolean("isHere", false);

                Toast.makeText(getActivity(), "a = " + a + ", b = " + b + ", name1 = " + name1 + ", name2 = " + name2
                       + ", isActive = " + isActive + ", isHere = " + isHere , Toast.LENGTH_LONG).show();

            }
        });


        final Button btnUpdat = root.findViewById(R.id.btnUpdat);

        btnUpdat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sp = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                editor.putInt("a", 100);

                if(editor.commit()){
                    Toast.makeText(getActivity(), "Update Sucessfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity(), "Update Fail", Toast.LENGTH_SHORT).show();
                }

            }
        });

        final Button btnDelete = root.findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.remove("a").apply();
                if(editor.commit()){
                    Toast.makeText(getActivity(), "Delete Successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity(), "Delete fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final Button btnClear = root.findViewById(R.id.btnClear);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.clear().apply();
                if(editor.commit()){
                    Toast.makeText(getActivity(), "Clear Successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity(), "Clear fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
        }
    }