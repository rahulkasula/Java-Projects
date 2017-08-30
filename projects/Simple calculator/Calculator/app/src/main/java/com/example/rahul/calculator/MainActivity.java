package com.example.rahul.calculator;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    Button button;
    Button button1;
    Button button3;
    Button buttonPlus;
    Button buttonEqual;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero;
    Button dot;
    Button mul;
    Button div;
    Button minus;
    Button ac;
    Button backSpace;
    TextView display;
static int equalOpr;
    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    boolean clicked;
    public int getItsEqual() {
        return itsEqual;
    }

    public void setItsEqual(int itsEqual) {
        this.itsEqual = itsEqual;
    }

    // String sIn;
    int itsEqual;

    public boolean isClickDiv() {
        return clickDiv;
    }

    public void setClickDiv(boolean clickDiv) {
        this.clickDiv = clickDiv;
    }

    boolean clickDiv;
    static String[] operators = new String[20];
    static StringBuilder sbStr = new StringBuilder();
    static String[] numbers = new String[100];
    static double result;
    static double result1;
 static int count;
    DecimalFormat value = new DecimalFormat("#0.00");
    public static int getReplace() {
        return replace;
    }

    public static void setReplace(int replace) {
        MainActivity.replace = replace;
    }

    static int replace;
    public static int getCount1() {
        return count1;
    }

    public static void setCount1(int count1) {
        MainActivity.count1 = count1;
    }

    static int count1;

    public static int getAd() {
        return ad;
    }

    public static void setAd(int ad) {
        MainActivity.ad = ad;
    }

    public static boolean isClickedBoolean() {
        return clickedOpr;
    }

    public static void setClickedOpr(boolean clickedBoolean) {
        MainActivity.clickedOpr = clickedBoolean;
    }

    static boolean clickedOpr;
    static int ad;

    public static int getS() {
        return s;
    }

    public static void setS(int s) {
        MainActivity.s = s;
    }

    static int s;

    public static int getM() {
        return m;
    }

    public static void setM(int m) {
        MainActivity.m = m;
    }

    static int m;

    public static int getD() {
        return d;
    }

    public static void setD(int d) {
        MainActivity.d = d;
    }

    static int d;


    public static boolean isRepitition() {
        return repitition;
    }

    public static void setRepitition(boolean repitition) {
        MainActivity.repitition = repitition;
    }

    static boolean repitition=false;
    String[] a;
    StringBuilder builder = new StringBuilder();
    char[] charOpStr;

    public boolean isEqualDot() {
        return equalDot;
    }

    public void setEqualDot(boolean equalDot) {
        this.equalDot = equalDot;
    }

    boolean equalDot;
    public boolean isClickedDot() {
        return clickedDot;
    }

    public void setClickedDot(boolean clickedDot) {
        this.clickedDot = clickedDot;
    }

    boolean clickedDot;
    // private static  StringBuilder sbStack = new StringBuilder(""), sbOut = new StringBuilder("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


