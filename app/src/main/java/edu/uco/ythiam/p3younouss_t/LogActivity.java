package edu.uco.ythiam.p3younouss_t;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class LogActivity extends Activity {
    private TextView result;
    private String resultString = "";
    private ArrayList<String> gameList= new ArrayList<String>();
    private ArrayList<String> winList= new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        Bundle b = getIntent().getExtras();
        gameList = b.getStringArrayList("gameList");
        winList = b.getStringArrayList("winList");
        result = (TextView) findViewById(R.id.result);
        resultString += "#   Winner\n";
        for(int i = 0; i < gameList.size(); i++){
            resultString += gameList.get(i)+"   "+winList.get(i)+"\n";
        }
        result.setText(resultString);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_log, menu);
        // Inflate the menu; this adds items to the action bar if it is present.
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
