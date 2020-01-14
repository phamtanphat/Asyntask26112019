package com.example.asyntask26112019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button mBtnDownload;
    ImageView mImageview;
    ProgressBar mProgress;
    TextView mTvLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnDownload = findViewById(R.id.buttonDownload);
        mImageview = findViewById(R.id.imageview);
        mProgress = findViewById(R.id.progressbar);
        mTvLoading = findViewById(R.id.textviewLoading);

        hideView(mProgress);
        hideView(mImageview);
        hideView(mTvLoading);

        mBtnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Xulydatientrinh().execute();
            }
        });
    }
    // 1 : Thông bắt đầu download
    // 2 : Hiện thị phần down load
    // 3 : Hiển thị ra tấm hình sau khi kết thúc

    class Xulydatientrinh extends AsyncTask<Void,String,Integer>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "Bắt đầu thực thi", Toast.LENGTH_SHORT).show();
            hideView(mBtnDownload);
            showView(mTvLoading);
            showView(mProgress);
        }

        @Override
        protected Integer doInBackground(Void... params) {
            int count = 0;
            for ( ; count <= 100 ;){
                count += new Random().nextInt(10) + 1;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(String.valueOf(count));
            }
            return R.mipmap.ic_launcher;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            mProgress.setProgress(Integer.parseInt(values[0]));
            mTvLoading.setText("Loading : " + mProgress.getProgress() + "%");
        }

        @Override
        protected void onPostExecute(Integer s) {
            super.onPostExecute(s);
            showView(mImageview);
            hideView(mBtnDownload);
            hideView(mProgress);
            hideView(mTvLoading);
            mImageview.setImageResource(s);
        }
    }

    private void hideView(View v){
        v.setVisibility(View.GONE);
    }
    private void showView(View v){
        v.setVisibility(View.VISIBLE);
    }
}
