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

/**
 * Created by jimmyklein on 2/28/16.
 */
public class FeedView extends AppCompatActivity {

    private String[] feed = {"Feed1","Feed2","Feed3","Feed4","Feed5"};

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter feedAdapter = new ArrayAdapter<>(this, R.layout.feed_listview, feed);
        ListView feedListView = (ListView) findViewById(R.id.listFeed);

        feedListView.setAdapter(feedAdapter);

        feedListView.setOnItemClickListener(feedClickListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_feed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(R.id.menu_challenges==id){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private AdapterView.OnItemClickListener feedClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //TODO: Should move into a view of the user
        }
    };
}
