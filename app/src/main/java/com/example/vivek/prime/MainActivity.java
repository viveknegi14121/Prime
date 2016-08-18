package com.example.vivek.prime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    static int correctcounts=0,incorrectcounts=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null)
        {
            Button correct=(Button)findViewById(R.id.correct);
            Button incorrect=(Button)findViewById(R.id.incorrect);

            int btn=savedInstanceState.getInt("btntoggle");
            if(btn==1)
            {
                correct.setEnabled(true);
                incorrect.setEnabled(true);
            }
            else
            {
                correct.setEnabled(false);
                incorrect.setEnabled(false);
            }
            int number=savedInstanceState.getInt("currentnumber");
            TextView num=(TextView)findViewById(R.id.number);
            TextView no_correct_count=(TextView)findViewById(R.id.no_correct_count);
            TextView no_incorrect_count=(TextView)findViewById(R.id.no_incorrect_count);
            num.setText(Integer.toString(number));
            no_correct_count.setText(Integer.toString(correctcounts));
            no_incorrect_count.setText(Integer.toString(incorrectcounts));
        }
        else{
            TextView num=(TextView)findViewById(R.id.number);
            Random rn = new Random();
            int randomNum =  rn.nextInt(1001);
            num.setText(Integer.toString(randomNum));
        }
    }

    public void oncn(View v)
    {
        Button correct=(Button)findViewById(R.id.correct);
        Button incorrect=(Button)findViewById(R.id.incorrect);
        TextView num=(TextView)findViewById(R.id.number);
        Random rn = new Random();
        int randomNum =  rn.nextInt(1001);
        num.setText(Integer.toString(randomNum));
        correct.setEnabled(true);
        incorrect.setEnabled(true);
    }

    public void oncc(View v)
    {
        TextView a=(TextView)findViewById(R.id.number);
        TextView no_correct_count=(TextView)findViewById(R.id.no_correct_count);
        TextView no_incorrect_count=(TextView)findViewById(R.id.no_incorrect_count);
        Button correct=(Button)findViewById(R.id.correct);
        Button incorrect=(Button)findViewById(R.id.incorrect);
        int n=Integer.parseInt(a.getText().toString());
        int c1=0;
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0) {
                c1++;
                break;
            }
        }
        if(c1==0)
        {
            correctcounts++;
            Toast.makeText(getApplicationContext(),"Bravo!!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            incorrectcounts++;
            Toast.makeText(getApplicationContext(), "Oops!!",Toast.LENGTH_SHORT).show();
        }
        correct.setEnabled(false);
        incorrect.setEnabled(false);
        no_correct_count.setText(Integer.toString(correctcounts));
        no_incorrect_count.setText(Integer.toString(incorrectcounts));
    }

    public void onci(View v)
    {
        TextView a=(TextView)findViewById(R.id.number);
        TextView no_correct_count=(TextView)findViewById(R.id.no_correct_count);
        TextView no_incorrect_count=(TextView)findViewById(R.id.no_incorrect_count);
        int n=Integer.parseInt(a.getText().toString());
        //a.setText(Integer.toString(randomNum));
        Button correct=(Button)findViewById(R.id.correct);
        Button incorrect=(Button)findViewById(R.id.incorrect);
        int c1=0;
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0) {
                c1++;
                break;
            }
        }
        if(c1==1)
        {
            correctcounts++;
            Toast.makeText(getApplicationContext(), "Bravo!!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            incorrectcounts++;
            Toast.makeText(getApplicationContext(), "Oops!!",Toast.LENGTH_SHORT).show();
        }
        correct.setEnabled(false);
        incorrect.setEnabled(false);
        no_correct_count.setText(Integer.toString(correctcounts));
        no_incorrect_count.setText(Integer.toString(incorrectcounts));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        Button correct=(Button)findViewById(R.id.correct);
        if(correct.isEnabled())
            outState.putInt("btntoggle",1);
        else
            outState.putInt("btntoggle",0);

        TextView a=(TextView)findViewById(R.id.number);
        int n=Integer.parseInt(a.getText().toString());
        outState.putInt("currentnumber",n);
    }
}
