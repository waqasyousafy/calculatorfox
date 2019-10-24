package com.code4rox.calculatorfox;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;

import android.transition.TransitionManager;
import android.view.View;

public class constraint_layout_placeholder_example extends AppCompatActivity {
    private ConstraintLayout layout;
    public  Placeholder plch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout_placeholder_example);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        layout= findViewById(R.id.layout);
       plch=(Placeholder) findViewById(R.id.placeholder);
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void swapview(View v){
        TransitionManager.beginDelayedTransition(layout);
        plch.setContentId(v.getId());

    }

}
