package com.bhaktijkoli.androidanimations;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class ValueAnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = this.toString();
    private  Button btnStart;
    private TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
        getSupportActionBar().setTitle("Value Animator Example");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
        tvObject = (TextView) findViewById(R.id.tvObject);
    }

    private void startAnimation() {
//        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.value_animator);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 300f);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float progress = (float) animation.getAnimatedValue();
                tvObject.setTranslationY(progress);
            }
        });
        valueAnimator.start();
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
