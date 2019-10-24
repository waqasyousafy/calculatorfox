package com.code4rox.calculatorfox;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class Constraintset_example_paractice_2 extends AppCompatActivity {

    ImageView javaimg, kotlinimg;
    ConstraintLayout root;
    int rootid;
    Context context;
    ConstraintSet newConstraintSet = new ConstraintSet();
    private View selectedview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraintset_example_paractice_2);
        root = findViewById(R.id.layout);
        javaimg = (ImageView) findViewById(R.id.java_book);
        kotlinimg = (ImageView) findViewById(R.id.kotlin_book);
        SetupAnimation(context);
    }

    public void SetupAnimation(Context context) {

        selectedview = null;
        root.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                toDefault();
            }
        });
        javaimg.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (selectedview != javaimg) {
                    updateConstraints(R.layout.activity_constraintset_example_paractice_2_java);
                    selectedview = javaimg;
                } else {
                    toDefault();
                }
            }
        });
        kotlinimg.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (selectedview != kotlinimg) {
                    updateConstraints(R.layout.activity_constraintset_example_paractice_2_kotlin);
                    selectedview = kotlinimg;
                } else {
                    toDefault();
                }
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void toDefault() {
        if (selectedview != null) {
            updateConstraints(R.layout.activity_constraintset_example_paractice_2);
            selectedview = null;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void updateConstraints(int id) {

        newConstraintSet.clone(this, id);
        newConstraintSet.applyTo(root);
        TransitionManager.beginDelayedTransition(root);

    }
}
