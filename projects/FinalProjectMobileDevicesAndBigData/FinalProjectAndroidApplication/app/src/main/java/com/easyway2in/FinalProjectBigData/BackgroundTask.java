package com.easyway2in.mysqldbdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class BackgroundTask extends AsyncTask<String,Void,String> {
  AlertDialog alertDialog;
    Context ctx;
String username;
String imp,imp2;
int count=0;
StringBuilder sb=new StringBuilder("");

    public String getImp() {
        return imp;
    }

    public void setImp(String imp) {
        this.imp = imp;
    }

    public String getImp2() {
        return imp2;
    }

    public void setImp2(String imp2) {
        this.imp2 = imp2;
    }

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
    }

    public static String getUsername(Context context) {
        return getPrefs(context).getString("user_name", "");
    }
    public static String getTrackingNumber(Context context) {
        return getPrefs(context).getString("trackingNumber", "");
    }
/*public static void setUsername(Context context,String f){
    SharedPreferences.Editor editor = getPrefs(context).edit();
     editor.putString("tracking", f);
    editor.apply();
}*/
    public static void setLine(Context context,String f){
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("line", f);
        editor.apply();
    }
    BackgroundTask(Context ctx)
    {
      this.ctx =ctx;
    }
    @Override
    protected void onPreExecute() {
    alertDialog = new AlertDialog.Builder(ctx).create();
       // alertDialog.setTitle("Login successful....");
       ;
        Log.d("SPBackground", getUsername(ctx));

    }





    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://10.0.0.9/register.php";
        String login_url = "http://10.0.0.9/userlogin.php";
        String update ="http://10.0.0.9/update2.php";
        String delete ="http://10.0.0.9/delete.php";
        String method = params[0];
        String[] x=params;
        username=getUsername(ctx);
        for(int i=0;i<x.length;i++){
            Log.d("parts",x[i]);
        }
        if (method.equals("register")) {
            String name = params[1];
            String user_name = params[2];
            String user_pass = params[3];
            String end=params[4];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                //httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("appliance", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("powerconsumption", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" +
                        URLEncoder.encode("start", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8")+"&" +
                        URLEncoder.encode("end", "UTF-8") + "=" + URLEncoder.encode(end, "UTF-8")+"&" +
                        URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");
                Log.d("AddData",data);
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
               InputStream IS = httpURLConnection.getInputStream();
               IS.close();
                //httpURLConnection.connect();
                httpURLConnection.disconnect();
             return "Registration Success...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (method.equals("update")) {
            String name = params[1];
            String user_name = params[2];
            String user_pass = params[3];
            String endtime=params[4];
            try {
                URL url = new URL(update);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                Log.d("update", name);
                Log.d("update",user_name);
                Log.d("update",user_pass);
                Log.d("update",endtime);
                //httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("appliance", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("powerconsumption", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" +
                        URLEncoder.encode("start", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8")+"&" +
                        URLEncoder.encode("end", "UTF-8") + "=" + URLEncoder.encode(endtime, "UTF-8");
               // String data="appliance="+name+"&powerconsumption="+user_name+"&end="+endtime+"&start="+user_pass;
                Log.d("data",data);
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS,"iso-8859-1"));
                String response = "";
                String line="";

                while ((line = bufferedReader.readLine())!=null)
                {
                    response+= line;

                }
                Log.d("updateResponse",response);
                IS.close();
                Log.d("update","");
                //httpURLConnection.connect();
                httpURLConnection.disconnect();
                return "update...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if (method.equals("delete")) {

            String name = params[1];

            try {
                URL url = new URL(delete);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                Log.d("delete", name);

                //httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("appliance", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
                // String data="appliance="+name+"&powerconsumption="+user_name+"&end="+endtime+"&start="+user_pass;
                Log.d("Deletedata",data);
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS,"iso-8859-1"));
                String response = "";
                String line="";

                while ((line = bufferedReader.readLine())!=null)
                {
                    response+= line;

                }
                Log.d("deleteResponse",response);
                IS.close();
                Log.d("delete","");
                //httpURLConnection.connect();
                httpURLConnection.disconnect();
                return "delete...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        else if(method.equals("login"))
        {
           String login_name = params[1];
            String login_pass = params[2];
            Log.d("loginname",login_name);
            Log.d("loginPass",login_pass);

            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String data = URLEncoder.encode("login_name","UTF-8")+"="+URLEncoder.encode(login_name,"UTF-8")+"&"+
                    URLEncoder.encode("login_pass","UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line="";

                while ((line = bufferedReader.readLine())!=null)
                {
                    response+= line;

                }
                //testing
                Log.d("add",response);
                line = bufferedReader.readLine();
                setLine(ctx,line);
//                Log.d("line",line);
//                String[] parts = line.split(",");
  //              response=parts[0];
    //            System.out.print("part" + parts[0]);
  //              Log.d("part", parts[0]);
//                Log.d("part", parts[1]);
//                System.out.print("part" + parts[1]);
      ////          for(int i=1;i<parts.length;){
            //        sb.append(parts[i]);
          //          sb.append(",");
              //      i=i+2;
                //}
                //setUsername(ctx, sb.toString());
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


        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {

       Log.d("successful",result);
      if(result.equals("Registration Success..."))
      {
          Toast.makeText(ctx, "Appliance added to the schedule", Toast.LENGTH_LONG).show();
      }
        if(result.equals("delete..."))
        {
            Toast.makeText(ctx, "Appliance schedule deleted", Toast.LENGTH_LONG).show();
        }
        if(result.equals("update..."))
        {
            Toast.makeText(ctx, "Appliance schedule updated", Toast.LENGTH_LONG).show();
        }
        else
        {
            alertDialog.setMessage(result);
            alertDialog.show();
        }
        //if(result.equals("welcome"))
       /*if (result.equals(getUsername(ctx))){
        //if(getImp()==getUsername(ctx)){
           Intent myIntent = new Intent(ctx, tracking.class);
           ctx.startActivity(myIntent);
            Toast.makeText(ctx, "Login Successful", Toast.LENGTH_LONG).show();
        }*/
        if(result.equals(null)||result.equals("")){
            Toast.makeText(ctx, "Failed", Toast.LENGTH_LONG).show();
        }
        if (result.equals("login")){
            Log.d("success","");
            //if(getImp()==getUsername(ctx)){

            Intent myIntent = new Intent(ctx, Details.class);
            ctx.startActivity(myIntent);
            Toast.makeText(ctx, "login Successful", Toast.LENGTH_LONG).show();
        }
        else
        {
            //alertDialog.setMessage(result);
            //alertDialog.show();

            Toast.makeText(ctx, "Invalid Login Details", Toast.LENGTH_LONG).show();

        }
    }
}
