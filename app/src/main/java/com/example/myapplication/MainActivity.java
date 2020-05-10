package com.example.myapplication;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    SeekBar     mSeerbar1,mSeerbar2,mSeerbar3;
    CheckBox    mCheckbox1,mCheckbox2,mCheckbox3;
    ImageButton mImgbtnplay;
    TextView    mTvDiem;
    int mDiem =100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mapping();
        mSeerbar1.setEnabled(false);
        mSeerbar2.setEnabled(false);
        mSeerbar3.setEnabled(false);
        mTvDiem.setText(mDiem+"");
        final CountDownTimer countDownTimer = new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mSeerbar1.setProgress(getRandom(20)+ mSeerbar1.getProgress());
                mSeerbar2.setProgress(getRandom(20)+ mSeerbar2.getProgress());
                mSeerbar3.setProgress(getRandom(20)+ mSeerbar3.getProgress());
                if(mSeerbar1.getProgress()>=100){
                    this.cancel();
                    mImgbtnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "ONE WIN", Toast.LENGTH_SHORT).show();
                    if (mCheckbox1.isChecked())
                    {
                        mDiem+=20;
                    }
                    else {
                        mDiem -= 10;
                        Toast.makeText(MainActivity.this, "You Lose", Toast.LENGTH_SHORT).show();
                    }
                    mTvDiem.setText(mDiem+"");
                    EnableChecked();
                }
                if(mSeerbar2.getProgress()>=100){
                    this.cancel();
                    mImgbtnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "TWO WIN", Toast.LENGTH_SHORT).show();
                    if (mCheckbox2.isChecked())
                    {
                        mDiem+=20;
                    }
                    else{
                        mDiem-=10;
                        Toast.makeText(MainActivity.this, "You Lose", Toast.LENGTH_SHORT).show();
                    }
                    mTvDiem.setText(mDiem+"");
                    EnableChecked();
                }
                if(mSeerbar3.getProgress()>=100){
                    this.cancel();
                    mImgbtnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "THREE WIN", Toast.LENGTH_SHORT).show();
                    if (mCheckbox3.isChecked())
                    {
                        mDiem+=20;
                    }
                    else{
                        mDiem-=10;
                        Toast.makeText(MainActivity.this, "You Lose", Toast.LENGTH_SHORT).show();
                    }
                    mTvDiem.setText(mDiem+"");
                    EnableChecked();
                }
            }

            @Override
            public void onFinish() {

            }
        };
        mImgbtnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCheckbox1.isChecked()||mCheckbox2.isChecked()||mCheckbox3.isChecked()) {
                    countDownTimer.start();
                    DisableCheck();
                    mImgbtnplay.setVisibility(View.GONE);
                    mSeerbar1.setProgress(0);
                    mSeerbar2.setProgress(0);
                    mSeerbar3.setProgress(0);
                }
                else
                    Toast.makeText(MainActivity.this, "Bạn vui lòng stick đặt cược", Toast.LENGTH_SHORT).show();

            }
        });
        mCheckbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    mCheckbox2.setChecked(false);
                    mCheckbox3.setChecked(false);
                }
            }
        });
        mCheckbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    mCheckbox1.setChecked(false);
                    mCheckbox3.setChecked(false);
                }
            }
        });
        mCheckbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    mCheckbox1.setChecked(false);
                    mCheckbox2.setChecked(false);
                }
            }
        });
    }
    public void EnableChecked()
    {
        mCheckbox1.setEnabled(true);
        mCheckbox2.setEnabled(true);
        mCheckbox3.setEnabled(true);
    }
    public void DisableCheck()
    {
        mCheckbox1.setEnabled(false);
        mCheckbox2.setEnabled(false);
        mCheckbox3.setEnabled(false);
    }
    public int getRandom(int bound)
    {
        return new Random().nextInt(bound);
    }
    public void Mapping(){
        mSeerbar1   = findViewById(R.id.seerbar1);
        mSeerbar2   = findViewById(R.id.seerbar2);
        mSeerbar3   = findViewById(R.id.seerbar3);
        mCheckbox1  = findViewById(R.id.checkbox1);
        mCheckbox2  = findViewById(R.id.checkbox2);
        mCheckbox3  = findViewById(R.id.checkbox3);
        mImgbtnplay = findViewById(R.id.ImgbtnPlay);
        mTvDiem     = findViewById(R.id.TvDiem);
    }
}
