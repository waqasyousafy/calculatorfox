package com.code4rox.calculatorfox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Constraintlayout extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {

    String[] Speedformat={"KM/h","M/h"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraintlayout);


        Spinner spin=(Spinner) findViewById(R.id.dropdown_speed);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,Speedformat);
        aa.setDropDownViewResource(R.layout.spinner_color);
        spin.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView)parent.getChildAt(0);
        textView.setTextColor(getResources().getColor(R.color.colorgolden));
        Toast.makeText(getApplicationContext(),Speedformat[position] , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
