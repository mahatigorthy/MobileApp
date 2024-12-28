package com.example.addingviewsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout layout;
    TextView textViewInCode;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Reference Layout Set Up in XML
        layout = findViewById(R.id.layout);
        // Create TextView Programmatically
        textViewInCode = new TextView(this); // Create a textView in "this" Context
        textViewInCode.setId(View.generateViewId()); // create an ID for the view
        textViewInCode.setText("HELLO AGAIN!"); // Set up what you want inside your view
        // Create ImageView Programmatically
        image = new ImageView(this);
        image.setId(View.generateViewId());
        image.setImageResource(R.drawable.harry);

        // Set up width/height parameters of the individual view
        // TextView Example [WRAP_CONTENT for width & height]
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        textViewInCode.setLayoutParams(params);
        // ImageView Example [MATCH_CONSTRAINT_PARENT*VALUE (Creates a Proportional View)]
        ConstraintLayout.LayoutParams params1 = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_PERCENT*80, ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_PERCENT*80);
        image.setLayoutParams(params1);

        // After setting width/height constraints, add views to the root layout
        layout.addView(textViewInCode);
        layout.addView(image);

        // This will allow us to save the constraints from the current layout and then add new constraints
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(layout);

        // this will allow us to bind the new widget to other things in the layout
        constraintSet.connect(textViewInCode.getId(), ConstraintSet.TOP, layout.getId(), ConstraintSet.TOP);
        constraintSet.connect(textViewInCode.getId(), ConstraintSet.BOTTOM, layout.getId(), ConstraintSet.BOTTOM);
        constraintSet.connect(textViewInCode.getId(), ConstraintSet.LEFT, layout.getId(), ConstraintSet.LEFT);
        constraintSet.connect(textViewInCode.getId(), ConstraintSet.RIGHT, layout.getId(), ConstraintSet.RIGHT);
        constraintSet.setVerticalBias(textViewInCode.getId(), .2f);
        constraintSet.setHorizontalBias(textViewInCode.getId(), .1f);


        constraintSet.connect(image.getId(), ConstraintSet.TOP, layout.getId(), ConstraintSet.TOP);
        constraintSet.connect(image.getId(), ConstraintSet.BOTTOM, layout.getId(), ConstraintSet.BOTTOM);
        constraintSet.connect(image.getId(), ConstraintSet.LEFT, layout.getId(), ConstraintSet.LEFT);
        constraintSet.connect(image.getId(), ConstraintSet.RIGHT, layout.getId(), ConstraintSet.RIGHT);
        constraintSet.setVerticalBias(image.getId(), .7f);
        constraintSet.setHorizontalBias(image.getId(), .5f);

        constraintSet.applyTo(layout);



    }
}