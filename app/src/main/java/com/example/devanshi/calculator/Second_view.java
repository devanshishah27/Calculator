package com.example.devanshi.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by DEVANSHI on 29-04-2015.
 */
public class Second_view  extends ActionBarActivity {

    private Button back,sin,cos,tan,ln,log,pi,percent,fact,sqrt,power,complex,exponential,openBraces,closedBraces,clear;
    String finalResult;
    private EditText editText2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_view);

        clear=(Button) findViewById(R.id.button);
        editText2 = (EditText) findViewById(R.id.editText2);
        sin=(Button) findViewById(R.id.sin);
        cos=(Button) findViewById(R.id.cos);
        tan=(Button) findViewById(R.id.tan);
        ln=(Button) findViewById(R.id.ln);
        log=(Button) findViewById(R.id.lg);
        pi=(Button) findViewById(R.id.pi);
        percent=(Button) findViewById(R.id.percentage);
        fact=(Button) findViewById(R.id.factorial);
        sqrt=(Button) findViewById(R.id.sqrt);
        power=(Button) findViewById(R.id.raiseto);
        complex=(Button) findViewById(R.id.i);
        exponential=(Button) findViewById(R.id.e);
        openBraces=(Button) findViewById(R.id.open_bracket);
        closedBraces=(Button) findViewById(R.id.close_bracket);
        //  back=(Button) findViewById(R.id.button);


        Intent intent = getIntent();
        finalResult = intent.getStringExtra("Result");
        editText2.setText(finalResult);

        clear.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                editText2.setText("");
            }
        });

        sin.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                Double number = Double.parseDouble(editText2.getText().toString());
                number = Math.sin(number);
                editText2.setText(number.toString());
            }
        });

        cos.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                Double number = Double.parseDouble(editText2.getText().toString());
                number = Math.cos(number);
                editText2.setText(number.toString());
            }
        });

        tan.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                Double number = Double.parseDouble(editText2.getText().toString());
                number = Math.tan(number);
                editText2.setText(number.toString());
            }
        });

        ln.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                Double number = Double.parseDouble(editText2.getText().toString());
                number = Math.log(number);
                editText2.setText(number.toString());
            }
        });

        log.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                Double number = Double.parseDouble(editText2.getText().toString());
                number = Math.log10(number);
                editText2.setText(number.toString());
            }
        });

        pi.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                if(editText2.getText().toString().isEmpty())
                {
                    Double number = Math.PI;
                    editText2.setText(number.toString());
                }
                else
                {
                    Double number = Double.parseDouble(editText2.getText().toString());
                    number = number * Math.PI;
                    editText2.setText(number.toString());
                }
            }
        });

        percent.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                Double number = Double.parseDouble(editText2.getText().toString());
                number = number/100;
                editText2.setText(number.toString());

            }
        });

        fact.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                Double number=Double.parseDouble(editText2.getText().toString());
                number= fact(number);
                editText2.setText(number.toString());


            }
        });

        sqrt.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                Double number = Double.parseDouble(editText2.getText().toString());
                number = Math.sqrt(number);
                editText2.setText(number.toString());

            }
        });

        power.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                String symbol = editText2.getText().toString();
                symbol+="^";
                editText2.setText(symbol);

                Intent intent = new Intent(Second_view.this,MainActivity.class);
                intent.putExtra("Power",editText2.getText().toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);

            }
        });



        complex.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

            }
        });

        openBraces.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

            }
        });

        closedBraces.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

            }
        });

        exponential.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                Double number = Double.parseDouble(editText2.getText().toString());
                number = Math.exp(number);
                editText2.setText(number.toString());


            }
        });






        back= (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Second_view.this, MainActivity.class);
                //intent.putExtra("score", 99);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
    }

    double fact(double n)
    {
        if(n==0 || n==1)
        {
            return 1;
        }
        else
        {
            return fact(n-1) * n;
        }
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
