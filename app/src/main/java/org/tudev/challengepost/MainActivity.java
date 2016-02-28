package org.tudev.challengepost;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    //TODO: Get these values from the server
    private String[] challenges = {"Challenge1","Challenge2","Challenge3"};
    private String[] feed = {"Feed1","Feed2","Feed3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter challengeAdapter = new ArrayAdapter<>(this, R.layout.challenge_listview, challenges);
        ArrayAdapter feedAdapter = new ArrayAdapter<>(this, R.layout.feed_listview, feed);

        ListView challengeListView = (ListView) findViewById(R.id.listChallenges);
        ListView feedListView = (ListView) findViewById(R.id.listFeed);

        challengeListView.setAdapter(challengeAdapter);
        feedListView.setAdapter(feedAdapter);
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
