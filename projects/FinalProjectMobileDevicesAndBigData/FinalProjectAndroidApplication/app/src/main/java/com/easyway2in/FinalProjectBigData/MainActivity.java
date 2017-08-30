package com.easyway2in.mysqldbdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MainActivity extends Activity{
    EditText ET_NAME,ET_PASS;
    String login_name,login_pass;
Context ctx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET_NAME = (EditText)findViewById(R.id.user_name);
        ET_PASS = (EditText)findViewById(R.id.user_pass);

    }





public void userReg(View view)
{

    startActivity(new Intent(this,Register.class));
}

    public void userLogin(View view)
    {
        login_name = ET_NAME.getText().toString();
        login_pass = ET_PASS.getText().toString();
        String method = "login";

        SharedPreferences x=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =x.edit();
        editor.putString("user_name",ET_NAME.getText().toString());
        editor.putString("user_pass", ET_PASS.getText().toString());
        editor.apply();


        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,login_name,login_pass);
        //startActivity(new Intent(MainActivity.this, tracking.class));
    }

}
