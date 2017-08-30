package com.easyway2in.mysqldbdemo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class displayPage extends Activity {
    ListView listView ;
    Context ctx;

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
    }

    public static String getTracking(Context context) {
        return getPrefs(context).getString("tracking number", "");
    }
    public static String getLocation1(Context context) {
        return getPrefs(context).getString("location1", "");
    }
    public static String getLocation2(Context context) {
        return getPrefs(context).getString("location2", "");
    }
    public static String getLocation3(Context context) {
        return getPrefs(context).getString("location3", "")==null? "":getPrefs(context).getString("location3", "");
    }
    public static String getLocation4(Context context) {

        return getPrefs(context).getString("location4", "")==null? "":getPrefs(context).getString("location4", "");
    }
    public static String getLocation5(Context context) {
        return getPrefs(context).getString("location5", "");
    }
    public static String getLocation6(Context context) {
        return getPrefs(context).getString("location6", "");
    }
    public static String getLocation7(Context context) {
        return getPrefs(context).getString("location7", "");
    }
    public static String getLocation8(Context context) {
        return getPrefs(context).getString("location8", "");
    }
    public static String getLocation9(Context context) {
        return getPrefs(context).getString("location9", "");
    }
    public static String getLocation10(Context context) {
        return getPrefs(context).getString("location10", "");
    }
    public static String getLocation11(Context context) {
        return getPrefs(context).getString("location11", "");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_page);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] values = new String[]{getTracking(this), getLocation1(this), getLocation2(this), getLocation3(this),getLocation4(this),getLocation5(this),getLocation6(this),getLocation7(this),getLocation8(this),getLocation9(this),getLocation10(this),getLocation11(this)
        };
        Log.d("displaylocation2",getLocation2(this));
        getPrefs(this).edit().clear().commit();

        for(int i=0;i<values.length;i++){
            if(values[i]==null){
       values[i]="";
            }
        }
        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);



        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value


                // Show Alert

                    String itemValue = (String) listView.getItemAtPosition(position);
                Log.d("item",itemValue);
                    Toast.makeText(getApplicationContext(),
                             "  Location : " + itemValue, Toast.LENGTH_SHORT)
                            .show();

            }

        });
    }


}
