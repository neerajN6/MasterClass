package com.athrved.masterclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateProfile extends AppCompatActivity {

    private TextView mail;
    private EditText name, phone, bio;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();
    Button logOutBtn, updateBtn;
    private String Name;
    private String Email;
    private String Bio;
    private long PHONE;
    String PHONENO, MAIL, Phone, getnumber, NAME, EMAIL, BIO;
    private ProgressBar progressBarOfUpdateProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        mail = findViewById(R.id.mail);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        bio = findViewById(R.id.bio);
        logOutBtn = findViewById(R.id.logOutBtn);
        updateBtn = findViewById(R.id.updateBtn);
        progressBarOfUpdateProfile = findViewById(R.id.progressbarofUpdateProfile);

        if (user != null) {
            name.setText(user.getDisplayName());
            mail.setText(user.getEmail());
            phone.setText(user.getPhoneNumber());
            PHONENO = user.getPhoneNumber();
            MAIL = user.getEmail();
        }

        if (PHONENO != null) {
            if (PHONENO.length() > 10) {
                int startidx = PHONENO.length() - 10;
                getnumber = PHONENO.substring(startidx, PHONENO.length());
                phone.setText(getnumber);
            } else {
                phone.setText(Phone);
            }
        }

        Database db = new Database();

        name.setText(Name);
        bio.setText(Bio);
        phone.setText(Phone);
        mail.setText(Email);


        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                LoginManager.getInstance().logOut();
                openLogin();
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBarOfUpdateProfile.setVisibility(View.VISIBLE);
                NAME = name.getText().toString();
                EMAIL = mail.getText().toString();
                PHONE = new Long(phone.getText().toString()).longValue();
                BIO = bio.getText().toString();
                Database2 db = new Database2();
                Toast.makeText(getApplicationContext(), "Profile Updated Successfully", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void openLogin() {
        startActivity(new Intent(this, SignUp.class));
        finish();
    }

    private class Database {

        private Connection connection;

        private final String host = "ec2-54-158-232-223.compute-1.amazonaws.com";
        private final String database = "ddgaguv61p4m63";
        private final int port = 5432;
        private final String user = "jfeitasqnyuanh";
        private final String pass = "d60b43b4e9ea924c91deb754cf18a51d5948b7a7e58b4e4d0045487767174ad8";
        private String url = "jdbc:postgresql://ec2-54-158-232-223.compute-1.amazonaws.com:5432/ddgaguv61p4m63?sslmode=require&user=jfeitasqnyuanh&password=d60b43b4e9ea924c91deb754cf18a51d5948b7a7e58b4e4d0045487767174ad8";
        private boolean status;

        public Database() {

            this.url = String.format(this.url, this.host, this.port, this.database);
            connect();
            //this.disconnect();
            System.out.println("connection status:" + status);
        }


        private void connect() {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Class.forName("org.postgresql.Driver");
                        connection = DriverManager.getConnection(url, user, pass);
                        status = true;
                        getExtraConnection();
                        System.out.println("connected:" + status);
                    } catch (Exception e) {
                        status = false;
                        System.out.print(e.getMessage());
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
                this.status = false;
            }
        }

        public Connection getExtraConnection() {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection(url, user, pass);
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE EMAIL = '" + MAIL + "' OR PHONE = " + getnumber + ";");
                while (rs.next()) {
                    Name = rs.getString("USERNAME");
                    Bio = rs.getString("BIO");
                    Phone = String.valueOf(rs.getLong("PHONE"));
                    Email = rs.getString("EMAIL");
                    System.out.println("NAME = " + Name);
                    System.out.println("BIO = " + Bio);
                    System.out.println("PHONE = " + Phone);
                    System.out.println();
                }
                rs.close();
                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Records created successfully");
            return c;

        }
    }

    private class Database2 {

        private Connection connection;

        private final String host = "ec2-54-158-232-223.compute-1.amazonaws.com";
        private final String database = "ddgaguv61p4m63";
        private final int port = 5432;
        private final String user = "jfeitasqnyuanh";
        private final String pass = "d60b43b4e9ea924c91deb754cf18a51d5948b7a7e58b4e4d0045487767174ad8";
        private String url = "jdbc:postgresql://ec2-54-158-232-223.compute-1.amazonaws.com:5432/ddgaguv61p4m63?sslmode=require&user=jfeitasqnyuanh&password=d60b43b4e9ea924c91deb754cf18a51d5948b7a7e58b4e4d0045487767174ad8";
        private boolean status;

        public Database2() {

            this.url = String.format(this.url, this.host, this.port, this.database);
            progressBarOfUpdateProfile.setVisibility(View.VISIBLE);
            connect();
            //this.disconnect();
            System.out.println("connection status:" + status);
        }


        private void connect() {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Class.forName("org.postgresql.Driver");
                        connection = DriverManager.getConnection(url, user, pass);
                        status = true;
                        getExtraConnection();
                        System.out.println("connected:" + status);
                    } catch (Exception e) {
                        status = false;
                        System.out.print(e.getMessage());
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
                this.status = false;
            }
        }

        public Connection getExtraConnection() {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection(url, user, pass);
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                String sql = "UPDATE USERS set USERNAME = '" + NAME + "' , PHONE = " + PHONE + " , BIO = '" + BIO + "' where EMAIL = '" + EMAIL + "';";
                stmt.executeUpdate(sql);
                c.commit();

                ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE EMAIL = '" + MAIL + "' OR PHONE = " + getnumber + ";");
                while (rs.next()) {
                    Name = rs.getString("USERNAME");
                    Bio = rs.getString("BIO");
                    Phone = String.valueOf(rs.getLong("PHONE"));
                    Email = rs.getString("EMAIL");
                    System.out.println("NAME = " + Name);
                    System.out.println("BIO = " + Bio);
                    System.out.println("PHONE = " + Phone);
                    System.out.println();
                }
                rs.close();
                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Records created successfully");
            progressBarOfUpdateProfile.setVisibility(View.INVISIBLE);
            return c;

        }
    }
}