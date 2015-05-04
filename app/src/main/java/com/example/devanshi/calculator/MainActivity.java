package com.example.devanshi.calculator;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import bsh.EvalError;
import bsh.Interpreter;


public class MainActivity extends ActionBarActivity{
    private Button one,two ,three,four,five,six,seven,eight,nine,zero,dot,add,minus,division,multiply,button,eq;
    private Button nxt;
    String number="";
    String Result;
    String finalResult;
    //private TextView print;
    private EditText print;
    private String power;
    private Double doubleResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        print = (EditText) findViewById(R.id.editText);

        one=(Button) findViewById(R.id.one);
        two=(Button) findViewById(R.id.two);
        three=(Button) findViewById(R.id.three);
        four=(Button) findViewById(R.id.four);
        five=(Button) findViewById(R.id.five);
        six=(Button) findViewById(R.id.six);
        seven=(Button) findViewById(R.id.seven);
        eight=(Button) findViewById(R.id.eight);
        nine=(Button) findViewById(R.id.nine);
        zero=(Button) findViewById(R.id.zero);
        add=(Button) findViewById(R.id.add);
        dot=(Button) findViewById(R.id.dot);
        minus=(Button) findViewById(R.id.minus);
        division=(Button) findViewById(R.id.division);
        multiply=(Button) findViewById(R.id.multiply);
        button=(Button) findViewById(R.id.button);
        eq=(Button)findViewById(R.id.eq);



        Intent intent = getIntent();
        power = intent.getStringExtra("Power");
        print.setText(power);

        one.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                number+="1";
                print.setText(number);
            }
        });

        two.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                number+="2";
                print.setText(number);

            }
        });

        three.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                number+="3";
                print.setText(number);
            }
        });

        four.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                number+="4";
                print.setText(number);
            }
        });

        five.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                number+="5";
                print.setText(number);
            }
        });

        six.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                number+="6";
                print.setText(number);
            }
        });

        seven.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                number+="7";
                print.setText(number);

            }
        });

        eight.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                number+="8";
                print.setText(number);

            }
        });

        nine.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                number+="9";
                print.setText(number);
            }
        });

        zero.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                number+="0";
                print.setText(number);

            }
        });

        dot.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                dot.setEnabled(false);
                number+=".";
                print.setText(number);

            }
        });

        add.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                minus.setEnabled(false);
                division.setEnabled(false);
                multiply.setEnabled(false);
                dot.setEnabled(true);
                number+="+";
                print.setText(number);


            }
        });

        button.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                minus.setEnabled(true);
                division.setEnabled(true);
                multiply.setEnabled(true);
                dot.setEnabled(true);
                add.setEnabled(true);
                number="";
                print.setText(number);
            }
        });

        eq.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v){


                minus.setEnabled(true);
                division.setEnabled(true);
                multiply.setEnabled(true);
                dot.setEnabled(true);
                add.setEnabled(true);

                if (print.getText().toString().contains("/")) {

                    String[] divide = print.getText().toString().split("/");
                    Double val1 = Double.parseDouble(divide[0]);
                    Double val2 = Double.parseDouble(divide[1]);
                    Double val = val1/val2;
                    print.setText(val.toString());
                }

                else if(print.getText().toString().contains("^"))
                {
                    String [] power = print.getText().toString().split("^");
                    Double val1 = Double.parseDouble(power[0]);
                    Double val2 = Double.parseDouble(power[1]);
                    Double val = Math.pow(val1,val2);
                    print.setText(val.toString());
                }
                else {

                    try {
                        Interpreter interpre = new Interpreter();
                        String result = interpre.eval(number).toString();
                        number = result;
                        print.setText(result);

                    } catch (EvalError evalError) {
                        evalError.printStackTrace();
                    }
                }
            }
        });


        division.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                minus.setEnabled(false);
                add.setEnabled(false);
                multiply.setEnabled(false);
                dot.setEnabled(true);
                number+="/";
                print.setText(number);

            }
        });

        minus.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                add.setEnabled(false);
                division.setEnabled(false);
                multiply.setEnabled(false);
                dot.setEnabled(false);
                number+="-";
                print.setText(number);

            }
        });

        multiply.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {


                minus.setEnabled(false);
                add.setEnabled(false);
                division.setEnabled(false);
                dot.setEnabled(true);
                number+="*";
                print.setText(number);

            }
        });



        nxt= (Button) findViewById(R.id.nxt);
        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Second_view.class);
                intent.putExtra("Result",print.getText().toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);



//                switch (v.getId()) {
//                    case R.id.one:
//                        print.setText("1");
//                        break;
//                    case R.id.two:
//                        print.setText("2");
//                        // do something else
//                        break;
//
//                }







            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
