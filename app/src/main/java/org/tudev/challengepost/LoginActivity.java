package org.tudev.challengepost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by jimmyklein on 2/27/16.
 */
public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    //TODO: Handle Login Properly
    public void sendLogin(){

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
