package com.easyway2in.mysqldbdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
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
import java.util.ArrayList;

public class ManageAppliance extends AppCompatActivity {
    ArrayList<String> listItems=new ArrayList<>();
    Spinner sp;
    EditText ma;
    EditText ma1;
    EditText ma2;
    EditText ma3;
    String username;
    ArrayAdapter<String> adapter;
    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
    }

    public static String getUsername(Context context) {
        return getPrefs(context).getString("user_name", "");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manageappliance);
        sp=(Spinner)findViewById(R.id.spinner2);
        adapter = new ArrayAdapter<String>(this,R.layout.spinner_layout,R.id.txt,listItems);
        sp.setAdapter(adapter);
        sp.setSelection(-1);
        sp.setOnItemSelectedListener(new SpinnerItemSelectedListener());
        ma=(EditText)findViewById(R.id.editText);
        ma1=(EditText)findViewById(R.id.editText2);
        ma2=(EditText)findViewById(R.id.editText3);
        ma3=(EditText)findViewById(R.id.editText4);
        Log.d("SPManageAppliance", getUsername(this));
        username=getUsername(this);
    }
    public void userReg(View view)
    {

        String temp1 = ma.getText().toString();
        String name=temp1.replaceAll(" ", "");
        String temp2 = ma1.getText().toString();
        String user_name=temp2.replaceAll(" ", "");
        String temp3 =ma2.getText().toString();
        String user_pass=temp3.replaceAll(" ", "");
        String temp4=ma3.getText().toString();
        String y=temp4.replaceAll(" ","");
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,name,user_name,user_pass,y);
        finish();

    }
    public void userUpdate(View view)
    {

        String name = ma.getText().toString().replaceAll(" ", "");
        String user_name = ma1.getText().toString().replaceAll(" ", "");
        String user_pass =ma2.getText().toString().replaceAll(" ", "");
        String y= ma3.getText().toString().replaceAll(" ","");
        Log.d("UpdateEditText",name);
        Log.d("UpdateEditText",user_name);
        Log.d("UpdateEditText",user_pass);
        Log.d("UpdateEditText",y);
        String method = "update";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,name,user_name,user_pass,y);
        finish();

    }
    public void userDelete(View view)
    {

        String name = ma.getText().toString().replaceAll(" ","");
        String user_name = ma1.getText().toString().replaceAll(" ","");
        String user_pass = ma2.getText().toString().replaceAll(" ","");
        String y=ma3.getText().toString().replaceAll(" ","");
        Log.d("DeleteEditText",name);
        Log.d("DeleteEditText",user_name);
        Log.d("DeleteEditText",user_pass);
        Log.d("DeleteEditText",y);
        String method = "delete";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,name);
        finish();

    }
    protected  void onStart(){
        super.onStart();;
        BackTask bt =new BackTask();
        bt.execute();
    }
    private class BackTask extends AsyncTask<Void,Void,Void>{
        ArrayList<String> list;
        protected void onPreExecute(){
            super.onPreExecute();
            list =new ArrayList<>();
        }
        protected Void doInBackground(Void...params){
            String getDetails_URL="http://10.0.0.9/spinner.php";
            try {
                URL url = new URL(getDetails_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            /*String data = URLEncoder.encode("login_name", "UTF-8")+"="+URLEncoder.encode(login_name,"UTF-8")+"&"+
                    URLEncoder.encode("login_pass","UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");
                    */
                String data = URLEncoder.encode("username", "UTF-8")+"="+ URLEncoder.encode(username,"UTF-8");
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
                //line = bufferedReader.readLine();
                // setLine(ctx,line);
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
                try{
                    JSONArray jsonArray =new JSONArray(response);
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject =jsonArray.getJSONObject(i);
                        list.add(jsonObject.getString("appliance"));
                    }
                }catch(JSONException e){
                    e.printStackTrace();
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                Log.d("response",response);
                return null;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null; }

        protected  void onPostExecute(Void result){
            listItems.addAll(list);
            adapter.notifyDataSetChanged();
        }

    }





    private class BackTask2 extends AsyncTask<String,Void,String>{
        ArrayList<String> list;
        protected void onPreExecute(){
            super.onPreExecute();
            list =new ArrayList<>();
        }
        protected String doInBackground(String...params){
            String login_name=params[0];
            String getDetails_URL="http://10.0.0.9/spinner2.php";
            try {
                URL url = new URL(getDetails_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("login_name", "UTF-8")+"="+URLEncoder.encode(login_name,"UTF-8");/*+"&"+
                    URLEncoder.encode("login_pass","UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");*/
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

                Log.d("bt2",response);
                //testing
                //line = bufferedReader.readLine();
                // setLine(ctx,line);
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

                   /* try{
                        JSONArray jsonArray =new JSONArray(response);

                            JSONObject jsonObject =jsonArray.getJSONObject(0);
                            list.add(jsonObject.getString("powerconsumption"));
                            list.add(jsonObject.getString("start"));
                            list.add(jsonObject.getString("end"));


                    }catch(JSONException e){
                        e.printStackTrace();
                    }*/
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                Log.d("response2", response);

                return response;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null; }

        protected  void onPostExecute(String result){

            String[] parts=result.split(",");
            for(int i=0;i<parts.length;i++){
                list.add(parts[i]);
            }
            Log.d("post",parts[0]);

          //  ma.setText(list.get(0).toString());
            ma1.setText(list.get(0).toString());
            ma2.setText(list.get(1).toString());
            ma3.setText(list.get(2).toString());

        }

    }
    private class SpinnerItemSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int position, long id) {
            Log.d("position",Integer.toString(position));
            String text = sp.getSelectedItem().toString();
            Log.d("Text", text);
            BackTask2 x=new BackTask2();
            x.execute(text);
            ma.setText(text);
               /* listPro1 =dataHelper.getStartEnd(text);
                {  Toast.makeText(parent.getContext(), "Item selected is " + listPro1.get(0).getAppliance(), Toast.LENGTH_SHORT).show();


                }*/
            //  vs1.setText(listPro1.get(0).getStart());
            //vs2.setText(listPro1.get(0).getEnd());
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            Toast.makeText(parent.getContext(), "No Item selected", Toast.LENGTH_SHORT).show();
        }
    }

}