Log.d("testing","");
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.two);
        button1 = (Button) findViewById(R.id.one);
        button3 = (Button) findViewById(R.id.three);
        buttonPlus = (Button) findViewById(R.id.plus);
        buttonEqual = (Button) findViewById(R.id.button);
        display = (TextView) findViewById(R.id.textView);
        four=(Button)findViewById(R.id.four);
        five=(Button)findViewById(R.id.five);
        six=(Button)findViewById(R.id.six);
        seven=(Button)findViewById(R.id.seven);
        eight=(Button)findViewById(R.id.eight);
        nine=(Button)findViewById(R.id.nine);
        zero=(Button)findViewById(R.id.zero);
        dot=(Button)findViewById(R.id.dot);
        minus=(Button)findViewById(R.id.minus);
        div=(Button)findViewById(R.id.div);
        mul=(Button)findViewById(R.id.mul);
        ac=(Button)findViewById(R.id.ac);



   Log.d("lifeCycle","MainActivity:onCreate()");


        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              builder.delete(0,builder.length());
                builder.append("0");
                display.setText(builder.toString());
               setCount1(0);
                setRepitition(false);
                 setItsEqual(0);
                setClickedDot(false);
                setClicked(false);
                setClickDiv(false);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.append("2");
                setRepitition(true);
                Log.d("builder", builder.toString());
                //String dummy = builder.toString();
                display.setText(builder.toString());
                if(isClicked()==true){
                    setClicked(false);
                    builder.delete(0,builder.length());
                    builder.append("2");
                    display.setText(builder.toString());

                } setClickDiv(false);}
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("1");
                setRepitition(true);
                Log.d("builder", builder.toString());
                display.setText(builder.toString());

           if(isClicked()==true){
               setClicked(false);
          builder.delete(0,builder.length());
               builder.append("1");
               display.setText(builder.toString());

           }
                setClickDiv(false);    }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("3");
                setRepitition(true);
                Log.d("builder", builder.toString());
                display.setText(builder.toString());
                if(isClicked()==true){
                    setClicked(false);
                    builder.delete(0,builder.length());
                    builder.append("3");
                    display.setText(builder.toString());

                }setClickDiv(false);}
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("4");
                setRepitition(true);
                Log.d("builder", builder.toString());
                display.setText(builder.toString());
                if(isClicked()==true){
                    setClicked(false);
                    builder.delete(0,builder.length());
                    builder.append("4");
                    display.setText(builder.toString());

                }setClickDiv(false);}
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("5");
                setRepitition(true);
                Log.d("builder", builder.toString());
                display.setText(builder.toString());
                if (isClicked() == true) {
                    setClicked(false);
                    builder.delete(0, builder.length());
                    builder.append("5");
                    display.setText(builder.toString());

                }
                setClickDiv(false);    }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("6");
                setRepitition(true);
                Log.d("builder", builder.toString());
                display.setText(builder.toString());
                if(isClicked()==true){
                    setClicked(false);
                    builder.delete(0,builder.length());
                    builder.append("6");
                    display.setText(builder.toString());

                }setClickDiv(false);}
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("7");
                setRepitition(true);
                Log.d("builder", builder.toString());
                display.setText(builder.toString());
                if(isClicked()==true){
                    setClicked(false);
                    builder.delete(0,builder.length());
                    builder.append("7");
                    display.setText(builder.toString());

                }setClickDiv(false);}
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("8");
                setRepitition(true);
                Log.d("builder", builder.toString());
                display.setText(builder.toString());
                if(isClicked()==true){
                    setClicked(false);
                    builder.delete(0,builder.length());
                    builder.append("8");
                    display.setText(builder.toString());

                }setClickDiv(false);}
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.append("9");
                setRepitition(true);
                Log.d("builder", builder.toString());
                display.setText(builder.toString());
                if(isClicked()==true){
                    setClicked(false);
                    builder.delete(0,builder.length());
                    builder.append("9");
                    display.setText(builder.toString());

                }setClickDiv(false);}
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              // if(builder.length()==0) {
                //   builder.append("0");
                  // setRepitition(true);
                   //display.setText(builder.toString());
                   //Log.d("zero length zero", builder.toString());
               //}
                if(isClickDiv()==false||builder.charAt(builder.length() - 1)!='/') {
                     {
                        builder.append("0");
                        setRepitition(true);
                        Log.d("zero", builder.toString());
                        display.setText(builder.toString());
                    }
                }
                if(isClicked()==true){
                    setClicked(false);
                    builder.delete(0, builder.length());
                    builder.append("0");
                    display.setText(builder.toString());
                    setClickedDot(false);
                    Log.d("zero is clicked", builder.toString());

                }                                    }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {if(isClickedDot()==false){
                builder.append(".");
                setRepitition(false);
                Log.d("builder", builder.toString());
                display.setText(builder.toString());
                setClickedDot(true);
            }
                setClickDiv(false);    }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count1!=0&& repitition==true)          {
                    setS(1);
                    setRepitition(false);
                    new calculation().execute(builder);
                    setD(0);
                    setAd(0);
                    setM(0);


                }
else                if(repitition==true) {

                    builder.append("-");
                    setRepitition(false);
                    Log.d("builder", builder.toString());
                    display.setText(builder.toString());
                    count1++;
                }

                else if(builder.length()==1&&repitition==false){
                    builder.delete(0,builder.length());
                    builder.append("-");
                }

               // if(resultTest!=0)    new calculation().execute(builder)
               if(builder.charAt(builder.length()-1)=='+'||builder.charAt(builder.length()-1)=='*'||builder.charAt(builder.length()-1)=='/'||builder.charAt(builder.length()-1)=='-'){
    builder.delete(builder.length()-1,builder.length());
                   builder.append("-");
                   display.setText(builder);
}

                setClicked(false);
                setClickedDot(false);setClickDiv(false);}
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count1!=0&& repitition==true) {
                    setM(1);
                    setRepitition(false);
                    new calculation().execute(builder);
                    setD(0);
                    setAd(0);
                    setS(0);


                }
               if(repitition ==true) {
                builder.append("*");
                Log.d("builder", builder.toString());
                display.setText(builder.toString());
                    setRepitition(false);
                    count1++;

                }
