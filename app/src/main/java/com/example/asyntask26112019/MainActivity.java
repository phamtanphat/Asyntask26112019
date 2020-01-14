package com.example.asyntask26112019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //1 : Params -> Tham số đầu vào của doInbackground
    //2 : Progress -> Tham số đầu vào của onProgressUpdate , publicProgress
    //3 : Result ->
            // + Giá trị trả về sau khi thực thi xong doInBackground,
            // + Giá trị đầu vào của onPostExcute
    class Xulydatientrinh extends AsyncTask<String,String,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("BBB","onPresExecute");
        }

        @Override
        protected String doInBackground(String... strings) {
            Log.d("BBB","doInBackground");
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            Log.d("BBB","onProgressUpdate");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("BBB","onPostExecute");
        }
    }
}
