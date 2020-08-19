package com.bhaktijkoli.androidanimations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnValueAnimator;
    private Button btnObjectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnValueAnimator = (Button) findViewById(R.id.btnValueAnimator);
        btnObjectAnimator = (Button) findViewById(R.id.btnObjectAnimator);
        btnValueAnimator.setOnClickListener(this);
        btnObjectAnimator.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnValueAnimator) {
            Intent intent = new Intent(this, ValueAnimatorActivity.class);
            startActivity(intent);
        } else if(v == btnObjectAnimator) {
            Intent intent = new Intent(this, ObjectAnimatorActivity.class);
            startActivity(intent);
        }
    }
}