if(builder.length()==0&&repitition==false){
                    builder.append("");
                }

                if(builder.charAt(builder.length()-1)=='+'||builder.charAt(builder.length()-1)=='*'||builder.charAt(builder.length()-1)=='/'||builder.charAt(builder.length()-1)=='-'&&builder.length()!=1){
                    builder.delete(builder.length()-1,builder.length());
                    builder.append("*");
                    display.setText(builder);
                }
                setClicked(false);
                setClickedDot(false);
                setClickDiv(false);}

        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(count1!=0&& repitition==true) {

                    setD(1);
                    setRepitition(false);
                    new calculation().execute(builder);
                    setAd(0);
                    setM(0);
                    setS(0);

                    setClickDiv(true);
                }
               if(repitition==true) {    builder.append("/");
                   Log.d("builder", builder.toString());
                   display.setText(builder.toString());
                   setRepitition(false);
                    count1++;

              setClickDiv(true);  }

                 if(builder.length()==0&&repitition==false){
                    builder.append("");
                }

  //              if(resultTest!=0)    new calculation().execute(builder);
                if(builder.charAt(builder.length()-1)=='+'||builder.charAt(builder.length()-1)=='*'||builder.charAt(builder.length()-1)=='/'||builder.charAt(builder.length()-1)=='-'&&builder.length()!=1){
                    builder.delete(builder.length()-1,builder.length());
                    builder.append("/");
                    display.setText(builder);
                    setClickDiv(true);
                }

                setClicked(false);
                setClickedDot(false);
              }

        });


        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(count1!= 0 && repitition==true  ) {
                    setAd(1);
    setRepitition(false);
    new calculation().execute(builder);
                    setD(0);
                    setM(0);
                    setS(0);


}
              else  if(repitition==true) {
                    builder.append("+");
                    Log.d("builder", builder.toString());
                    display.setText(builder.toString());
                    setRepitition(false);

                    count1++;

                }

               else if(builder.charAt(builder.length()-1)=='+'||builder.charAt(builder.length()-1)=='*'||builder.charAt(builder.length()-1)=='/'||builder.charAt(builder.length()-1)=='-'&&builder.length()!=1){
                    builder.delete(builder.length()-1,builder.length());
                    builder.append("+");
                    display.setText(builder);
                }
