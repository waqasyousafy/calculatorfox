package com.code4rox.calculatorfox;

import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class constraintset_example_concepts extends AppCompatActivity {

    ConstraintSet constraint1 = new ConstraintSet();
    ConstraintSet constraint2 = new ConstraintSet();
    ConstraintSet constraint = new ConstraintSet();
    ConstraintLayout root;
    boolean set;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraintset_example_concepts);
        root = findViewById(R.id.root);
    }

    public void addAnimationOperations(View view) {
        set = false;
        constraint1.clone(root);
        constraint2.clone(this, R.layout.activity_constraintset_example_concepts_2);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(root);
        }
        constraint = (set) ? constraint1 : constraint2;
        constraint.applyTo(root);
        set = !set;

    }

}
