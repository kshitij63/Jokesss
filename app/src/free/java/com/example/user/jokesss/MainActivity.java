package com.example.user.jokesss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.jokedisplaylibrary.DisplayActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends AppCompatActivity implements Response {
    InterstitialAd mInterstitialAd;

    String joke;
    Button button;
    ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.button);

        bar=(ProgressBar) findViewById(R.id.bar);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interestial_ad_id));


        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();

            }
        });

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
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }


    @Override
    public void finished(String joke) {
        bar.setVisibility(View.INVISIBLE);
        this.joke=joke;
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
        else{
            Intent intent=new Intent(MainActivity.this, DisplayActivity.class);
            intent.putExtra("jokes",joke);
            startActivity(intent);
        }

    }
}