setClicked(false);

                setClickedDot(false);
                setClickDiv(false);}
                                                                      }

        );

        Log.d("", builder.toString());


        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0;i<builder.length();i++){
                    if(builder.charAt(i)=='+'){
                        equalOpr++;
                    }
                    if(builder.charAt(i)=='*'){
                        equalOpr++;
                    }
                    if(builder.charAt(i)=='-'){
                        equalOpr++;
                    }
                    if(builder.charAt(i)=='/'){
                        equalOpr++;
                    }
                }
                if(equalOpr==0){
                    display.setText(builder);
                    setClicked(false);
                    setItsEqual(1);
                }

                if(builder.charAt(builder.length()-1)!='+'&&builder.charAt(builder.length() - 1)!='-'&&builder.charAt(builder.length()-1)!='*'&&builder.charAt(builder.length()-1)!='/'&&equalOpr!= 0)
                    try {
Log.d("equal","");
                        setCount1(0);
                        new calculation().execute(builder);
                    setItsEqual(1);
                    setClicked(true);
                        equalOpr=0;
} catch (Exception e) {
                    Log.d("", "testing");
                    e.printStackTrace();
                }

                if(itsEqual==1){
                    setRepitition(true);
                }else {
                    setRepitition(false);
                }
                setClickDiv(false);
                //setClicked();
            }
        });

    }


    protected void onStart() {
        super.onStart();
        Log.d("lifeCycle", "MainActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifeCycle", "MainActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifeCycle", "MainActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifeCycle", "MainActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifeCycle", "MainActivity: onDestroy()");
    }









    class calculation extends AsyncTask<StringBuilder, Void, Double> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();


        }

        @Override
        protected void onPostExecute(Double aDouble) {
            super.onPostExecute(aDouble);
            display.setText(String.valueOf(value.format(result)));
            sbStr.delete(0,sbStr.length());
            count=0;
            builder.delete(0, builder.length());
            builder.append(result);
            if( ad!=0)     {    builder.append("+"); }
            if( s!=0)     {    builder.append("-");
            }
            if( m!=0)     {
                builder.append("*");
            }
            if( d!=0)     {    builder.append("/"); }
           // setCount1(0);

            setAd(0);
            setS(0);
            setM(0);
            setD(0);
            replace++;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected Double doInBackground(StringBuilder... params) {


            for (int i = 0, j = 0; i < builder.toString().length(); i++) {
                if (i == 0) {
                    sbStr.append("[");
                    sbStr.append("\\");
                }
                if (builder.toString().charAt(i) == '+') {
                    sbStr.append("+");
                    j++;
                } else if (builder.toString().charAt(i) == '-') {
                    sbStr.append("-");
                    j++;
                } else if (builder.toString().charAt(i) == '*') {
                    sbStr.append("*");
                    j++;
                } else if (builder.toString().charAt(i) == '/') {
                    sbStr.append("/");
                    j++;
                }
            }





            for (int i4 = 0; i4 < operators.length; i4++) {
                if (operators[i4] != null) {
                    count++;

                }}
                    sbStr.append( "]");




            java.lang.String operatorsString = sbStr.toString();
            char[] t = operatorsString.toCharArray();
            String opStr = new String(t);
            Log.d("testing", opStr);

            String[] parts = builder.toString().split(operatorsString);
            for (int i3 = 0; i3 < parts.length; i3++) {

                Log.d("parts", parts[i3]);

            }

            charOpStr = opStr.toCharArray();

            for (int i5 = 2; i5 < charOpStr.length; i5++) {
                {
                    if (i5 == 2) {
                        Log.d("Inside for loop 2", String.valueOf(charOpStr[i5]));
                        Log.d("characters", String.valueOf(charOpStr[i5]));
                      calculate(i5, parts[i5 - 2], parts[i5 - 1], charOpStr[i5]);
                    }
                    if (i5 <= (charOpStr.length - 2) && i5 != 2) {


                        calculate(i5, parts[i5 - 2], parts[i5 - 1], charOpStr[i5]);



                        Log.d("Inside for loop not 2", String.valueOf(charOpStr[i5]));
                        Log.d("characters", String.valueOf(charOpStr[i5]));
                    }

                }
            }


            return null;


        }

        public void setResult(double result12) {
            try {
                result = result12;
            } catch (Exception e) {
                // TODO: handle exception
            }

        }


        private double calculate(int i, String x, String y, char c) {
            // TODO Auto-generated method stub
            switch (c) {
                case '-':
                    if (i == 2) {
                        Log.d("first Result", "test");
                        if(x.isEmpty()){
                            double temp = Float.parseFloat("0") - Float.parseFloat(y);
                            setResult(temp);
                        }
                        if(y.isEmpty()){
                            double temp = Float.parseFloat(x) ;
                            setResult(temp);
                        }
                        if (x.isEmpty()!=true&&y.isEmpty()!=true){ double temp = Float.parseFloat(x) - Float.parseFloat(y);
                            setResult(temp);
                        }
                    } else {
                        Log.d("result switch sub", String.valueOf(result));
                        result1 = result - Float.parseFloat(y);
                        setResult(result1);
                        Log.d("test important\\t", String.valueOf(result));

                    }
                    break;
                case '+':
                    if (i == 2) {
                        if(x.isEmpty()){
                            double temp = Float.parseFloat("0") + Float.parseFloat(y);
                            setResult(temp);
                        }

                        if(y.isEmpty()){
                            double  temp = 2*Float.parseFloat(x) ;
                            setResult(temp);
                        }else {double temp = Float.parseFloat(x) + Float.parseFloat(y);
                        result = temp;}


                    }else {
                        result1 = result + Float.parseFloat(y);
                        setResult(result1);
                        Log.d("test important\\t", String.valueOf(result));

                    }
                    break;
                case '*':
                    if (i == 2) {
                        //System.out.println("first result");
                        if (x.isEmpty()) {
                            double temp = Float.parseFloat("0") * Float.parseFloat(y);
                            setResult(temp);
                        }
                        if(y.isEmpty()){
                            double temp = Math.pow(Float.parseFloat(x),2);
                            setResult(temp);
                        }else{
                            double temp = Float.parseFloat(x) * Float.parseFloat(y);
                        setResult(temp);
                    }

                    } else {
                        ///System.out.println("result switch mul"+result);
                        result1 = result * Float.parseFloat(y);
                        setResult(result1);
                        Log.d("test important\\t", String.valueOf(result));

                    }
                    break;

                case '/':
                    if (i == 2) {
                        System.out.println("first result");
                        if (x.isEmpty()) {
                            double temp = Float.parseFloat("0");
                            setResult(temp);
                        }
                        if(y.isEmpty()){
                            double temp = Float.parseFloat(x) / Float.parseFloat(x);
                            setResult(temp);
                        }else{
                        double temp = Float.parseFloat(x) / Float.parseFloat(y);
                        result = temp;}

                    } else {
                        // System.out.println("result switch div"+result);

                        result1 = result / Float.parseFloat(y);
                        setResult(result1);
                        Log.d("test important\\t", String.valueOf(result));

                    }
                    break;
            }

             return result;


        }
    }
}















