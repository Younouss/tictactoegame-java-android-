package edu.uco.ythiam.p3younouss_t;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TicTacToeActivity extends Activity {
    private TextView display;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    char turn = 'o';
    boolean winner = true;
    int i = 0;
    private ArrayList<String> gameList= new ArrayList<String>();
    private ArrayList<String> winList= new ArrayList<String>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        display = (TextView) findViewById(R.id.display);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        MyListener listen =  new MyListener();
        button1.setOnClickListener(listen);
        button2.setOnClickListener(listen);
        button3.setOnClickListener(listen);
        button4.setOnClickListener(listen);
        button5.setOnClickListener(listen);
        button6.setOnClickListener(listen);
        button7.setOnClickListener(listen);
        button8.setOnClickListener(listen);
        button9.setOnClickListener(listen);
        button10.setOnClickListener(listen);
        button11.setOnClickListener(listen);
    }
    private class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            if(v == button1) {
                Game(button1);
            }
            if(v == button2) {
               Game(button2);
            }
            if(v == button3) {
                Game(button3);
            }
            if(v == button4) {
                Game(button4);
            }
            if(v == button5) {
                Game(button5);
            }
            if(v == button6) {
                Game(button6);
            }
            if(v == button7) {
                Game(button7);
            }
            if(v == button8) {
                Game(button8);
            }
            if(v == button9) {
                Game(button9);
            }
            if(v == button10) {
                button1.setText("");
                button1.setEnabled(true);
                button2.setText("");
                button2.setEnabled(true);
                button3.setText("");
                button3.setEnabled(true);
                button4.setText("");
                button4.setEnabled(true);
                button5.setText("");
                button5.setEnabled(true);
                button6.setText("");
                button6.setEnabled(true);
                button7.setText("");
                button7.setEnabled(true);
                button8.setText("");
                button8.setEnabled(true);
                button9.setText("");
                button9.setEnabled(true);
                turn ='o';
                winner = false;
                display.setText("Play Tic-Tac-Toe: O's turn!");
            }
            if(v == button11){
                Bundle bundle = new Bundle();
                Intent intent = new Intent(TicTacToeActivity.this, LogActivity.class);
                if(i == 0) {
                    gameList = new ArrayList<String>();
                    gameList.add("");
                    winList = new ArrayList<String>();
                    winList.add("");
                    bundle.putStringArrayList("gameList", gameList);
                    bundle.putStringArrayList("winList", winList);
                }
                else {
                    bundle.putStringArrayList("gameList", gameList);
                    bundle.putStringArrayList("winList", winList);
                }
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tic_tac_toe, menu);
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
    private void Game(Button button){
        if(turn == 'o'&& (button.isEnabled() == true)){
            button.setText("O");
            button.setEnabled(false);
            turn = 'x';
            display.setText("Play Tic-Tac-Toe: X's turn!");
        }
        if(turn == 'x' && (button.isEnabled() == true)){
            button.setText("X");
            button.setEnabled(false);
            turn = 'o';
            display.setText("Play Tic-Tac-Toe: O's turn!");
        }
        if( ((button1.getText() == "O") && (button2.getText() == "O") && (button3.getText() == "O")) || ((button4.getText() == "O") && (button5.getText() == "O") && (button6.getText() == "O")) || ((button7.getText() == "O") && (button8.getText() == "O") && (button9.getText() == "O")) || ((button1.getText() == "O") && (button5.getText() == "O") && (button9.getText() == "O")) || ((button3.getText() == "O") && (button5.getText() == "O") && (button7.getText() == "O")) || ((button1.getText() == "O") && (button4.getText() == "O") && (button7.getText() == "O")) || ((button2.getText() == "O") && (button5.getText() == "O") && (button8.getText() == "O")) || ((button3.getText() == "O") && (button6.getText() == "O") && (button9.getText() == "O")) ) {
            display.setText("Game Over: Winner is O!");
            winner = true;
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            i+=1;
            gameList.add(Integer.toString(i));
            winList.add("O");
        }
        if( ((button1.getText() == "X") && (button2.getText() == "X") && (button3.getText() == "X")) || ((button4.getText() == "X") && (button5.getText() == "X") && (button6.getText() == "X")) || ((button7.getText() == "X") &&  (button8.getText() == "X") && (button9.getText() == "X")) || ((button1.getText() == "X") && (button5.getText() == "X") && (button9.getText() == "X")) || ((button3.getText() == "X") && (button5.getText() == "X") && (button7.getText() == "X")) || ((button1.getText() == "X") && (button4.getText() == "X") && (button7.getText() == "X")) || ((button2.getText() == "X") && (button5.getText() == "X") && (button8.getText() == "X")) || ((button3.getText() == "X") && (button6.getText() == "X") && (button9.getText() == "X")) ){
            display.setText("Game Over: Winner is X!");
            winner = true;
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
            i+=1;
            gameList.add(Integer.toString(i));
            winList.add("X");
        }
        if( (button1.isEnabled() == false) && (button2.isEnabled() == false) && (button3.isEnabled() == false) && (button4.isEnabled() == false) && (button5.isEnabled() == false) && (button6.isEnabled() == false) && (button7.isEnabled() == false) && (button8.isEnabled() == false) && (button9.isEnabled() == false) && (winner == false)){
            display.setText("Game Over: Tie - No winner!");
            i+=1;
            gameList.add(Integer.toString(i));
            winList.add("Draw");
        }
    }
}
