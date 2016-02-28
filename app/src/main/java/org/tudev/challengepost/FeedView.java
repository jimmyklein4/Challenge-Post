package org.tudev.challengepost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

    private AdapterView.OnItemClickListener feedClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //TODO: Should move into a view of the user
        }
    };
}
