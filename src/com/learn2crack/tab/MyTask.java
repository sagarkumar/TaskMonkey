package com.learn2crack.tab;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MyTask extends Fragment {

	String[] menutitles;
    TypedArray menuIcons;

    CustomAdapter adapter;
    private List<RowItem> rowItems;

    private class AsyncListViewLoader extends AsyncTask<String, Void, /*List<RowItem>*/ String> {
         
        @Override
        protected void onPostExecute(String result) {           
            super.onPostExecute(result);
            //adapter.setItemList(result);
            //adapter.notifyDataSetChanged();
        }
     
        @Override
        protected void onPreExecute() {       
            super.onPreExecute();        
        }
     
        @Override
        protected String doInBackground(String... params) {
            List<RowItem> result = new ArrayList<RowItem>();
             
            String response = "";
            for (String url : params) {
              DefaultHttpClient client = new DefaultHttpClient();
              HttpGet httpGet = new HttpGet(url);
              try {
                HttpResponse execute = client.execute(httpGet);
                InputStream content = execute.getEntity().getContent();

                BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
                String s = "";
                while ((s = buffer.readLine()) != null) {
                  response += s;
                }

                //JSONObject obj = new JSONObject(s);
                
              } catch (Exception e) {
                e.printStackTrace();
              }
            }
            return response;
        }
         
        private RowItem convertContact(JSONObject obj) throws JSONException {
            String name = "sagar";
            return new RowItem(name , R.drawable.ic_launcher);
        }
         
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    		View android = inflater.inflate(R.layout.my_task, container, false);
        	ListView yourListView = (ListView) android.findViewById(R.id.list);
        	
        	//menutitles = getResources().getStringArray(R.array.titles);
           // menuIcons = getResources().obtainTypedArray(R.array.icons);

            rowItems = new ArrayList<RowItem>();

           //  for (int i = 0; i < menutitles.length; i++) {
            //     RowItem items = new RowItem(menutitles[i], menuIcons.getResourceId(
             //            i, -1));

              //   rowItems.add(items);
            // }

             adapter = new CustomAdapter(getActivity(), rowItems);
             
             yourListView.setAdapter(adapter);
             (new AsyncListViewLoader()).execute("http://10.252.244.19:8020/users/rucha@jedix.com/tasks?taskType=ASSIGNED_TO_ME&completed=false");
        	 return android;	
    }

}
