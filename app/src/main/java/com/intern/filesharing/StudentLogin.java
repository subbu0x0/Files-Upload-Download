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

public class StudentLogin extends AppCompatActivity {

    EditText id, pwd;
    Button login;
    Spinner b;
    String[] branch = new String[]{"Btech-CSE", "Btech-CIVIL", "Btech-ECE", "Mtech-CSE",
            "Mtech-VLSI", "MBA", "PhD-CSE", "PhD-CIVIL"};
    String br;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("students");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        b = findViewById(R.id.branch);
        id = findViewById(R.id.id);
        pwd = findViewById(R.id.pwd);
        login = findViewById(R.id.login);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(StudentLogin.this, android.R.layout.simple_spinner_item, branch);
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
                if (TextUtils.isEmpty(pwd.getText().toString()) || TextUtils.isEmpty(id.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "enter details", Toast.LENGTH_SHORT).show();
                } else {
                    login();
                }

            }
        });

    }
    public void login(){
        final String i = id.getText().toString().trim();
        final String p = pwd.getText().toString().trim();
        final DatabaseReference itemsRef = mDatabase.child(br).child(i);
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!dataSnapshot.exists()){
                    Toast.makeText(getApplicationContext(), "user not found", Toast.LENGTH_SHORT)
                            .show();
                }
                else{

                    Student user = dataSnapshot.getValue(Student.class);
                    String pw = user.getPassword();
                    if(pw.equals(p)){
                        if(br.equals("Btech-CSE") ){
                            Intent intent = new Intent(getApplicationContext(),ViewFiles.class);
                            startActivity(intent);

                        }
                        else if(br.equals("Btech-CIVIL")){
                            Intent i1 = new Intent(getApplicationContext(),ViewFiles1.class);
                            startActivity(i1);
                        }
                        else if(br.equals("Btech-ECE")){
                             Intent i1 = new Intent(getApplicationContext(),ViewFiles2.class);
                            startActivity(i1);
                        }
                        else if(br.equals("Mtech-CSE")){
                             Intent i1 = new Intent(getApplicationContext(),ViewFiles4.class);
                            startActivity(i1);
                        }
                        else if(br.equals("Mtech-VLSI")){
                            Intent i1 = new Intent(getApplicationContext(),ViewFiles5.class);
                            startActivity(i1);
                        }
                        else if(br.equals("MBA")){
                            Intent i1 = new Intent(getApplicationContext(),ViewFiles3.class);
                            startActivity(i1);
                        }
                        else if(br.equals("PhD-CSE")){
                            Intent i1 = new Intent(getApplicationContext(),ViewFiles7.class);
                            startActivity(i1);
                        }
                        else if(br.equals("PhD-CIVIL")){
                            Intent i1 = new Intent(getApplicationContext(),ViewFiles6.class);
                            startActivity(i1);
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "wrong password", Toast.LENGTH_SHORT)
                                .show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        itemsRef.addListenerForSingleValueEvent(eventListener);

    }
}
