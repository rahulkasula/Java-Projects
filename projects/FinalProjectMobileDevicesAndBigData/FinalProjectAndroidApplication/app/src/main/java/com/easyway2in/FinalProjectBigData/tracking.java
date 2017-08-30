package com.easyway2in.mysqldbdemo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;





    public class tracking extends Activity {
        EditText trackNumber;
        Button trackButton;
        String trackingNumber;
Context ctx;

        @Override
         protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tracking);
            trackNumber = (EditText) findViewById(R.id.trackingNumber);
            trackButton = (Button) findViewById(R.id.trackButton);
            display testing=new display(this);

        }
        public void   display(Context context){
            this.ctx=context.getApplicationContext();
        }


        public void userDetails(View view) {


            trackingNumber=trackNumber.getText().toString();
            SharedPreferences x=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor =x.edit();
            editor.putString("trackingNumber", trackingNumber);
            editor.apply();
            display testing=new display(this);
            String[] mTracking=trackingNumber.split(",");
if(mTracking.length==0&&mTracking[0]==""){
    Toast.makeText(ctx, "Please enter tracking details", Toast.LENGTH_LONG).show();
}
            if(mTracking.length==1) {
                testing.execute( "1",mTracking[0]);
            }


        }

    }



