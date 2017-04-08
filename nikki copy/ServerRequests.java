package com.example.dcs_madl13.nikki;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;

import org.apache.http.params.HttpParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dcs-madl13 on 4/8/17.
 */

public class ServerRequests {

    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT = 1000 * 15;
    public static final String SERVER_ADDRESS = "http://tonikami.tv.hostei.com";

    public ServerRequests(Context context){
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait...");

    }

    public void storeUserDataInBackgroud(User user, GetUserCallback userCallback){
        progressDialog.show();
        new StoreUserDataAsyncTask(user, userCallback).execute();
    }

    public void fetchUserDataInBackgroud(User user, GetUserCallback callback){
        progressDialog.show();
    }

    public class StoreUserDataAsyncTask extends AsyncTask<Void, Void, Void>{

        User user;
        GetUserCallback userCallback;

        public StoreUserDataAsyncTask(User user, GetUserCallback userCallback){
            this.user = user;
            this.userCallback = userCallback;

        }


        @Override
        protected Void doInBackground(Void... params) {
            Map<String, String> dataToSend = new HashMap<>();
            dataToSend.put("name", user.name);
            dataToSend.put("age", user.age + "");
            dataToSend.put("username", user.username);
            dataToSend.put("password", user.password);

            //12:22 sa video
            //https://www.youtube.com/watch?v=M4VTi5-Aw20
            //HttpParams httpRequestParams = new BasicHttpParams();

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progressDialog.dismiss();
            userCallback.done(null);

            super.onPostExecute(aVoid);
        }
    }
}
