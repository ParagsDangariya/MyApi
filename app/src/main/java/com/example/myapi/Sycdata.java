package com.example.myapi;

import android.os.AsyncTask;

public class Sycdata extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... strings) {

        String jsonuel = strings[0];

        HttpHandler sh = new HttpHandler();
        String json =sh.makeserviceCall(jsonuel);
        System.out.println("This is Json:"+json);

        return json;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
