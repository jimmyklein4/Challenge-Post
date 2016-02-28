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
public class LoginActivity extends Activity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        username = (EditText) findViewById(R.id.edit_username);
        password = (EditText) findViewById(R.id.edit_password);

        Intent intent = getIntent();
        if(intent!=null){
            username.setText(intent.getStringExtra(RegistrationActivity.EXTRA_USERNAME));
        }
    }

    //TODO: Handle Login Properly
    public void sendLogin(View view){
        if(!(username.getText().toString().matches("") || password.getText().toString().matches(""))) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Please enter a username and password", Toast.LENGTH_LONG).show();
        }
    }

    public void sendRegister(View view){
        Intent rIntent = new Intent(this, RegistrationActivity.class);
        startActivity(rIntent);
        finish();
    }
}
