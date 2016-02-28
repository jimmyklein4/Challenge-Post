package org.tudev.challengepost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Jimmy Klein on 2/28/16.
 */
public class ChallengeItemView extends AppCompatActivity {

    private TextView discription;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge_item_view);
        Intent intent = getIntent();

        discription = (TextView) findViewById(R.id.challenge_title);

        discription.setText(intent.getStringExtra(MainActivity.EXTRA_DISCRIPTION));

    }

    private void challengeCompleted(){
        //TODO: Add the fact that you finished into your profile
        finish();
    }
}
