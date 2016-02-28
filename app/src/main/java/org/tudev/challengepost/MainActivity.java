package org.tudev.challengepost;

import android.content.Intent;
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

    public final static String EXTRA_DISCRIPTION = "org.tudev.challengepost.DISCRIPTION";

    //TODO: Get these values from the server
    private String[] challenges = {"Challenge1","Challenge2","Challenge3", "Challenge4","Challenge5"};
    private ListView challengeListView;
    private ArrayAdapter challengeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        challengeAdapter = new ArrayAdapter<>(this, R.layout.challenge_listview, challenges);

        challengeListView = (ListView) findViewById(R.id.listChallenges);


        challengeListView.setAdapter(challengeAdapter);

        challengeListView.setOnItemClickListener(challengeClickListener);
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
        if(id==R.id.menu_feed) {
            Intent intent = new Intent(this, FeedView.class);
            startActivity(intent);
            finish();
        }
        if(id==R.id.menu_user){
            Intent intent = new Intent(this, UserActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private AdapterView.OnItemClickListener challengeClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //TODO: Should move into a view of the challenge
            Intent intent = new Intent(MainActivity.this,  ChallengeItemView.class);
            intent.putExtra(EXTRA_DISCRIPTION, challengeAdapter.getItem(position).toString());
            startActivity(intent);


            //Toast.makeText(MainActivity.this, challengeAdapter.getItem(position).toString() ,Toast.LENGTH_LONG).show();
        }
    };


}
