package com.example.corina.deutschlernen;

import android.os.AsyncTask;

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
import java.util.List;

/**
 * Created by Corina on 06.04.2019.
 */

public class ParsareJSOn  extends AsyncTask<String,Void,List<String>> {
    @Override
    protected List<String> doInBackground(String... strings) {
        List<String> lista=new ArrayList<>();
        try {
            URL url=new URL(strings[0]);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            InputStream inputStream=connection.getInputStream();

            InputStreamReader reader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(reader);
            String linie=null;
            StringBuilder json=new StringBuilder();
            while((linie=bufferedReader.readLine())!=null){
                json.append(linie);
            }
            bufferedReader.close();
            reader.close();

            JSONObject object=new JSONObject(json.toString());
            JSONArray jsonArray=object.getJSONArray("def");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject element=jsonArray.getJSONObject(i);
                JSONArray jsonArray1 = element.getJSONArray("tr");
                for(int j=0;j<jsonArray1.length();j++){
                    JSONObject element2=jsonArray1.getJSONObject(j);
                    lista.add(element2.getString("text"));
                    JSONArray jsonArray2 = element2.getJSONArray("syn");
                    for(int k=0;k<jsonArray2.length();k++){
                        JSONObject element3=jsonArray2.getJSONObject(k);
                        lista.add(element3.getString("text"));

                    }




                }
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  lista;
    }
}