package com.intern.filesharing;

public class Student {
    public String name;
    public String branch;
    public String password;
    public String id;
     public String email;

    public Student() {
    }

    public Student( String name,String branch, String password, String id,String email) {
       this.name = name;
        this.branch = branch;
        this.password = password;
        this.id = id;
       this.email = email;
    }

     public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }
}
