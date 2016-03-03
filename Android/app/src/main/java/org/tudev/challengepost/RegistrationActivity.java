package org.tudev.challengepost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by jimmyklein on 2/27/16.
 */
public class RegistrationActivity extends Activity {

    //TODO: Implement registration

    public final static String EXTRA_USERNAME = "org.tudev.challengepost.USERNAME";

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_acitivty);
        username = (EditText) findViewById(R.id.edit_username);
        password = (EditText) findViewById(R.id.edit_password);
    }

    public void sendRegister(View view){
        if(!(username.getText().toString().matches("") || password.getText().toString().matches(""))){
            //TODO: Send registration to server
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra(EXTRA_USERNAME, username.getText().toString());
            startActivity(intent);
            finish();

        } else {
            //User did not both a username and password
            Toast.makeText(this, "Please enter a username and password", Toast.LENGTH_LONG).show();
        }
    }
}
