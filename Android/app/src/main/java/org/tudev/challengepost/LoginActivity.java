package org.tudev.challengepost;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

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
        Firebase.setAndroidContext(this);
        DataHandler.getInstance();
        username = (EditText) findViewById(R.id.edit_username);
        password = (EditText) findViewById(R.id.edit_password);

        Intent intent = getIntent();
        if(intent!=null){
            username.setText(intent.getStringExtra(RegistrationActivity.EXTRA_USERNAME));
        }
    }

    public void sendLogin(View view){
        if(!(username.getText().toString().matches("") )) {
            final String uname = username.getText().toString();
            final String pass = password.getText().toString();
            DataHandler data = DataHandler.getInstance();

            Firebase fb = new Firebase(data.dataURI + "users");
            fb.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.getValue() == null) {
                        Toast.makeText(LoginActivity.this,"Incorrect Login", Toast.LENGTH_LONG).show();
                    } else {
                        for(DataSnapshot snap : dataSnapshot.getChildren()){
                            if(snap.getValue(String.class).equals(uname.toLowerCase())) {
                                DataHandler.getInstance().setLogin(uname.toLowerCase(), false);
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        } else {
            Toast.makeText(this, "Please enter a username and password", Toast.LENGTH_LONG).show();
        }
    }

    public void sendRegisterAction(View view){
        Intent rIntent = new Intent(this, RegistrationActivity.class);
        startActivity(rIntent);
        finish();
    }
}
