package com.example.myapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String ls  = getResources().getString(R.string.link);
        try {


            String mysts = new Sycdata().execute(ls).get();
        }catch (ExecutionException e)
        {
            Log.e("main class","Mail"+e.getMessage());
        }catch (InterruptedException e){
            Log.e("main class","Mail"+e.getMessage());
        }
    }
}
