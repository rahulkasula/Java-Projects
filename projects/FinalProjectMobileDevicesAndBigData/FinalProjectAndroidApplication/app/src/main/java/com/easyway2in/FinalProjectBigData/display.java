package com.easyway2in.mysqldbdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul on 10/21/2015.
 */
public class display extends AsyncTask<String,Void,String> {
Context ctx;
public  display(Context context){
    this.ctx=context;
}

   // private static SharedPreferences getPrefs(Context context) {
     //   return context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
    //}

//    public static String getTrackingNumber(Context context) {
  //      return getPrefs(context).getString("trackingNumber", "");
    //}

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }




    @Override
    protected String doInBackground(String... strings) {
        String tracking = "http://192.168.1.11/display.php";
//String name1;
//String name2;


        try {
          String  name1 =strings[1];
            URL url = new URL(tracking);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String data = URLEncoder.encode("track", "UTF-8")+"="+URLEncoder.encode(name1,"UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String response = "";
            String line  = "";

/*                while ((line = bufferedReader.readLine())!=null)
                {
                    response+= line;

                }*/
            //testing
            line = bufferedReader.readLine();

            System.out.print("line" + line);
            Log.d("line", line);
StringBuilder sb = new StringBuilder();
            if(line != null)
            {
                sb.append(line  );
            }
            response = sb.toString();
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            Log.d("response",response);
            return response;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
    protected void onPostExecute(String s) {

        if(s!=""&&s!=null)try{
            JSONArray jArray = new JSONArray(s);
            JSONObject json_data=null;

                json_data = jArray.getJSONObject(0);
            Log.d("Array", json_data.getString("tracking"));
            SharedPreferences x=ctx.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor =x.edit();
            editor.putString("tracking number", json_data.getString("tracking"));
            editor.apply();

            if(json_data.getString("node1")!=null){


                editor.putString("location1",json_data.getString("node1"));
                editor.apply();
            }
            if(json_data.getString("node2")!=null){



                editor.putString("location2", json_data.getString("node2"));
                editor.apply();
Log.d("Location2", json_data.getString("node2"));
            }
            if(json_data.getString("node3")!=null){

                editor.putString("location3", json_data.getString("node3"));
                editor.apply();
            }
            if(json_data.getString("node4")!=null){

                editor.putString("location4",json_data.getString("node4"));
                editor.apply();
            }
            if(json_data.getString("node5")!=null){

                editor.putString("location5",json_data.getString("node5"));
                editor.apply();
            }
            if(json_data.getString("node6")!=null){

                editor.putString("location6",json_data.getString("node6"));
                editor.apply();
            }
            if(json_data.getString("node7")!=null){

                editor.putString("location7",json_data.getString("node7"));
                editor.apply();
            }
            if(json_data.getString("node8")!=null){

                editor.putString("location8",json_data.getString("node8"));
                editor.apply();
            }
            if(json_data.getString("node9")!=null){

                editor.putString("location9",json_data.getString("node5"));
                editor.apply();
            }
            if(json_data.getString("node10")!=null){

                editor.putString("location10",json_data.getString("node10"));
                editor.apply();
            }
            if(json_data.getString("node11")!=null){

                editor.putString("location11",json_data.getString("node11"));
                editor.apply();
            }
            } catch (JSONException e) {
            Toast.makeText(ctx, "enter valid tracking details", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

//        Log.d("s", s);

        if(s!= null && !s.isEmpty()){
            Intent myIntent = new Intent(ctx, displayPage.class);
            ctx.startActivity(myIntent);
            Toast.makeText(ctx, "package details", Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(ctx, "Please enter tracking Number", Toast.LENGTH_LONG).show();
        }
    }




}


