package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    public void on_Button_Click(View view){
        int guess;
        android.widget.TextView tv = this.findViewById(R.id.textView); //Random number output text
        android.widget.TextView et = this.findViewById(R.id.editText); //User input
        android.widget.TextView c = this.findViewById(R.id.congrats); //Congrats message

        String guessStr = String.valueOf(et.getText());
        if((!guessStr.equals("1"))&&(!guessStr.equals("2"))&&(!guessStr.equals("3"))&&(!guessStr.equals("4"))&&(!guessStr.equals("5"))&&(!guessStr.equals("6"))){
            c.setText("Error: Input 1-6");
        }
        else {
            guess = Integer.parseInt(guessStr);
            //Random generator
            Random r = new Random();
            int number = r.nextInt(6);
            //Stops 0 from being outputted
            while (number == 0) {
                number = r.nextInt(6);
            }

            if (number == guess) {
                c.setText("Congratulations!");
            } else {
                c.setText("Wrong");
            }


            tv.setText(Integer.toString(number));
        }



    }
}
