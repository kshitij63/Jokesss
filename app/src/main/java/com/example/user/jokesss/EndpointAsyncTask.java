package com.example.user.jokesss;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.user.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by user on 6/22/2017.
 */

public class EndpointAsyncTask extends AsyncTask<Void,Void,String> {
    private static MyApi myApiService = null;
Context context;
    EndpointAsyncTask(Context context){
        this.context=context;
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://192.168.1.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
  //          MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
//                    .setRootUrl("https://android-app-backend.appspot.com/_ah/api/");

            myApiService = builder.build();
        }
        try {
            return myApiService.telljoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
    }
}
