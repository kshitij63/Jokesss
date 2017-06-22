package com.example.jokedisplaylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {
String jokes;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Bundle bundle=getIntent().getExtras();
        jokes=bundle.getString("jokes");
        textView=(TextView) findViewById(R.id.joke_dis);
        textView.setText(jokes);
        //Toast.makeText(this,jokes,Toast.LENGTH_SHORT).show();

    }
}
