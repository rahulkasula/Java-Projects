package com.easyway2in.mysqldbdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    Button b;
    Button b1;
    Button b2;
    Button b3;
    Context ctx;
TextView name;


    public void Details(Context ctx){
    this.ctx=ctx;
}
    private static SharedPreferences getPrefs(Context context) {
          return context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        }

   public static String getUsername(Context context) {
       return getPrefs(context).getString("user_name", "");
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

            Log.d("SPDetails", getUsername(this));
name=(TextView)findViewById(R.id.textView);
        name.setText("hello"+"   "+getUsername(this));

    }

    public void ViewAppliance(View view)
    {


        startActivity(new Intent(Details.this, ViewAppliance.class));
    }
    public void ManageSchedule(View view)
    {


        startActivity(new Intent(Details.this, ManageSchedule.class));
    }


    public void ManageAppliance(View view)
    {

        startActivity(new Intent(Details.this, ManageAppliance.class));
    }

    public void ViewSchedule(View view)
    {

        startActivity(new Intent(Details.this, ViewSchedule.class));
    }
}
