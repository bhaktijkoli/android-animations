package com.bhaktijkoli.androidanimations;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class ObjectAnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = this.toString();
    private Button btnStart;
    private TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
        getSupportActionBar().setTitle("Object Animator Example");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
        tvObject = (TextView) findViewById(R.id.tvObject);
    }

    private void startAnimation() {
//        ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.object_animator);
//        objectAnimator.setTarget(tvObject);
        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.value_animator);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tvObject, "translationY",0f,300f);
        objectAnimator.setDuration(1000);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.start();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v == btnStart) {
            this.startAnimation();
        }
    }
}
