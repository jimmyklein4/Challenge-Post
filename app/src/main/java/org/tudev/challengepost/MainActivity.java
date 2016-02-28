package org.tudev.challengepost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //TODO: Get these values from the server
    private String[] challenges = {"Challenge1","Challenge2","Challenge3"};
    private String[] feed = {"Feed1","Feed2","Feed3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter challengeAdapter = new ArrayAdapter<>(this, R.layout.challenge_listview, challenges);
        ArrayAdapter feedAdapter = new ArrayAdapter<>(this, R.layout.feed_listview, feed);

        ListView challengeListView = (ListView) findViewById(R.id.listChallenges);
        ListView feedListView = (ListView) findViewById(R.id.listFeed);


        challengeListView.setAdapter(challengeAdapter);
        feedListView.setAdapter(feedAdapter);

        challengeListView.setOnItemClickListener(challengeClickListener);
        feedListView.setOnItemClickListener(feedClickListener);
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


        return super.onOptionsItemSelected(item);
    }

    private AdapterView.OnItemClickListener challengeClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //TODO: Should move into a view of the challenge
            Toast.makeText(MainActivity.this, position+"",Toast.LENGTH_LONG).show();
        }
    };

    private AdapterView.OnItemClickListener feedClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //TODO: Should move into a view of the user
        }
    };
}
