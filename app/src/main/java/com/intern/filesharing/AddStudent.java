package com.intern.filesharing;

import android.content.Intent;
import android.support.annotation.NonNull;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddStudent extends AppCompatActivity {

    EditText id, pwd,name,mail;
    Button login;
    Spinner b;
    String[] branch = new String[]{"Btech-CSE", "Btech-CIVIL", "Btech-ECE", "Mtech-CSE",
            "Mtech-VLSI", "MBA", "PhD-CSE", "PhD-CIVIL"};
    String br;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("students");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        b = findViewById(R.id.branch);
        id = findViewById(R.id.id);
        pwd = findViewById(R.id.pwd);
        login = findViewById(R.id.login);
        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(AddStudent.this, android.R.layout.simple_spinner_item, branch);
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
                if (TextUtils.isEmpty(pwd.getText().toString()) || TextUtils.isEmpty(id.getText().toString())|| TextUtils.isEmpty(name.getText().toString())||TextUtils.isEmpty(mail.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "enter details", Toast.LENGTH_SHORT).show();
                } else {
                    login();
                }

            }
        });

    }
    public void login(){
        final String i = (id.getText().toString().trim());
        final String p = pwd.getText().toString().trim();
        String n = name.getText().toString();
        String m = mail.getText().toString();
        final DatabaseReference itemsRef = mDatabase.child(br).child(i);
       Student s = new Student(n,br,p,i,m);
        itemsRef.setValue(s);
        Toast.makeText(this,"successful registration",Toast.LENGTH_LONG).show();
    }
}

