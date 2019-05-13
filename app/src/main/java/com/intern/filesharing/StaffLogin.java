package com.intern.filesharing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class StaffLogin extends AppCompatActivity {

    EditText id,pwd;
    Button login;
    Spinner b;
    String[] branch = new String[] {"Btech-CSE","Btech-CIVIL", "Btech-ECE", "Mtech-CSE",
            "Mtech-VLSI" , "MBA", "PhD-CSE", "PhD-CIVIL"} ;
    String br;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);
        b = findViewById(R.id.branch);
        id  = findViewById(R.id.id);
        pwd = findViewById(R.id.pwd);
        login = findViewById(R.id.login);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(StaffLogin.this,android.R.layout.simple_spinner_item,branch);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        b.setAdapter(adapter);
        b.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                br = b.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(id.getText().toString())||TextUtils.isEmpty(pwd.getText().toString())||TextUtils.isEmpty(br)){
                    Toast.makeText(getApplicationContext(),"enter password or id or branch",Toast.LENGTH_SHORT)
                            .show();
                }
                else{
                    String i = id.getText().toString();
                    String p = pwd.getText().toString();
                    if(br.equals("Btech-CSE") && i.equals("190011") && p.equals("bcse190011")){
                        Intent intent = new Intent(getApplicationContext(),CseFiles.class);
                        startActivity(intent);

                    }
                    else if(br.equals("Btech-CIVIL")&& i.equals("190012")&&p.equals("bcivil190012")){
                        Intent i1 = new Intent(getApplicationContext(),CivilFiles.class);
                        startActivity(i1);
                    }
                    else if(br.equals("Btech-ECE")&& i.equals("190013")&&p.equals("bece190013")){
                        Intent i1 = new Intent(getApplicationContext(),EceFiles.class);
                        startActivity(i1);
                    }
                    else if(br.equals("Mtech-CSE")&& i.equals("190021")&&p.equals("mcse190021")){
                        Intent i1 = new Intent(getApplicationContext(),MCse.class);
                        startActivity(i1);
                    }
                    else if(br.equals("Mtech-VLSI")&& i.equals("190022")&&p.equals("mvlsi190022")){
                       Intent i1 = new Intent(getApplicationContext(),MVlsi.class);
                        startActivity(i1);
                    }
                    else if(br.equals("MBA")&& i.equals("190023")&&p.equals("mba190023")){
                        Intent i1 = new Intent(getApplicationContext(),Mba.class);
                        startActivity(i1);
                    }
                    else if(br.equals("PhD-CSE")&& i.equals("190031")&&p.equals("pcse190031")){
                        Intent i1 = new Intent(getApplicationContext(),PCse.class);
                        startActivity(i1);
                    }
                    else if(br.equals("PhD-CIVIL")&& i.equals("190032")&&p.equals("pcivil190032")){
                        Intent i1 = new Intent(getApplicationContext(),PCivil.class);
                        startActivity(i1);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"enter valid details",Toast.LENGTH_LONG)
                                .show();
                    }
                }

            }
        });

    }
}
