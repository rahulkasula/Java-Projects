package com.easyway2in.mysqldbdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

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
import java.util.Random;

public class ViewSchedule extends AppCompatActivity {
    TextView vs1;
    Random rand;
    int temp;
    String x,y,z;
    ArrayAdapter<String> adapter2;
    ListView viewSchedule;

    LineGraphSeries<DataPoint>[] series2;
    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }

    Boolean on=true;
    int count;
    String username;
    GraphView graph;
    GraphView g1;
    TextView vs2;
    TextView vs3;
    GraphView[] gv;
    String[] parts;
    ArrayList<String> list;
    ArrayList<String> listItems2=new ArrayList<>();
    ArrayList<VSBeans> listPro1= new ArrayList<VSBeans>();
    ArrayList<String> listItems=new ArrayList<>();
    final DataHelper dataHelper =new DataHelper(this);
    Spinner sp;

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
        setContentView(R.layout.viewschedule);
      //  this.sp=(Spinner)findViewById(R.id.spinner3);
       // sp.setSelection(-1);

        adapter = new ArrayAdapter<String>(this,R.layout.spinner_layout,R.id.txt,listItems);
        //sp.setAdapter(adapter);
         this.graph = (GraphView) findViewById(R.id.graph);
        this.g1= (GraphView) findViewById(R.id.graph);


        //GraphView graph = (GraphView) findViewById(R.id.graph);


        viewSchedule=(ListView)findViewById(R.id.listView2);
        adapter2 =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,listItems);

