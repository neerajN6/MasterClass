package com.athrved.masterclass;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchData extends AsyncTask<Void, Void, Void> {
    String name, videoID="_vAmKNin0QM", data="", xyz;

    @Override
    protected Void doInBackground(Void... voids) {
        name="https://noembed.com/embed?url=https://www.youtube.com/watch?v="+videoID;
        try {
            URL url = new URL(name);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line!=null){
                line = bufferedReader.readLine();
                data = data+line;
            }

            JSONObject JO = new JSONObject(data);
           xyz= JO.get("title").toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
//        UiuxActivity.abcde.setText(this.xyz);
       FreeclassesAdapter.b=(this.xyz);
    }
}
