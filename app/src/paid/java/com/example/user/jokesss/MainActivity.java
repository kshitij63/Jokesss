package com.example.user.jokesss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jokedisplaylibrary.DisplayActivity;


public class MainActivity extends AppCompatActivity implements Response {
String joke;
    Button button;
    ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.button);
        android.widget.Toast.makeText(this, "in paid", Toast.LENGTH_SHORT).show();

        bar=(ProgressBar) findViewById(R.id.bar);


        button.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                EndpointAsyncTask asyncTask=new EndpointAsyncTask(MainActivity.this);
                asyncTask.mediateResponse=MainActivity.this;
                bar.setVisibility(View.VISIBLE);
                asyncTask.execute();


            }
        });


    }

    @Override
    public void finished(String joke) {
        bar.setVisibility(View.INVISIBLE);
        this.joke=joke;
        Intent intent=new Intent(MainActivity.this, DisplayActivity.class);
        intent.putExtra("jokes",joke);
        startActivity(intent);
    }
}
