package com.example.diceroller;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

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

    public void roll_the_dice(View view){
        int guess;
        android.widget.TextView tv = this.findViewById(R.id.textView); //Random number output text
        android.widget.TextView et = this.findViewById(R.id.editText); //User input
        android.widget.TextView c = this.findViewById(R.id.congrats); //Congrats message
        android.widget.TextView sc = this.findViewById(R.id.score); //Score text
        android.widget.TextView qu = this.findViewById(R.id.questionTextView);// D-ICEBREAKER question

        int score = Integer.parseInt(String.valueOf(sc.getText()));
        String guessStr = String.valueOf(et.getText()); //String variant of guess used so program doesn't crash on non-integer inputs
        if((!guessStr.equals("1"))&&(!guessStr.equals("2"))&&(!guessStr.equals("3"))&&(!guessStr.equals("4"))&&(!guessStr.equals("5"))&&(!guessStr.equals("6"))){
            c.setText("Error: Input 1-6");
        }
        else {
            guess = Integer.parseInt(guessStr);
            int number = randomNumber(); //gets random number from method

            if (number == guess) {
                c.setText("Congratulations! +1");
                score += 1;
            } else {
                score -= 1;
                c.setText("Wrong! -1");
            }

            sc.setText(Integer.toString(score));
            tv.setText(Integer.toString(number));

            if(qu.getVisibility()==View.VISIBLE){
                questionSet(qu, tv);
            }
        }




    }

    //Method to generare random number
    private int randomNumber() {
        //Random generator
        Random r = new Random();
        int number = r.nextInt(6);
        //Stops 0 from being outputted
        while (number == 0) {
            number = r.nextInt(6);
        }
        return number;
    }

    public void questionSet(android.widget.TextView qu, android.widget.TextView tv){
        if(String.valueOf(tv.getText()).equals("1")){
            qu.setText("If you could go anywhere in the world, where would you go?");
        }
        else if(String.valueOf(tv.getText()).equals("2")){
            qu.setText("If you were stranded on a desert island, what three things would you want to take with you?");
        }
        else if(String.valueOf(tv.getText()).equals("3")){
            qu.setText("If you could eat only one food for the rest of your life, what would that be?");
        }
        else if(String.valueOf(tv.getText()).equals("4")){
            qu.setText("If you won a million dollars, what is the first thing you would buy?");
        }
        else if(String.valueOf(tv.getText()).equals("5")){
            qu.setText("If you could spaned the day with one fictional character, who would it be?");
        }
        else if(String.valueOf(tv.getText()).equals("6")){
            qu.setText("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
        }
        else{
            qu.setText("");
        }

    }

    public void on_click_icebreaker(View view){
        android.widget.TextView qu = this.findViewById(R.id.questionTextView);
        android.widget.TextView tv = this.findViewById(R.id.textView);

        if(qu.getVisibility()==View.INVISIBLE){
            qu.setVisibility(View.VISIBLE);
            questionSet(qu, tv);
        }
        else{
            qu.setVisibility(View.INVISIBLE);
        }
    }

    public void onClickAddRule(View view){
        startActivity(new Intent(MainActivity.this, addDICEBREAKER.class));

    }
}
