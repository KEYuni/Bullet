package com.keyuni.android.bullet.Helper;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.keyuni.android.bullet.model.Accounts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class BackgroundTask extends AsyncTask<Void, Accounts, Void> {
    String json_string = "bullet-finance.atwebpages.com";

    Context context;
    Activity activity;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Accounts> users = new ArrayList<>();

    public BackgroundTask(Context ctx){
        this.context = ctx;
        activity = (Activity)ctx;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL(json_string);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ( (line = bufferedReader.readLine()) != null ){
                stringBuilder.append(line+"\n");
            }

            httpURLConnection.disconnect();
            String json_string = stringBuilder.toString().trim();
            JSONObject jsonObject = new JSONObject(json_string);
            JSONArray jsonArray = jsonObject.getJSONArray("server_response");

            int count = 0;

            while (count<jsonArray.length()){
                JSONObject jo = jsonArray.getJSONObject(count);
                count++;

                Accounts user = new Accounts(jo.getInt("koin"), jo.getString("nama"), jo.getString("email"), jo.getString("no_hp"), jo.getString("alamat"), jo.getString("kata_sandi"), jo.getString("konfisrmasi_sandi"));
                publishProgress(user);
            }

            Log.d("JSON_STRING", json_string);

        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
    /*@Override
    protected void onPreExecute() {
        recyclerView = (RecyclerView)activity.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new HomeAdapter(users);
        recyclerView.setAdapter(adapter);
    }*/

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }

    @Override
    protected void onProgressUpdate(Accounts... values) {
        users.add(values[0]);
        adapter.notifyDataSetChanged();
    }
}
