package com.example.user.jokesss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.myapplication.backend.myApi.MyApi;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EndpointAsyncTask asyncTask=new EndpointAsyncTask(this);
        asyncTask.execute();
    }
}