//sp.setSelection(adapter.NO_SELECTION,false);
      //  sp.setOnItemSelectedListener(new SpinnerItemSelectedListener());
        Log.d("SPViewSchedule", getUsername(this));
        username=getUsername(this);
    }
    protected  void onStart(){
        super.onStart();;
        BackTask bt =new BackTask();
        bt.execute();
        BackTask2 x=new BackTask2();
        x.execute();
        BackTask3 y=new BackTask3();
        y.execute();
    }
    private class BackTask extends AsyncTask<Void,Void,Void> {
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
            bufferedWriter.write(data);*/
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
                Log.d("ViewScheduleresponse",response);
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
                Log.d("response", response);
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

    private class BackTask2 extends AsyncTask<Void,Void,ArrayList<VSBeans>> {


        protected void onPreExecute() {
            super.onPreExecute();
            list = new ArrayList<>();
        }

        protected ArrayList doInBackground(Void... params) {
            //  String login_name = params[0];
            String getDetails_URL = "http://10.0.0.9/CustomerGraph.php";
            try {
                URL url = new URL(getDetails_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("username", "UTF-8")+"="+ URLEncoder.encode(username,"UTF-8");
                bufferedWriter.write(data);
                /*URLEncoder.encode("login_name", "UTF-8") + "=" + URLEncoder.encode(login_name, "UTF-8");/*+"&"+
                    URLEncoder.encode("login_pass","UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");*/
               // bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
             Log.d("ViewScheduleData",data);
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    response += line;

                }

                Log.d("bt2ViewGraph", response);
                parts = response.split(",");


                try {
                    JSONArray arr=new JSONArray(response);


                    for (int i = 0; i < arr.length(); i++) {
                        VSBeans x = new VSBeans();
                        listPro1.add(x);
                        listPro1.get(i).setPowerconsumption(arr.getJSONObject(i).getString("powerconsumption"));
                        listPro1.get(i).setStart(arr.getJSONObject(i).getString("start"));
                        listPro1.get(i).setEnd(arr.getJSONObject(i).getString("end"));
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }




                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                Log.d("response", response);
                Log.d("lproSize", Integer.toString(listPro1.size()));
                return listPro1;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(ArrayList<VSBeans> result) {
            Log.d("PostListPro1Power", Integer.toString(result.size()));

          //  super.onPostExecute(result);


graph=(GraphView)findViewById(R.id.graph);

            gv=new GraphView[result.size()-1];
            for (int i=0;i<result.size()-1;i++){

                gv[i]=(GraphView)findViewById(R.id.graph);
            }
         DataPoint[][] y = new DataPoint[(result.size()-1)][2];


            DataPoint[] x= new DataPoint[2*(result.size()-1)];

            for(int i=0;i<result.size()-1;i++){
                Log.d("listpro1End",(result.get(i).getEnd()));}
            for(int i=0,j=0;i<(result.size()-1);i++){
                Log.d("InsideLoopTesting",result.get(i).getPowerconsumption());
               // DataPoint z=new  DataPoint(Integer.parseInt(result.get(i).getStart()),Integer.parseInt(result.get(i).getPowerconsumption()));
         y[i][0]=new  DataPoint(Integer.parseInt(result.get(i).getStart()),Integer.parseInt(result.get(i).getPowerconsumption()));
                y[i][1]=new  DataPoint(Integer.parseInt(result.get(i).getEnd()),Integer.parseInt(result.get(i).getPowerconsumption()));

            }





            for(int i=0;i<result.size()-1;i++){
Log.d("listpro1End",(result.get(i).getEnd()));}
            for(int i=0,j=0;i<(result.size()-1)&&j<2*((result.size()-1));i++){
                Log.d("InsideLoop",result.get(i).getPowerconsumption());
                x[j]=new  DataPoint(Integer.parseInt(result.get(i).getStart()),Integer.parseInt(result.get(i).getPowerconsumption()));
                x[j+1]=new DataPoint(Integer.parseInt(result.get(i).getEnd()),Integer.parseInt(result.get(i).getPowerconsumption()));
                j=j+2;
            }

            LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(x);


series2 =new LineGraphSeries[result.size()-1];
for (int i=0;i<result.size()-1;i++){
    gv[i].getViewport().setMinY(0);
    gv[i].getViewport().setMinX(0);
    gv[i].getViewport().setMaxX(24);

     series2[i] = new LineGraphSeries<DataPoint>(y[i]);
    rand = new Random();
    temp=rand.nextInt(10)+1;
    Log.d("Temp",String.valueOf(temp));

switch (temp){
    case 1 :    series2[i].setColor(Color.RED);
        break;
    case 2 :        series2[i].setColor(Color.BLACK);
        break;
    case 3 :     series2[i].setColor(Color.BLUE);
        break;
    case 4 :    series2[i].setColor(Color.GREEN);
        break;
    case 5:    series2[i].setColor(Color.CYAN);
        break;
    case 6:     series2[i].setColor(Color.GREEN);
        break;
    case 7:     series2[i].setColor(Color.YELLOW);
        break;
    case 8:     series2[i].setColor(Color.RED);
        break;
    case 9:    series2[i].setColor(Color.GREEN);
        break;
        case 10:     series2[i].setColor(Color.YELLOW);
            break;
}


    gv[i].addSeries(series2[i]);

}
            listPro1.clear();
        }


    }


        private class SpinnerItemSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int position, long id) {
            Log.d("position", Integer.toString(position));
            String text = sp.getSelectedItem().toString();
            Log.d("Text", text);



        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

            Toast.makeText(parent.getContext(), "No Item selected", Toast.LENGTH_SHORT).show();
        }
    }

    private class BackTask3 extends AsyncTask<Void,Void,Void> {
        ArrayList<String> list;
        protected void onPreExecute(){
            super.onPreExecute();
            list =new ArrayList<>();
        }
        protected Void doInBackground(Void...params){
            String getDetails_URL="http://10.0.0.9/Display2.php";
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
            bufferedWriter.write(data);*/
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
                Log.d("ViewScheduleresponse",response);
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
                list.add("Appliance"+"-----"+"Power Consumption"+"---------"+"Start Time"+"--------"+"End Time"+"");
                try {
                    JSONArray arr=new JSONArray(response);


                    for (int i = 0; i < arr.length(); i++) {
                        //VSBeans x = new VSBeans();
                        //list.add(x);
                        String temp=arr.getJSONObject(i).getString("appliance")+"-------------"+arr.getJSONObject(i).getString("powerconsumption")+"------------"+arr.getJSONObject(i).getString("start")+"-------------"+arr.getJSONObject(i).getString("end");
                        //list.get(i).setPowerconsumption(arr.getJSONObject(i).getString("powerconsumption"));
                        //list.get(i).setStart(arr.getJSONObject(i).getString("start"));
                        //list.get(i).setEnd(arr.getJSONObject(i).getString("end"));
                        //list.get(i).setApplianceName(arr.getJSONObject(i).getString("appliance"));
                        list.add(temp);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                Log.d("response", response);
                return null;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null; }

        protected  void onPostExecute(Void result){
            listItems.addAll(list);
            viewSchedule.setAdapter(adapter2);
            adapter2.notifyDataSetChanged();
        }

    }







}
