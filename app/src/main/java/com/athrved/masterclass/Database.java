package com.athrved.masterclass;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private Connection connection;

    // private final String host = "ssprojectinstance.csv2nbvvgbcb.us-east-2.rds.amazonaws.com"  // For Amazon Postgresql
    private final String host = "ec2-54-158-232-223.compute-1.amazonaws.com";  // For Google Cloud Postgresql
    private final String database = "ddgaguv61p4m63";
    private final int port = 5432;
    private final String user = "jfeitasqnyuanh";
    private final String pass = "d60b43b4e9ea924c91deb754cf18a51d5948b7a7e58b4e4d0045487767174ad8";
    private String url = "postgres://jfeitasqnyuanh:d60b43b4e9ea924c91deb754cf18a51d5948b7a7e58b4e4d0045487767174ad8@ec2-54-158-232-223.compute-1.amazonaws.com:5432/ddgaguv61p4m63";
    private boolean status;

    public Database() {
        this.url = String.format(this.url, this.host, this.port, this.database);
        connect();
        //this.disconnect();
        System.out.println("The Connection status:" + status);
    }

    private void connect() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
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
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }
}