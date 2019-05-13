package com.intern.filesharing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    EditText name,pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        name = findViewById(R.id.username);
        pwd = findViewById(R.id.password);
        Button b = findViewById(R.id.login);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                String p = pwd.getText().toString();
                if(TextUtils.isEmpty(n)||TextUtils.isEmpty(p)){
                    Toast.makeText(getApplicationContext(),"enter details",Toast.LENGTH_LONG)
                            .show();
                }
                else if(n.equals("Admin@reva.in")&&p.equals("Admin123")){
                    Intent i = new Intent(getApplicationContext(),AddStudent.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"enter valid details",Toast.LENGTH_SHORT)
                    .show();
                }
            }
        });
    }
}
