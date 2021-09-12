package com.athrved.masterclass;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FacebookProfile extends AppCompatActivity {

    private TextView mail;
    private EditText name, phone, bio;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();
    Button logOutBtn, saveBtn;
    private String Name;
    private String Email;
    private String Bio;
    private long Phone;
    private ProgressBar progressBarOfFacebookProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_profile);

        logOutBtn = findViewById(R.id.logOutBtnInFacebookProfile);
        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);

        phone = findViewById(R.id.phone);
        bio = findViewById(R.id.bio);
        saveBtn = findViewById(R.id.SaveBtn);
        progressBarOfFacebookProfile = findViewById(R.id.progressbarofFacebookProfile);

        bio.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                // If line account is higher than MAX_LINES, set text to lastText
                // and notify user (by Toast)
                if (bio.length() > 99) {
                    Toast.makeText(getApplicationContext(), "Maximum characters exceeded", Toast.LENGTH_SHORT).show();
                }
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validatePhoneNo() | !validateName()) {
                    return;
                } else {
                    progressBarOfFacebookProfile.setVisibility(View.VISIBLE);

                    Name = name.getText().toString();
                    Email = mail.getText().toString();
                    Phone = new Long(phone.getText().toString()).longValue();
                    Bio = bio.getText().toString();

                    Database db = new Database();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                    finish();
                }

            }
        });

        if (user != null) {
            name.setText(user.getDisplayName());
            mail.setText(user.getEmail());
        }

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                LoginManager.getInstance().logOut();
                openLogin();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (user == null) {
            openLogin();
        }
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
                String sql = "INSERT INTO USERS (EMAIL,USERNAME,PHONE,BIO) "
                        + "VALUES ('" + Email + "','" + Name + "'," + Phone + ",'" + Bio + "')";
                stmt.executeUpdate(sql);


                stmt.close();
                c.commit();
                c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Records created successfully");
            return c;

        }
    }

    private Boolean validatePhoneNo() {
        String val = phone.getText().toString();

        if (val.isEmpty()) {
            phone.setError("Field cannnot be empty");
            return false;
        } else {
            phone.setError(null);
            return true;
        }

    }

    private Boolean validateName() {
        String val = name.getText().toString();

        if (val.isEmpty()) {
            name.setError("Field cannnot be empty");
            return false;
        } else {
            name.setError(null);
            return true;
        }

    }

}
